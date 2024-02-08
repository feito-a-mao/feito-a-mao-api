package br.com.feitoamaoapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import br.com.feitoamaoapi.dto.ImagemDTO;
import br.com.feitoamaoapi.dto.ProdutoDTO;
import br.com.feitoamaoapi.dto.ProdutoParameters;
import br.com.feitoamaoapi.entity.Produto;
import br.com.feitoamaoapi.infra.dto.BaseDTO;
import br.com.feitoamaoapi.infra.dto.PaginaDTO;
import br.com.feitoamaoapi.infra.service.AbstractCrudService;
import br.com.feitoamaoapi.mapper.ProdutoMapper;
import br.com.feitoamaoapi.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl extends AbstractCrudService<Produto, ProdutoDTO> implements ProdutoService {

	private final ProdutoRepository produtoRepository;

	private final ImagemProdutoService imagemProdutoService;

	@Autowired
	public ProdutoServiceImpl(final ProdutoRepository produtoRepository,
			final ImagemProdutoService imagemProdutoService) {
		this.produtoRepository = produtoRepository;
		this.imagemProdutoService = imagemProdutoService;
	}

	@Override
	public ProdutoDTO salvar(ProdutoDTO dto) {
		Produto entity = produtoRepository.save(ProdutoMapper.fromDTOtoEntity(dto));
		salvarImagensProduto(entity, dto);

		ProdutoDTO newDTO = ProdutoMapper.fromEntityToDTO(entity);
		newDTO.setImagens(dto.getImagens());
		return newDTO;
	}

	@Override
	public PaginaDTO<ProdutoDTO> recuperarTodos(ProdutoParameters parameters, Integer offset, Integer limit,
			String ordenacao) {
		PaginaDTO<ProdutoDTO> produtos = super.recuperarTodos(parameters, offset, limit, ordenacao);

		carregarImagensProduto(produtos);

		return produtos;
	}

	public void salvarImagensProduto(Produto produto, ProdutoDTO dto) {
		if (dto.getImagens() == null) {
			return;
		}

		List<ImagemDTO> listaImagens = dto.getImagens().stream().map(imagem -> {
			if (imagem.getId() == null) {
				return imagemProdutoService.salvarImagemProduto(produto, imagem);
			} else {
				return imagem;
			}
		}).collect(Collectors.toList());

		dto.setImagens(listaImagens);
	}

	private void carregarImagensProduto(PaginaDTO<ProdutoDTO> produtos) {
		produtos.getItens().stream().forEach(produto -> {
			produto.setImagens(imagemProdutoService.getImagensProduto(produto));
		});
	}

	@Override
	protected JpaSpecificationExecutor<Produto> getSpecificationExecutor() {
		return produtoRepository;
	}

	@Override
	protected ProdutoDTO mapEntityToDTO(Produto entity) {
		return ProdutoMapper.fromEntityToDTO(entity);
	}

	@Override
	protected Specification<Produto> buildSpecification(BaseDTO baseDTO) {
		ProdutoParameters params = (ProdutoParameters) baseDTO;
		return Specification.where(ProdutoRepository.hasNomeProduto(params.getNomeProduto()))
				.and(ProdutoRepository.hasNomeVendedor(params.getNomeVendedor()));
	}
}
