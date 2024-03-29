package br.com.feitoamaoapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("")
	public ResponseEntity<String> listar() {
		return ResponseEntity.ok().build();
	}
}