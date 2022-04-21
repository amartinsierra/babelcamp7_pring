package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Producto;
import service.ProductosService;

@CrossOrigin("*")
@Controller
public class ProductosController {
	@Autowired
	ProductosService productosService;
	
	@PostMapping("Alta")
	public String alta(@ModelAttribute Producto producto)  {
		productosService.altaProducto(producto);
		return "alta";
	}
	
	@GetMapping("Eliminar")
	public String eliminar(@RequestParam("nombre") String nombre)  {	
		productosService.eliminarProducto(nombre);
		return "inicio";
	}
	@GetMapping(value="Buscador",produces = MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody List<Producto> buscar(@RequestParam("seccion") String seccion)  {		
		return productosService.productosSeccion(seccion);		
	}
	
	@GetMapping("Modificar")
	public String modif(@RequestParam("nombre") String nombre, 
			@RequestParam("precio") double precio) {		 
		productosService.modificarPrecioProducto(nombre,precio);
		return "inicio";
	}
}
