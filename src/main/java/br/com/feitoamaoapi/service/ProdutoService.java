package br.com.feitoamaoapi.service;

import br.com.feitoamaoapi.dto.ProdutoDTO;
import br.com.feitoamaoapi.dto.ProdutoParameters;
import br.com.feitoamaoapi.infra.dto.PaginaDTO;

public interface ProdutoService {
	PaginaDTO<ProdutoDTO> recuperarTodos(ProdutoParameters parameters, Integer offset, Integer limit, String ordenacao);

	ProdutoDTO salvar(ProdutoDTO dto);

}
