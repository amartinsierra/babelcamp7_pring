package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCurso;
	@Column(name="nombre")
	private String denominacion;
	private int duracion;
	private double precio;
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	@JsonIgnore
	@ManyToMany(mappedBy="cursos")
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
