package br.com.feitoamaoapi.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.feitoamaoapi.infra.entity.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "imagem", schema = "FEITO_A_MAO")
public class Imagem extends AbstractBaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_imagem")
	private Long id;

	@Column(name = "nome_arquivo", nullable = false)
	private String nomeArquivo;

	@Column(name = "dados_imagem", nullable = false)
	private byte[] dadosImagem;

	@Column(name = "legenda")
	private String legenda;

	@Column(name = "data_upload", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false)
	private LocalDateTime dataUpload;

}
