package br.com.feitoamaoapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;

import br.com.feitoamaoapi.dto.ImagemDTO;
import br.com.feitoamaoapi.dto.ProdutoDTO;
import br.com.feitoamaoapi.entity.Imagem;
import br.com.feitoamaoapi.repository.ImagemRepository;

public class ImagemProdutoServiceImplTest {

	@InjectMocks
	private ImagemProdutoServiceImpl imagemProdutoService;

	@Mock
	private ImagemRepository imagemRepository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void getImagensProdutoTest() {
		ArrayList<Imagem> imagens = new ArrayList<Imagem>();
		imagens.add(new Imagem());

		when(imagemRepository.findAll(any(Specification.class))).thenReturn(imagens);

		List<ImagemDTO> imagensDTO = imagemProdutoService.getImagensProduto(new ProdutoDTO());

		assertEquals(imagens.size(), imagensDTO.size());
	}

}
