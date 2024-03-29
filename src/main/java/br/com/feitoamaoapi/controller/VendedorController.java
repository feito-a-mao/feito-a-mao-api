package br.com.feitoamaoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.feitoamaoapi.dto.VendedorDTO;
import br.com.feitoamaoapi.dto.VendedorParameters;
import br.com.feitoamaoapi.infra.dto.PaginaDTO;
import br.com.feitoamaoapi.service.VendedorService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RestController
@RequestMapping("/vendedor")
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;

	@GetMapping("")
	public PaginaDTO<VendedorDTO> listar(@ModelAttribute VendedorParameters parameters,
			@RequestParam(required = false, defaultValue = "0") Integer offset,
			@RequestParam(required = false, defaultValue = "10") Integer limit,
			@RequestParam(required = false) String sort) {
		return vendedorService.recuperarTodos(parameters, offset, limit, sort);
	}
}