package dao;

import java.util.List;

import model.Alumno;

public interface AlumnosDao {
	Alumno findByUsuarioAndPassword(String usuario, String password);
	List<Alumno> findByCurso(String nombreCurso);
	Alumno findById(String usuario);
	void update(Alumno alumno);
	List<Alumno> findAll();
}
