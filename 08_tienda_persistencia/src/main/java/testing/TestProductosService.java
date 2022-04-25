package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import service.ProductosService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class }) 
public class TestProductosService {
	@Autowired
	ProductosService service;
	
	@Test
	void testProducto() {
		assertEquals(50.0, service.buscarProducto(4).getPrecio());
		assertNull(service.buscarProducto(800));
	}
	
	@Test
	void testMedia() {
		assertEquals(100.0, service.precioMedioSeccion("hogar"));
	}
}
