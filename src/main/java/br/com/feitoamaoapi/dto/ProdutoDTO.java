package br.com.feitoamaoapi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
public class ProdutoDTO extends BaseDTO {

	private Long id;

	private Long idVendedor;

	private String nome;

	private String descricao;

	private BigDecimal preco;

	private Integer estoqueDisponivel;

	private LocalDateTime dataCriacao;

	private VendedorDTO vendedor;

	private List<ImagemDTO> imagens;
}
