package br.com.feitoamaoapi.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.feitoamaoapi.infra.entity.AbstractBaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "produto", schema = "FEITO_A_MAO")
public class Produto extends AbstractBaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;

	@Column(name = "id_vendedor", nullable = false)
	private Long idVendedor;

	@Column(name = "nome", nullable = false, length = 255)
	private String nome;

	@Column(name = "descricao", columnDefinition = "TEXT")
	private String descricao;

	@Column(name = "preco", nullable = false, precision = 10, scale = 2)
	private BigDecimal preco;

	@Column(name = "estoque_disponivel", nullable = false)
	private Integer estoqueDisponivel;

	@Column(name = "data_criacao", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime dataCriacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_vendedor", referencedColumnName = "id_vendedor", insertable = false, updatable = false)
	private Vendedor vendedor;

	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ImagemProduto> imagens;

}
