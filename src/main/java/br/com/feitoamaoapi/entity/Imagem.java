package br.com.feitoamaoapi.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.feitoamaoapi.infra.entity.AbstractBaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "imagem", schema = "FEITO_A_MAO")
public class Imagem extends AbstractBaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_imagem")
	private Long id;

	@Column(name = "dados_imagem", nullable = false)
	private byte[] dadosImagem;

	@Column(name = "legenda")
	private String legenda;

	@Column(name = "data_upload", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime dataUpload;

}
