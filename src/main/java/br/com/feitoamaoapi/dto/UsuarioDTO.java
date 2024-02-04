package br.com.feitoamaoapi.dto;

import br.com.feitoamaoapi.infra.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class UsuarioDTO extends BaseDTO {
	private Long id;
	private String nome;
	private String email;
	private ImagemDTO fotoPerfil;
	private String dataCriacao;
	private String cpf;
}
