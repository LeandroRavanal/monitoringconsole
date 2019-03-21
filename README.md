# Consola de Monitoreo Web en Javascript

A veces necesitamos ejecutar procesos y monitorear el resultado.

> La idea de este ejercicio es 
> monitorear el estado de unos procesos 
> y permitir su ejecución desde una consola.

### Código

La consola está hecha usando Vanilla Javascript ES6 (no frameworks), manipulando el DOM y creando pedidos XMLHttpRequest.

El servidor está hecho con Spring Boot, validando el nombre de ejecución y manejando concurrencia.

Para el ejemplo establecemos dos procesos, uno diurno y otro nocturno con fecha y cantidad de ejecuciones.

### Observación

Si bien la consola (index.html) se accede desde la aplicación, es posible extraerla y ejecutarla localmente.
