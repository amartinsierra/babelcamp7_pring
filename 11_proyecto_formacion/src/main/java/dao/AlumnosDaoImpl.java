package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;
import model.Curso;

@Repository
public class AlumnosDaoImpl implements AlumnosDao {
	@PersistenceContext(unitName = "formacionPU")
	EntityManager entityManager;

	@Override
	public Alumno findByUsuarioAndPassword(String usuario, String password) {
		String jpql ="select a from Alumno a where a.usuario=:usuario and a.password=:password";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql,Alumno.class);
		query.setParameter("usuario",usuario);
		query.setParameter("password",password);
		try {
			return query.getSingleResult();
		}
		catch(NoResultException ex) {
			return null;
		}
	}

	@Override
	public List<Alumno> findByCurso(String nombreCurso) {
		String jpql = "select a from Alumno a join a.cursos c where c.denominacion=:nombre";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql,Alumno.class);
		query.setParameter("nombre", nombreCurso);
		return query.getResultList();
	}

	@Override
	public Alumno findById(String usuario) {
		return entityManager.find(Alumno.class, usuario);
	}
	@Transactional
	@Override
	public void update(Alumno alumno) {
		entityManager.merge(alumno);

	}

	@Override
	public List<Alumno> findAll() {
		String jpql = "select a from Alumno a";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql,Alumno.class);
		return query.getResultList();
	}

}
