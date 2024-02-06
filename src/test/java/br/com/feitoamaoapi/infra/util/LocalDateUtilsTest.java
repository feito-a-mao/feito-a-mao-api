package br.com.feitoamaoapi.infra.util;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class LocalDateUtilsTest {

	@Test
	public void testFormatLocalDate() {
		LocalDate localDate = LocalDate.of(2023, 11, 23);
		String formattedDate = LocalDateUtils.formatLocalDate(localDate, LocalDateUtils.DATE_FORMAT_ANO_MES_DIA);
		assertEquals("2023-11-23", formattedDate);
	}

	@Test
	public void testFormatLocalDateNull() {
		LocalDate localDate = null;
		String formattedDate = LocalDateUtils.formatLocalDate(localDate, LocalDateUtils.DATE_FORMAT_ANO_MES_DIA);
		assertNull(formattedDate);
	}

	@Test
	public void testParseLocalDate() {
		String dateStr = "2023-11-23";
		LocalDate parsedDate = LocalDateUtils.parseLocalDate(dateStr, LocalDateUtils.DATE_FORMAT_ANO_MES_DIA);
		assertEquals(LocalDate.of(2023, 11, 23), parsedDate);
	}

	@Test
	public void testParseLocalDateEmpty() {
		String dateStr = "";
		LocalDate parsedDate = LocalDateUtils.parseLocalDate(dateStr, LocalDateUtils.DATE_FORMAT_ANO_MES_DIA);
		assertNull(parsedDate);
	}

	@Test
	public void testFormatLocalDateTime() {
		LocalDateTime localDateTime = LocalDateTime.of(2023, 11, 23, 12, 30, 45);
		String formattedDateTime = LocalDateUtils.formatLocalDateTime(localDateTime,
				LocalDateUtils.DATE_TIME_FORMAT_ANO_MES_DIA);
		assertEquals("2023-11-23 12:30:45", formattedDateTime);
	}

	@Test
	public void testFormatLocalDateTimeNull() {
		LocalDateTime localDateTime = null;
		String formattedDateTime = LocalDateUtils.formatLocalDateTime(localDateTime,
				LocalDateUtils.DATE_TIME_FORMAT_ANO_MES_DIA);
		assertNull(formattedDateTime);
	}

	@Test
	public void testParseLocalDateTime() {
		String dateTimeStr = "2023-11-23 12:30:45";
		LocalDateTime parsedDateTime = LocalDateUtils.parseLocalDateTime(dateTimeStr,
				LocalDateUtils.DATE_TIME_FORMAT_ANO_MES_DIA);
		assertEquals(LocalDateTime.of(2023, 11, 23, 12, 30, 45), parsedDateTime);
	}

	@Test
	public void testParseLocalDateTimeEmpty() {
		String dateTimeStr = "";
		LocalDateTime parsedDateTime = LocalDateUtils.parseLocalDateTime(dateTimeStr,
				LocalDateUtils.DATE_TIME_FORMAT_ANO_MES_DIA);
		assertNull(parsedDateTime);
	}
}
