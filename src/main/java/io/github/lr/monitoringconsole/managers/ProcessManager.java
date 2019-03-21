package io.github.lr.monitoringconsole.managers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import io.github.lr.monitoringconsole.entities.Process;
import io.github.lr.monitoringconsole.entities.ProcessName;

/**
 * Administrador de los procesos. Realiza la carga inicial.
 * 
 * @author lravanal
 *
 */
@Component
public class ProcessManager {
	
	public final Logger logger = LoggerFactory.getLogger(this.getClass());

	private Map<ProcessName, Process> processMap = new TreeMap<ProcessName, Process>();
	
	@EventListener
	public void onApplicationEvent(ApplicationReadyEvent event) {
		logger.debug("Evento de inicialización de aplicación");
		
		loadInitData();
    }
	
	private void loadInitData() {
		logger.debug("Se cargan los procesos en memoria con valores iniciales");
		
		processMap.put(ProcessName.MORNING, new Process(ProcessName.MORNING.getName(), Instant.now(), new Random().nextInt(10) + 1));
		processMap.put(ProcessName.EVENING, new Process(ProcessName.EVENING.getName(), Instant.now(), new Random().nextInt(10) + 1));
	}
	
	public List<Process> getAll() {
		return new ArrayList<Process>(processMap.values());
	}

	public Process process(ProcessName processName) {
		Process process = processMap.get(processName);
		
		synchronized (process) {
			process.update();
		}
		
		return process;
	}
	
}
