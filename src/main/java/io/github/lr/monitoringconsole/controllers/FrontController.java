package io.github.lr.monitoringconsole.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.lr.monitoringconsole.entities.Process;
import io.github.lr.monitoringconsole.entities.ProcessName;
import io.github.lr.monitoringconsole.managers.ProcessManager;
import io.github.lr.monitoringconsole.utils.Enum;

/**
 * Controlador que agrupa las operaciones (puntos de acceso) a la aplicación.
 * 
 * @author lravanal
 *
 */
@RestController	
@RequestMapping("/api/v1")
@Validated
public class FrontController {
	
	public final Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final String PARAM_NAME_MSG = "nombre de proceso inválido";
	
	@Autowired ProcessManager processManager;
	
	@PostMapping(value = "/processes/{name}")
	public ResponseEntity<Process> process(@Valid @Enum(enumClass = ProcessName.class, message = PARAM_NAME_MSG) @PathVariable String name) {
		logger.debug("Ejecutando el proceso: " + name);
		
		return new ResponseEntity<Process>(processManager.process(ProcessName.findByEnumValue(name)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/processes")
	public ResponseEntity<List<Process>> processes() {
		logger.debug("Obteniendo el listado de procesos");
		
		return new ResponseEntity<List<Process>>(processManager.getAll(), HttpStatus.OK);
	}
	
}
