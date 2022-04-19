package service;

import java.util.List;

import model.Producto;

public interface ProductosService {

	//devuelve la lista de productos de la sección que le llegue como parámetro
	List<Producto> productosSeccion(String seccion);

	//el método recibe los datos de un producto y lo da de alta en la lista
	void altaProducto(Producto producto);

	//localiza la posición del producto que tiene ese nombre
	//y lo borra por posición
	void eliminarProducto(String nombre);

	//localizar el producto por su nombre y establecerle el nuevo precio
	void modificarPrecioProducto(String nombre, double nuevoPrecio);

}