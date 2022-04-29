package converters;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import dtos.AlumnoDto;
import dtos.CursoDto;
import model.Alumno;
import model.Curso;
@Component
public class ConversorEntityDtoImpl implements ConversorEntityDto {

	@Override
	public CursoDto cursoToDto(Curso curso) {
		return new CursoDto(curso.getIdCurso(),curso.getDenominacion(),curso.getDuracion(),curso.getPrecio(),curso.getFechaInicio(),
				curso.getAlumnos()
				.stream()
				.map(a->a.getNombre())
				.collect(Collectors.toList()));
	}

	@Override
	public Curso dtoToCurso(CursoDto dto) {
		return new Curso(dto.getIdCurso(),dto.getDenominacion(),dto.getDuracion(),dto.getPrecio(),dto.getFechaInicio());
	}

	@Override
	public AlumnoDto alumnoToDto(Alumno alumno) {
		return new AlumnoDto(alumno.getUsuario(),alumno.getPassword(),alumno.getNombre(),alumno.getEmail(),alumno.getEdad());
	}

	@Override
	public Alumno dtoToAlumno(AlumnoDto dto) {
		return new Alumno(dto.getUsuario(),dto.getPassword(),dto.getNombre(),dto.getEmail(),dto.getEdad());
	}

}
