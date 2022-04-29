package converters;

import dtos.AlumnoDto;
import dtos.CursoDto;
import model.Alumno;
import model.Curso;

public interface ConversorEntityDto {
	public CursoDto cursoToDto(Curso curso);
	public Curso dtoToCurso(CursoDto dto);
	public AlumnoDto alumnoToDto(Alumno alumno);
	public Alumno dtoToAlumno(AlumnoDto dto);
}
