package service;

import java.util.Date;
import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService 
{
	Alumno validarUsuario(String usuario, String password);
	List<Curso> cursosAlumno(String usuario);
	List<Curso> cursos();
	List<Alumno> alumnos();
	List<Alumno> alumnosCurso(String nombre);
	boolean matricularAlumno(String usuario, int idCurso);
	
	boolean altaAlumno(Alumno alumno);
	boolean altaCurso(Curso curso);
	List<Curso> consultarMatriculas(Date f1, Date f2);
	List<Curso> cursosPosiblesMatricularAlumno(String usuario);
}
