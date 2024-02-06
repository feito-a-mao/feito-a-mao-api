package br.com.feitoamaoapi.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.feitoamaoapi.dto.UsuarioDTO;
import br.com.feitoamaoapi.entity.Usuario;

public class UsuarioMapperTest {

	@Test
	public void testFromEntityToDTO() {
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		usuario.setNome("Test Usuario");

		UsuarioDTO dto = UsuarioMapper.fromEntityToDTO(usuario);

		assertEquals(usuario.getId(), dto.getId());
		assertEquals(usuario.getNome(), dto.getNome());
	}

	@Test
	public void testFromEntityToDTONull() {
		Usuario usuario = null;

		UsuarioDTO dto = UsuarioMapper.fromEntityToDTO(usuario);

		assertEquals(null, dto);
	}

	@Test
	public void testFromDTOtoEntity() {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(1L);
		dto.setNome("Test Usuario");

		Usuario usuario = UsuarioMapper.fromDTOtoEntity(dto);

		assertEquals(dto.getId(), usuario.getId());
		assertEquals(dto.getNome(), usuario.getNome());
	}

	@Test
	public void testFromDTOtoEntityNull() {
		UsuarioDTO dto = null;
		Usuario usuario = UsuarioMapper.fromDTOtoEntity(dto);

		assertEquals(null, usuario);
	}
}
