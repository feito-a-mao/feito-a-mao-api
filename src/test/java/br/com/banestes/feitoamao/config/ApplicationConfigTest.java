package br.com.banestes.feitoamao.config;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.feitoamaoapi.config.ApplicationConfig;

public class ApplicationConfigTest {

	@Test
	public void testCorsConfigure() {
		// Create an instance of ApplicationConfig
		ApplicationConfig applicationConfig = new ApplicationConfig();

		// Create a mock CorsRegistry
		CorsRegistry corsRegistryMock = new CorsRegistry();

		// Call corsConfigure method and configure the registry
		WebMvcConfigurer configurer = applicationConfig.corsConfigure();
		configurer.addCorsMappings(corsRegistryMock);

		Assert.assertNotNull(configurer);
	}
}
