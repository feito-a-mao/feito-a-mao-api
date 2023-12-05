package br.com.banestes.feitoamaoapi.infra.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO que transporta as informações inerentes a paginação
 * 
 * @author VictorSantos
 *
 */
@Getter
@Setter
@JsonInclude(value = Include.NON_NULL)
public class PaginaDTO<T> {
	private Integer currentPage;
	private Long totalItens;
	private List<T> itens;
}
