package br.com.feitoamaoapi.infra.util;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CpfUtilsTest {

	@Test
	public void testCleanCpfCnpj() {
		String cpfCnpjWithSpecialChars = "123.456.789-00";
		String cleanedCpfCnpj = CpfUtils.cleanCpfCnpj(cpfCnpjWithSpecialChars);
		assertEquals("12345678900", cleanedCpfCnpj);
	}

	@Test
	public void testCleanCpfCnpjNull() {
		String cleanedCpfCnpj = CpfUtils.cleanCpfCnpj(null);
		assertNull(cleanedCpfCnpj);
	}

	@Test
	public void testCleanCpfCnpjEmpty() {
		String cleanedCpfCnpj = CpfUtils.cleanCpfCnpj("");
		assertNull(cleanedCpfCnpj);
	}

	@Test
	public void testCleanCpfCnpjNoSpecialChars() {
		String cpfCnpjWithoutSpecialChars = "12345678900";
		String cleanedCpfCnpj = CpfUtils.cleanCpfCnpj(cpfCnpjWithoutSpecialChars);
		assertEquals(cpfCnpjWithoutSpecialChars, cleanedCpfCnpj);
	}
}
