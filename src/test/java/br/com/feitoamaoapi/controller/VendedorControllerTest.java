package br.com.feitoamaoapi.controller;

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

import br.com.feitoamaoapi.dto.VendedorDTO;
import br.com.feitoamaoapi.infra.dto.PaginaDTO;
import br.com.feitoamaoapi.service.VendedorService;

@WebMvcTest(VendedorController.class)
@AutoConfigureMockMvc
public class VendedorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private VendedorService vendedorService;

	@Test
	public void testListar() throws Exception {
		VendedorDTO vendedorDTO1 = criarVendedorMock();

		VendedorDTO vendedorDTO2 = VendedorDTO.builder().id(2L).build();

		List<VendedorDTO> vendedorDTOList = Arrays.asList(vendedorDTO1, vendedorDTO2);

		PaginaDTO<VendedorDTO> paginaDTO = new PaginaDTO<VendedorDTO>();
		paginaDTO.setCurrentPage(1);
		paginaDTO.setItens(vendedorDTOList);
		paginaDTO.setTotalItens(new Long(vendedorDTOList.size()));

		when(vendedorService.recuperarTodos(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
				.thenReturn(paginaDTO);

		mockMvc.perform(MockMvcRequestBuilders.get("/vendedor").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.currentPage").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.totalItens").value((long) vendedorDTOList.size()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.itens[0].id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.itens[1].id").value(2));
	}

	private VendedorDTO criarVendedorMock() {
		return VendedorDTO.builder().id(1L).build();
	}
}
