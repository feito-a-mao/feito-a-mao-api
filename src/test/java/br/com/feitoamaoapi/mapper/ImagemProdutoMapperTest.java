package br.com.feitoamaoapi.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.feitoamaoapi.entity.Imagem;
import br.com.feitoamaoapi.entity.ImagemProduto;
import br.com.feitoamaoapi.entity.Produto;

public class ImagemProdutoMapperTest {

	@Test
	public void testFromProdutoAndImagemToImagemProduto() {
		Produto produto = new Produto();
		produto.setId(1L);

		Imagem imagem = new Imagem();
		imagem.setId(1L);

		ImagemProduto imagemProduto = ImagemProdutoMapper.fromProdutoAndImagemToImagemProduto(produto, imagem);

		assertEquals(produto.getId(), imagemProduto.getIdProduto());
		assertEquals(imagem.getId(), imagemProduto.getIdImagem());
	}

}
