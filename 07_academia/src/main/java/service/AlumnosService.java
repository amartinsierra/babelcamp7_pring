package service;

import java.util.List;

import model.Alumno;

public interface AlumnosService {
	List<Alumno> alumnosCurso(String curso);
	boolean existeAlumno(String nombre);
	void altaAlumno(Alumno alumno);
	List<String> cursos();
}
