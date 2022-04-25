package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "productos")
@NamedQuery(name="Producto.findBySeccion", query="select p from Producto p where p.seccion=?1")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	private String nombre;
	@Column(name = "seccion")
	private String seccion;
	private double precio;
	private int stock;
}
