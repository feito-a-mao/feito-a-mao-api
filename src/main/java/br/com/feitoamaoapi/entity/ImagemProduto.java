package br.com.feitoamaoapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.feitoamaoapi.infra.entity.AbstractBaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "imagem_produto", schema = "FEITO_A_MAO")
public class ImagemProduto extends AbstractBaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_imagem_produto")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "id_imagem", referencedColumnName = "id_imagem")
	private Imagem imagem;

}
