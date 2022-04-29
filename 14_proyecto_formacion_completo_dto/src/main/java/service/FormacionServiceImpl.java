package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import converters.ConversorEntityDto;
import dao.AlumnosDao;
import dao.CursosDao;
import dtos.AlumnoDto;
import dtos.CursoDto;
import model.Alumno;
import model.Curso;
@Service
public class FormacionServiceImpl implements FormacionService {
	
	@Autowired
	ConversorEntityDto conversor;
	
	AlumnosDao alumnosDao;
	
	
	CursosDao cursosDao;
	
	
	public FormacionServiceImpl(@Autowired AlumnosDao alumnosDao,@Autowired CursosDao cursosDao) {
		this.alumnosDao=alumnosDao;
		this.cursosDao=cursosDao;
	}

	@Override
	public AlumnoDto validarUsuario(String usuario, String password) {
		return conversor.alumnoToDto(alumnosDao.findByUsuarioAndPassword(usuario, password));
	}

	@Override
	public List<CursoDto> cursosAlumno(String usuario) {
		return cursosDao.findByAlumno(usuario)
				.stream()
				.map(c->conversor.cursoToDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<CursoDto> cursos() {
		return cursosDao.findAll()
				.stream()
				.map(c->conversor.cursoToDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<AlumnoDto> alumnosCurso(String nombre) {
		return alumnosDao.findByCurso(nombre)
				.stream()
				.map(a->conversor.alumnoToDto(a))
				.collect(Collectors.toList());
	}

	@Override
	public boolean matricularAlumno(String usuario, int idCurso) {
		/*CursoDto curso=cursosDao.findById(idCurso).orElse(null);
		Alumno alumno=alumnosDao.findById(usuario).orElse(null);
		if(curso!=null&&alumno!=null) {
			alumno.getCursos().add(curso);
			alumnosDao.save(alumno);
			return true;
		}
		return false;*/
		Optional<Curso> curso=cursosDao.findById(idCurso);
		Optional<Alumno> alumno=alumnosDao.findById(usuario);
		if(curso.isPresent()&&alumno.isPresent()) {
			Alumno al=alumno.get();
			al.getCursos().add(curso.get());
			alumnosDao.save(al);
			return true;
		}
		return false;
		
	}
	
	
	@Override
	public List<AlumnoDto> alumnos() {
		return alumnosDao.findAll()
				.stream()
				.map(a->conversor.alumnoToDto(a))
				.collect(Collectors.toList());
	}

	@Override
	public boolean altaAlumno(AlumnoDto alumno) {
		if(alumnosDao.findById(alumno.getUsuario()).isEmpty()) {
			alumnosDao.save(conversor.dtoToAlumno(alumno));
			return true;
		}
		return false;
	}

	@Override
	public boolean altaCurso(CursoDto curso) {
		if(cursosDao.findByDenominacion(curso.getDenominacion()).size()==0) {
			cursosDao.save(conversor.dtoToCurso(curso));
			return true;
		}
		return false;
	}

	@Override
	public List<CursoDto> consultarMatriculas(Date f1, Date f2) {
		return cursosDao.findByFechaInicioBetween(f1, f2)
				.stream()
				.map(c->conversor.cursoToDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<CursoDto> cursosPosiblesMatricularAlumno(String usuario) {
		return cursosDao.findCursosNoAlumno(usuario)
				.stream()
				.map(c->conversor.cursoToDto(c))
				.collect(Collectors.toList());
	}
	

	
}
