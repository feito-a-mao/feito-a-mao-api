package br.com.feitoamaoapi.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.feitoamaoapi.dto.ProdutoDTO;
import br.com.feitoamaoapi.infra.dto.PaginaDTO;
import br.com.feitoamaoapi.service.ProdutoService;

@WebMvcTest(ProdutoController.class)
@AutoConfigureMockMvc
public class ProdutoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProdutoService produtoService;

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testSalvar() throws Exception {
		ProdutoDTO produtoDTO = criarProdutoMock();

		String requestBody = mapper.writeValueAsString(produtoDTO);

		mockMvc.perform(
				MockMvcRequestBuilders.post("/produto").content(requestBody).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

		verify(produtoService).salvar(any(ProdutoDTO.class));
	}

	@Test
	public void testListar() throws Exception {
		ProdutoDTO produtoDTO1 = criarProdutoMock();

		ProdutoDTO produtoDTO2 = ProdutoDTO.builder().id(2L).descricao("Teste 2").build();

		List<ProdutoDTO> produtoDTOList = Arrays.asList(produtoDTO1, produtoDTO2);

		PaginaDTO<ProdutoDTO> paginaDTO = new PaginaDTO<ProdutoDTO>();
		paginaDTO.setCurrentPage(1);
		paginaDTO.setItens(produtoDTOList);
		paginaDTO.setTotalItens(new Long(produtoDTOList.size()));

		when(produtoService.recuperarTodos(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
				.thenReturn(paginaDTO);

		mockMvc.perform(MockMvcRequestBuilders.get("/produto").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.currentPage").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.totalItens").value((long) produtoDTOList.size()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.itens[0].id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.itens[0].descricao").value("Teste"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.itens[1].id").value(2))
				.andExpect(MockMvcResultMatchers.jsonPath("$.itens[1].descricao").value("Teste 2"));
	}

	private ProdutoDTO criarProdutoMock() {
		return ProdutoDTO.builder().id(1L).descricao("Teste").build();
	}
}
