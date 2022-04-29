package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import model.Curso;
@Repository
public class CursosDaoImpl implements CursosDao {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Curso findById(int idCurso) {
		return entityManager.find(Curso.class, idCurso);
	}

	@Override
	public List<Curso> findAll() {
		String jpql = "select c from Curso c";
		TypedQuery<Curso> query = entityManager.createQuery(jpql,Curso.class);
		return query.getResultList();
	}

	@Override
	public List<Curso> findByAlumno(String usuario) {
		String jpql = "select c from Curso c join c.alumnos a where a.usuario=:usuario";
		TypedQuery<Curso> query = entityManager.createQuery(jpql,Curso.class);
		query.setParameter("usuario",usuario);		
		return query.getResultList();
	}

}
