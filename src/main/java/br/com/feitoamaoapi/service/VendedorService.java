package br.com.feitoamaoapi.service;

import br.com.feitoamaoapi.dto.VendedorDTO;
import br.com.feitoamaoapi.dto.VendedorParameters;
import br.com.feitoamaoapi.infra.dto.PaginaDTO;

public interface VendedorService {

	PaginaDTO<VendedorDTO> recuperarTodos(VendedorParameters parameters, Integer offset, Integer limit, String sort);

}
