package br.com.feitoamaoapi.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.feitoamaoapi.dto.ImagemDTO;
import br.com.feitoamaoapi.entity.Imagem;

public class ImagemMapperTest {

	@Test
	public void testFromEntityToDTO() {
		Imagem imagem = new Imagem();
		imagem.setId(1L);
		imagem.setNomeArquivo("Test Imagem");

		ImagemDTO dto = ImagemMapper.fromEntityToDTO(imagem);

		assertEquals(imagem.getId(), dto.getId());
		assertEquals(imagem.getNomeArquivo(), dto.getNomeArquivo());
	}

	@Test
	public void testFromEntityToDTONull() {
		Imagem imagem = null;

		ImagemDTO dto = ImagemMapper.fromEntityToDTO(imagem);

		assertEquals(null, dto);
	}

	@Test
	public void testFromDTOtoEntity() {
		ImagemDTO dto = new ImagemDTO();
		dto.setId(1L);
		dto.setNomeArquivo("Test Imagem");

		Imagem imagem = ImagemMapper.fromDTOtoEntity(dto);

		assertEquals(dto.getId(), imagem.getId());
		assertEquals(dto.getNomeArquivo(), imagem.getNomeArquivo());
	}

	@Test
	public void testFromDTOtoEntityNull() {
		ImagemDTO dto = null;
		Imagem imagem = ImagemMapper.fromDTOtoEntity(dto);

		assertEquals(null, imagem);
	}

	@Test
	public void testToDTOList() {
		List<Imagem> imagens = new ArrayList<Imagem>();
		imagens.add(new Imagem());
		List<ImagemDTO> imagensDTO = ImagemMapper.toDTOList(imagens);

		assertEquals(1, imagensDTO.size());
	}
}
