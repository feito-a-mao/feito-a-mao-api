package br.com.feitoamaoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.feitoamaoapi.dto.VendedorDTO;
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
	public ResponseEntity<List<VendedorDTO>> listar() {
		List<VendedorDTO> lista = vendedorService.listar();
		return ResponseEntity.ok(lista);
	}
}