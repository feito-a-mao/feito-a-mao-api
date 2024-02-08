package br.com.feitoamaoapi.service;

import java.util.List;

import br.com.feitoamaoapi.dto.ImagemDTO;
import br.com.feitoamaoapi.dto.ProdutoDTO;
import br.com.feitoamaoapi.entity.Produto;

public interface ImagemProdutoService {

	List<ImagemDTO> getImagensProduto(ProdutoDTO produto);

	public ImagemDTO salvarImagemProduto(Produto produto, ImagemDTO imagem);
}
