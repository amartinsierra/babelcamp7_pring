package dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MatriculaDto {
	private double nota;
	private CursoDto cursoDto;
	private AlumnoDto alumnoDto;
}
