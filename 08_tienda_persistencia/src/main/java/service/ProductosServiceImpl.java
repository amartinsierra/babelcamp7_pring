package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Producto;


@Service
public class ProductosServiceImpl implements ProductosService {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Producto> productosSeccion(String seccion) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public void altaProducto(Producto producto) {
		entityManager.persist(producto);
		
	}

	@Override
	public void eliminarProducto(String nombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarPrecioProducto(String nombre, double nuevoPrecio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto buscarProducto(int idProducto) {
		return entityManager.find(Producto.class, idProducto);
	}

	@Override
	public Producto buscarProducto(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
