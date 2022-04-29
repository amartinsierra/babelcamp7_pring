package dao;

import java.util.List;

import model.Curso;

public interface CursosDao {
	Curso findById(int idCurso);
	List<Curso> findAll();
	List<Curso> findByAlumno(String usuario);
}
