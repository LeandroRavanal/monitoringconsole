package io.github.lr.monitoringconsole.utils;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Utilitario con funciones comunes.
 * 
 * @author lravanal
 *
 */
public class UtilsHelper {

	private static final String DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN).withZone(ZoneOffset.systemDefault());
	
	private static final String EMPTY = "";
	
	public static String formatDateTime(Instant instant) {
		if (instant == null) {
			return EMPTY;
		}
		return DATE_TIME_FORMATTER.format(instant);
	}
	
}
