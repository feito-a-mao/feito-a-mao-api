package br.com.banestes.feitoamaoapi.infra.util;

import java.util.regex.Pattern;

import org.springframework.util.ObjectUtils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CpfUtils {
	private static final Pattern CPF_CNPJ_PATTERN = Pattern.compile("[.\\-]");

	public static String cleanCpfCnpj(String cpfCnpj) {
		if (ObjectUtils.isEmpty(cpfCnpj)) {
			return null;
		}

		return CPF_CNPJ_PATTERN.matcher(cpfCnpj).replaceAll("");
	}

}
