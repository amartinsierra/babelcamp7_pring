package converters;

import org.springframework.stereotype.Component;

import dtos.AlumnoDto;
import dtos.CursoDto;
import dtos.MatriculaDto;
import model.Alumno;
import model.Curso;
import model.Matricula;
import model.MatriculaPk;
@Component
public class ConversorEntityDtoImpl implements ConversorEntityDto {

	@Override
	public CursoDto cursoToDto(Curso curso) {
		return new CursoDto(curso.getIdCurso(), curso.getDenominacion(), curso.getDuracion(), curso.getPrecio(),curso.getFechaInicio() );
	}

	@Override
	public Curso dtoToCurso(CursoDto dto) {
		return new Curso(dto.getIdCurso(), dto.getDenominacion(), dto.getDuracion(), dto.getPrecio(),dto.getFechaInicio() );
	}

	@Override
	public AlumnoDto alumnoToDto(Alumno alumno) {
		return new AlumnoDto(alumno.getUsuario(), alumno.getPassword(), alumno.getNombre(), alumno.getEmail(), alumno.getEdad());
	}

	@Override
	public Alumno dtoToAlumno(AlumnoDto dto) {
		return new Alumno(dto.getUsuario(), dto.getPassword(), dto.getNombre(), dto.getEmail(), dto.getEdad());
	}

	@Override
	public MatriculaDto matriculaToDto(Matricula matricula) {
		return new MatriculaDto(matricula.getNota(), cursoToDto(matricula.getCurso()),alumnoToDto(matricula.getAlumno()) );
	}

	@Override
	public Matricula dtoToMatricula(MatriculaDto dto) {
		//return new Matricula(dto.getNota(), dtoToCurso(dto.getCursoDto()),dtoToAlumno(dto.getAlumnoDto()) );
		return new Matricula(new MatriculaPk(dto.getCursoDto().getIdCurso(),dto.getAlumnoDto().getUsuario()),dto.getNota(),null,null);
	}

}
