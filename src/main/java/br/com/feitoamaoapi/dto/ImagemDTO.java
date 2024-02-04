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
public class ImagemDTO extends BaseDTO {
	private Long id;
	private byte[] dadosImagem;
	private String legenda;
	private String dataUpload;
}
