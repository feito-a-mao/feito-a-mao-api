package br.com.feitoamaoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.feitoamaoapi.dto.ImagemDTO;
import br.com.feitoamaoapi.dto.ProdutoDTO;
import br.com.feitoamaoapi.entity.Imagem;
import br.com.feitoamaoapi.entity.ImagemProduto;
import br.com.feitoamaoapi.entity.Produto;
import br.com.feitoamaoapi.mapper.ImagemMapper;
import br.com.feitoamaoapi.repository.ImagemProdutoRepository;
import br.com.feitoamaoapi.repository.ImagemRepository;

@Service
public class ImagemProdutoServiceImpl implements ImagemProdutoService {

	private final ImagemRepository imagemRepository;
	private final ImagemProdutoRepository imagemProdutoRepository;

	@Autowired
	public ImagemProdutoServiceImpl(final ImagemRepository imagemRepository,
			final ImagemProdutoRepository imagemProdutoRepository) {
		this.imagemRepository = imagemRepository;
		this.imagemProdutoRepository = imagemProdutoRepository;
	}

	@Override
	public List<ImagemDTO> getImagensProduto(ProdutoDTO produto) {
		Specification<Imagem> specification = Specification.where(ImagemRepository.hasIdProduto(produto.getId()));
		List<Imagem> imagens = imagemRepository.findAll(specification);
		return ImagemMapper.toDTOList(imagens);
	}

	@Override
	public ImagemDTO salvarImagemProduto(Produto produto, ImagemDTO imagemDTO) {
		Imagem newImagem = imagemRepository.save(ImagemMapper.fromDTOtoEntity(imagemDTO));

		ImagemProduto newImagemProduto = new ImagemProduto(null, produto.getId(), newImagem.getId());
		imagemProdutoRepository.save(newImagemProduto);

		return ImagemMapper.fromEntityToDTO(newImagem);
	}

}
