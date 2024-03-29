package br.com.feitoamaoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.feitoamaoapi.dto.ProdutoDTO;
import br.com.feitoamaoapi.dto.ProdutoParameters;
import br.com.feitoamaoapi.infra.dto.PaginaDTO;
import br.com.feitoamaoapi.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("")
	public PaginaDTO<ProdutoDTO> listar(@ModelAttribute ProdutoParameters parameters,
			@RequestParam(required = false, defaultValue = "0") Integer offset,
			@RequestParam(required = false, defaultValue = "10") Integer limit,
			@RequestParam(required = false) String sort) {
		return produtoService.recuperarTodos(parameters, offset, limit, sort);
	}

	@PostMapping(value = { "", "alterar" })
	public ResponseEntity<ProdutoDTO> salvar(@RequestBody ProdutoDTO produtoDTO) {
		final ProdutoDTO produtoSalvo = produtoService.salvar(produtoDTO);
		return ResponseEntity.ok(produtoSalvo);
	}
}