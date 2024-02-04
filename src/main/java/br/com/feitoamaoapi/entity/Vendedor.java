package br.com.feitoamaoapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.feitoamaoapi.infra.entity.AbstractBaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "vendedor", schema = "feito_a_mao")
public class Vendedor extends AbstractBaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vendedor")
	private Long id;

	@Column(name = "id_usuario", nullable = false)
	private Long idUsuario;

	@Column(name = "descricao_perfil", columnDefinition = "TEXT")
	private String descricaoPerfil;

	@Column(name = "localizacao", length = 255)
	private String localizacao;

	@Column(name = "avaliacao_media", precision = 2, scale = 1)
	private Double avaliacaoMedia;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
	private Usuario usuario;

}
