package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Producto;


@Service
public class ProductosServiceImpl implements ProductosService {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Producto> productosSeccion(String seccion) {
		//String jpql="select p from Producto p where p.seccion=?1";
		/*Query query=entityManager.createQuery(jpql);
		query.setParameter(1, seccion);
		return (List<Producto>)query.getResultList();*/
		TypedQuery<Producto> query=entityManager.createNamedQuery("Producto.findBySeccion",Producto.class);
		query.setParameter(1, seccion);
		return query.getResultList();
	}
	@Transactional
	@Override
	public void altaProducto(Producto producto) {
		entityManager.persist(producto);
		
	}
	@Transactional
	@Override
	public void eliminarProducto(String nombre) {
		String jpql="delete from Producto p where p.nombre=?1";
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1, nombre);
		query.executeUpdate();
		
	}
	@Transactional
	@Override
	public void modificarPrecioProducto(String nombre, double nuevoPrecio) {
		Producto producto=buscarProducto(nombre);
		if(producto!=null) {
			producto.setPrecio(nuevoPrecio);
			entityManager.merge(producto);//actualización
		}
		
	}

	@Override
	public Producto buscarProducto(int idProducto) {
		return entityManager.find(Producto.class, idProducto);
	}

	@Override
	public Producto buscarProducto(String nombre) {
		String jpql="select p from Producto p where p.nombre=:name";
		TypedQuery<Producto> query=entityManager.createQuery(jpql,Producto.class);
		//query.setParameter(1, nombre);
		query.setParameter("name", nombre);
		List<Producto> productos=query.getResultList();
		return productos.size()>0?productos.get(0):null;
	}
	@Override
	public double precioMedioSeccion(String seccion) {
		String jpql="select avg(p.precio) from Producto p where p.seccion=:sec";
		TypedQuery<Double> query=entityManager.createQuery(jpql,Double.class);
		//query.setParameter(1, nombre);
		query.setParameter("sec", seccion);
		return query.getSingleResult();
		
	}
	
	
}
