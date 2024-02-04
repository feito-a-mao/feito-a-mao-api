package br.com.feitoamaoapi.infra.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.feitoamaoapi.infra.dto.BaseDTO;
import br.com.feitoamaoapi.infra.dto.PaginaDTO;

/*
 * T: Entity class
 * D: DTO class
 */
public interface CrudService<T, D> {
	PaginaDTO<D> recuperarTodos(BaseDTO parameters, Integer offset, Integer limit, String ordenacao);

	Page<T> findAllComFiltro(BaseDTO parameters, Pageable pageable);
}