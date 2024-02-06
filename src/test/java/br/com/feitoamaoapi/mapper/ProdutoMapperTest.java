package br.com.feitoamaoapi.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.feitoamaoapi.dto.ProdutoDTO;
import br.com.feitoamaoapi.entity.Produto;

public class ProdutoMapperTest {

	@Test
	public void testFromEntityToDTO() {
		Produto produto = new Produto();
		produto.setId(1L);
		produto.setDescricao("Test Produto");

		ProdutoDTO dto = ProdutoMapper.fromEntityToDTO(produto);

		assertEquals(produto.getId(), dto.getId());
		assertEquals(produto.getDescricao(), dto.getDescricao());
	}

	@Test
	public void testFromEntityToDTONull() {
		Produto produto = null;

		ProdutoDTO dto = ProdutoMapper.fromEntityToDTO(produto);

		assertEquals(null, dto);
	}

	@Test
	public void testFromDTOtoEntity() {
		ProdutoDTO dto = new ProdutoDTO();
		dto.setId(1L);
		dto.setDescricao("Test Produto");

		Produto produto = ProdutoMapper.fromDTOtoEntity(dto);

		assertEquals(dto.getId(), produto.getId());
		assertEquals(dto.getDescricao(), produto.getDescricao());
	}

	@Test
	public void testFromDTOtoEntityNull() {
		ProdutoDTO dto = null;
		Produto produto = ProdutoMapper.fromDTOtoEntity(dto);

		assertEquals(null, produto);
	}
}
