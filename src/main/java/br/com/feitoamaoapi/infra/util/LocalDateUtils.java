package br.com.feitoamaoapi.infra.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.util.ObjectUtils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class LocalDateUtils {
	public static final String DATE_FORMAT_ANO_MES_DIA = "yyyy-MM-dd";
	public static final String DATE_FORMAT_DIA_MES_ANO = "dd/MM/yyyy";
	public static final String DATE_TIME_FORMAT_ANO_MES_DIA = "yyyy-MM-dd HH:mm:ss";
	public static final String CPF_CNPJ_PATTERN = "[.\\-]";

	public static String formatLocalDate(LocalDate localDate, String pattern) {
		if (localDate == null) {
			return null;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return localDate.format(formatter);
	}

	public static LocalDate parseLocalDate(String dateStr, String pattern) {
		if (ObjectUtils.isEmpty(dateStr)) {
			return null;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalDate.parse(dateStr, formatter);
	}

	public static String formatLocalDateTime(LocalDateTime localDateTime, String pattern) {
		if (localDateTime == null) {
			return null;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return localDateTime.format(formatter);
	}

	public static LocalDateTime parseLocalDateTime(String dateTimeStr, String pattern) {
		if (ObjectUtils.isEmpty(dateTimeStr)) {
			return null;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalDateTime.parse(dateTimeStr, formatter);
	}

}
