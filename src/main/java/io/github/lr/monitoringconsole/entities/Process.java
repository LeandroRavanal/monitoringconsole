package io.github.lr.monitoringconsole.entities;

import java.time.Instant;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.github.lr.monitoringconsole.serializers.InstantSerializer;

/**
 * Entidad de Proceso.
 * 
 * @author lravanal
 *
 */
public class Process {

	private String name;
	private Instant time;
	private Integer count;
	
	public Process(String name, Instant time, Integer count) {
		this.name = name;
		this.time = time;
		this.count = count;
	}
	
	public void update() {
		this.time = Instant.now();
		this.count++;
	}
	
	public String getName() {
		return name;
	}
	@JsonSerialize(using=InstantSerializer.class)
	public Instant getTime() {
		return time;
	}
	public Integer getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "Process [name=" + name + ", time=" + time + ", count" + count + "]";
	}
	
}
