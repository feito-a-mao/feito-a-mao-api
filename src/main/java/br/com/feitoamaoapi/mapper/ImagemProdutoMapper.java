package br.com.feitoamaoapi.mapper;

import br.com.feitoamaoapi.entity.Imagem;
import br.com.feitoamaoapi.entity.ImagemProduto;
import br.com.feitoamaoapi.entity.Produto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ImagemProdutoMapper {

	public static ImagemProduto fromProdutoAndImagemToImagemProduto(Produto produto, Imagem imagem) {
		return ImagemProduto.builder()//
				.idImagem(imagem.getId())//
				.idProduto(produto.getId())//
				.build();
	}
}
