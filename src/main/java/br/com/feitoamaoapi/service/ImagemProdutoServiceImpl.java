package br.com.feitoamaoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.feitoamaoapi.dto.ImagemDTO;
import br.com.feitoamaoapi.dto.ProdutoDTO;
import br.com.feitoamaoapi.entity.Imagem;
import br.com.feitoamaoapi.mapper.ImagemMapper;
import br.com.feitoamaoapi.repository.ImagemRepository;

@Service
public class ImagemProdutoServiceImpl implements ImagemProdutoService {

	private final ImagemRepository imagemRepository;

	@Autowired
	public ImagemProdutoServiceImpl(final ImagemRepository imagemRepository) {
		this.imagemRepository = imagemRepository;
	}

	@Override
	public List<ImagemDTO> getImagensProduto(ProdutoDTO produto) {
		Specification<Imagem> specification = Specification.where(ImagemRepository.hasIdProduto(produto.getId()));
		List<Imagem> imagens = imagemRepository.findAll(specification);
		return ImagemMapper.toDTOList(imagens);
	}

}
