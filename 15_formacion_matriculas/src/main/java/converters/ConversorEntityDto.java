package converters;

import dtos.AlumnoDto;
import dtos.CursoDto;
import dtos.MatriculaDto;
import model.Alumno;
import model.Curso;
import model.Matricula;

public interface ConversorEntityDto {
	public CursoDto cursoToDto(Curso curso);
	public Curso dtoToCurso(CursoDto dto);
	public AlumnoDto alumnoToDto(Alumno alumno);
	public Alumno dtoToAlumno(AlumnoDto dto);
	public MatriculaDto matriculaToDto(Matricula matricula);
	public Matricula dtoToMatricula(MatriculaDto dto);
}
