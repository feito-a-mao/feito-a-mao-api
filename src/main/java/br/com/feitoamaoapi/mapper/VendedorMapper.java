package br.com.feitoamaoapi.mapper;

import br.com.feitoamaoapi.dto.VendedorDTO;
import br.com.feitoamaoapi.entity.Vendedor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VendedorMapper {

	public static VendedorDTO fromEntityToDTO(Vendedor vendedor) {
		if (vendedor == null) {
			return null;
		}

		VendedorDTO dto = new VendedorDTO();

		dto.setId(vendedor.getId());
		dto.setUsuario(UsuarioMapper.fromEntityToDTO(vendedor.getUsuario()));
		dto.setDescricaoPerfil(vendedor.getDescricaoPerfil());
		dto.setLocalizacao(vendedor.getLocalizacao());
		dto.setAvaliacaoMedia(vendedor.getAvaliacaoMedia());

		return dto;
	}

	public static Vendedor fromDTOtoEntity(VendedorDTO dto) {
		if (dto == null) {
			return null;
		}

		Vendedor vendedor = new Vendedor();

		vendedor.setId(dto.getId());
		vendedor.setUsuario(UsuarioMapper.fromDTOtoEntity(dto.getUsuario()));
		vendedor.setDescricaoPerfil(dto.getDescricaoPerfil());
		vendedor.setLocalizacao(dto.getLocalizacao());
		vendedor.setAvaliacaoMedia(dto.getAvaliacaoMedia());

		return vendedor;
	}
}
