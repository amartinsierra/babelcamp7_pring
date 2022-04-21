package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Alumno {
	private int idAlumno;
	private String nombre;
	private String curso;
	private double nota;
	
}
