package service;

import java.util.Date;
import java.util.List;

import dtos.AlumnoDto;
import dtos.CursoDto;
import model.Alumno;

public interface FormacionService 
{
	AlumnoDto validarUsuario(String usuario, String password);
	List<CursoDto> cursosAlumno(String usuario);
	List<CursoDto> cursos();
	List<AlumnoDto> alumnos();
	List<AlumnoDto> alumnosCurso(String nombre);
	boolean matricularAlumno(String usuario, int idCurso);
	
	boolean altaAlumno(AlumnoDto alumno);
	boolean altaCurso(CursoDto curso);
	List<CursoDto> consultarMatriculas(Date f1, Date f2);
	List<CursoDto> cursosPosiblesMatricularAlumno(String usuario);
}
