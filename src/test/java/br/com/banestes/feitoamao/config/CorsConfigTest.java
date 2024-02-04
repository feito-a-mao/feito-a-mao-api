package br.com.banestes.feitoamao.config;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.feitoamaoapi.config.CorsConfig;

public class CorsConfigTest {

	@Test
	public void testCorsConfigurer() {
		// Create an instance of CorsConfig
		CorsConfig corsConfig = new CorsConfig();

		// Create a mock CorsRegistry
		CorsRegistry corsRegistryMock = new CorsRegistry();

		// Call corsConfigurer method and configure the registry
		WebMvcConfigurer configurer = corsConfig.corsConfigurer();
		configurer.addCorsMappings(corsRegistryMock);
		Assert.assertNotNull(configurer);
	}
}
