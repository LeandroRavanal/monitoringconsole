package io.github.lr.monitoringconsole.entities;

import java.util.Arrays;

import io.github.lr.monitoringconsole.utils.EnumValue;

/**
 * Agrupa los procesos con su punto de acceso. 
 * 
 * @author lravanal
 *
 */
public enum ProcessName implements EnumValue {

	MORNING("morning", "Morning Process"),
	EVENING("evening", "Evening Process"),
	;
	
	private String uri;
	private String name;
	
	ProcessName(String uri, String name) {
		this.uri = uri;
		this.name = name;
	}

	public String getUri() {
		return uri;
	}
	public String getName() {
		return name;
	}

	@Override
	public String getEnumValue() {
		return getUri();
	}
	
	public static ProcessName findByEnumValue(String value) {
		return Arrays.stream(ProcessName.values()).filter(processName -> processName.getEnumValue().equalsIgnoreCase(value)).findAny().get();
	}
	
}
