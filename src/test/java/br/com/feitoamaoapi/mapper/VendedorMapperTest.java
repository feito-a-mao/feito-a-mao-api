package br.com.feitoamaoapi.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.feitoamaoapi.dto.VendedorDTO;
import br.com.feitoamaoapi.entity.Vendedor;

public class VendedorMapperTest {

	@Test
	public void testFromEntityToDTO() {
		Vendedor vendedor = new Vendedor();
		vendedor.setId(1L);

		VendedorDTO dto = VendedorMapper.fromEntityToDTO(vendedor);

		assertEquals(vendedor.getId(), dto.getId());
	}

	@Test
	public void testFromEntityToDTONull() {
		Vendedor vendedor = null;

		VendedorDTO dto = VendedorMapper.fromEntityToDTO(vendedor);

		assertEquals(null, dto);
	}

	@Test
	public void testFromDTOtoEntity() {
		VendedorDTO dto = new VendedorDTO();
		dto.setId(1L);

		Vendedor vendedor = VendedorMapper.fromDTOtoEntity(dto);

		assertEquals(dto.getId(), vendedor.getId());
	}

	@Test
	public void testFromDTOtoEntityNull() {
		VendedorDTO dto = null;
		Vendedor vendedor = VendedorMapper.fromDTOtoEntity(dto);

		assertEquals(null, vendedor);
	}
}
