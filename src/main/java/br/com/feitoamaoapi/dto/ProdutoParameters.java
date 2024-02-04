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
public class ProdutoParameters extends BaseDTO {

	private String nomeVendedor;

	private String nomeProduto;

}
