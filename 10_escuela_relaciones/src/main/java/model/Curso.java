package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity							
@Table(name = "cursos")

/* Entidad Curso */
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCurso;
	private String denominacion;
	private int duracion;
	private double precio;
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	
	@OneToMany(mappedBy = "curso")
	private List<Alumno> alumnos;

	public Curso(int idCurso, String denominacion, int duracion, double precio, Date fechaInicio) {
		super();
		this.idCurso = idCurso;
		this.denominacion = denominacion;
		this.duracion = duracion;
		this.precio = precio;
		this.fechaInicio = fechaInicio;
	}
	
	
}