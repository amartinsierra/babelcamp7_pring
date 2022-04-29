package dtos;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Alumno;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CursoDto {
	private int idCurso;	
	private String denominacion;
	private int duracion;
	private double precio;
	private Date fechaInicio;
	List<String> alumnos;
}
