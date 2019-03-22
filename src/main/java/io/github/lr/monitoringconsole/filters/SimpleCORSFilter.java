package io.github.lr.monitoringconsole.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Habilita el consumo de las operaciones desde cualquier origen, permite el acceso desde archivo.
 * 
 * Úsese con precaución.
 * 
 * @author lravanal
 *
 */
@Component
public class SimpleCORSFilter extends OncePerRequestFilter {

	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Override 
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException { 
    	response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        
        filterChain.doFilter(request, response);
    }
	
}
