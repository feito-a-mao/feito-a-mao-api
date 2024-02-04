package br.com.feitoamaoapi.mapper;

import br.com.feitoamaoapi.dto.UsuarioDTO;
import br.com.feitoamaoapi.entity.Usuario;
import br.com.feitoamaoapi.infra.util.LocalDateUtils;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsuarioMapper {

	public static UsuarioDTO fromEntityToDTO(Usuario usuario) {
		if (usuario == null) {
			return null;
		}

		UsuarioDTO dto = new UsuarioDTO();

		dto.setId(usuario.getId());
		dto.setNome(usuario.getNome());
		dto.setEmail(usuario.getEmail());
		dto.setFotoPerfil(ImagemMapper.fromEntityToDTO(usuario.getFotoPerfil()));
		dto.setDataCriacao(LocalDateUtils.formatLocalDateTime(usuario.getDataCriacao(),
				LocalDateUtils.DATE_TIME_FORMAT_ANO_MES_DIA));
		dto.setCpf(usuario.getCpf());

		return dto;
	}

	public static Usuario fromDTOtoEntity(UsuarioDTO dto) {
		if (dto == null) {
			return null;
		}

		Usuario usuario = new Usuario();

		usuario.setId(dto.getId());
		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setFotoPerfil(ImagemMapper.fromDTOtoEntity(dto.getFotoPerfil()));
		usuario.setDataCriacao(
				LocalDateUtils.parseLocalDateTime(dto.getDataCriacao(), LocalDateUtils.DATE_TIME_FORMAT_ANO_MES_DIA));
		usuario.setCpf(dto.getCpf());

		return usuario;
	}
}
