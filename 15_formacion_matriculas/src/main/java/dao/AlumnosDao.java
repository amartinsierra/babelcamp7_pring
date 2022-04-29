package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;

public interface AlumnosDao extends JpaRepository<Alumno,String>{
	
	Alumno findByUsuarioAndPassword(String u, String p);
	@Query("select a from Alumno a join a.matriculas m where m.curso.denominacion=?1")
	List<Alumno> findByCurso(String nombreCurso);
	/* Esto es una alternativa a la configuración de la propiedad que evita
	 * que Hibernate cierre las conexiones después de carga lazy
	@Query("select a from Alumno a join fetch a.cursos c")
	List<Alumno> findAll();
	*/
	
}
