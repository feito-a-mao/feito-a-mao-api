package br.com.banestes.feitoamao.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.feitoamaoapi.controller.TestController;

@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
@AutoConfigureMockMvc
public class TestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper mapper = new ObjectMapper();

	/* headers */
	private static final String USER_NAME_HEADER_NAME = "User-Name";
	private static final String USER_REGISTRATION_HEADER_NAME = "User-Registration";
	private static final String USER_NAME_HEADER_VALUE = "Usuario Teste";
	private static final String USER_REGISTRATION_HEADER_VALUE = "0000000000";

	@Test
	public void listar() throws Exception {

		String bodyResponseExpected = "";
		mockMvc.perform(get("/test").header(USER_NAME_HEADER_NAME, USER_NAME_HEADER_VALUE)
				.header(USER_REGISTRATION_HEADER_NAME, USER_REGISTRATION_HEADER_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(bodyResponseExpected));
	}

}