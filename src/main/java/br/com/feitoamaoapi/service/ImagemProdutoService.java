package br.com.feitoamaoapi.service;

import java.util.List;

import br.com.feitoamaoapi.dto.ImagemDTO;
import br.com.feitoamaoapi.dto.ProdutoDTO;

public interface ImagemProdutoService {

	List<ImagemDTO> getImagensProduto(ProdutoDTO produto);

}
