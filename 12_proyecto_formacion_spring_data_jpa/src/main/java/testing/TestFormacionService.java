package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
	
}
