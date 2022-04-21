package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Producto;


@Service
public class ProductosServiceImpl implements ProductosService {
	
	@Autowired
	JdbcTemplate template;

	@Override
	public List<Producto> productosSeccion(String seccion) {
		String sql="select * from productos where seccion=?";		
		return template.query(sql, 
				(rs,f)->new Producto(rs.getInt("idProducto"),
									 rs.getString("nombre"),
									 rs.getString("seccion"),
									 rs.getDouble("precio"),
									 rs.getInt("stock")), 
				seccion);
	}

	@Override
	public void altaProducto(Producto producto) {
		String sql="insert into productos(nombre,seccion,precio,stock) values(?,?,?,?)";
		template.update(sql, 
				producto.getNombre(),
				producto.getSeccion(),
				producto.getPrecio(),
				producto.getStock());
		
	}

	@Override
	public void eliminarProducto(String nombre) {
		String sql="delete from productos where nombre=?";
		template.update(sql, nombre);
		
	}

	@Override
	public void modificarPrecioProducto(String nombre, double nuevoPrecio) {
		String sql="update productos set precio=? where nombre=?";
		template.update(sql,nuevoPrecio,nombre);
		
	}

	@Override
	public Producto buscarProducto(int idProducto) {
		String sql="select * from productos where idProducto=?";
		List<Producto> productos= template.query(sql, 
				(rs,f)->new Producto(rs.getInt("idProducto"),
									 rs.getString("nombre"),
									 rs.getString("seccion"),
									 rs.getDouble("precio"),
									 rs.getInt("stock")), 
				idProducto);
		return productos.size()>0?productos.get(0):null;
	}

	@Override
	public Producto buscarProducto(String nombre) {
		String sql="select * from productos where nombre=?";
		List<Producto> productos= template.query(sql, 
				(rs,f)->new Producto(rs.getInt("idProducto"),
									 rs.getString("nombre"),
									 rs.getString("seccion"),
									 rs.getDouble("precio"),
									 rs.getInt("stock")), 
				nombre);
		return productos.size()>0?productos.get(0):null;
	}
	
}
