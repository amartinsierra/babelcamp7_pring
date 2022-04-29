package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class }) 
public class TestFormacionService {
	@Autowired
	FormacionService service;
	
	@Test
	void testCursosAlumno() {
		assertEquals(4, service.cursosAlumno("admin").size());
		
	}
	
	@Test
	void testAlumnosCurso() {
		assertEquals(4, service.alumnosCurso("kafka").size());
	}
	
	@Test
	void testValidarAlumno() {
		assertNotNull(service.validarUsuario("admin", "a"));
		assertNull(service.validarUsuario("text", "mytext"));
	}
	
	
	@Test
	void testConsultaMatriculas() {
		Calendar c1=Calendar.getInstance();
		Calendar c2=Calendar.getInstance();
		c1.set(2020, 8, 20);
		c2.set(2022, 2, 10);
		Date f1=c1.getTime();
		Date f2=c2.getTime();
		
		
	}
	
}
