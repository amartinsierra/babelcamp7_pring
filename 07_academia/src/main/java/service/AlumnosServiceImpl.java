package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Alumno;
@Service
public class AlumnosServiceImpl implements AlumnosService {
	@Autowired
	private JdbcTemplate template;

	@Override
	public List<Alumno> alumnosCurso(String curso) {
		String sql="select * from alumnos where curso=?";
		return template.query(sql, 
				(r,f)->new Alumno(r.getInt("idAlumno"),
							r.getString("nombre"),
							r.getString("curso"),
							r.getDouble("nota")),
				curso);
	}

	@Override
	public boolean existeAlumno(String nombre) {
		String sql="select * from alumnos where nombre=?";
		List<Alumno> alumnos= template.query(sql, 
				(r,f)->new Alumno(r.getInt("idAlumno"),
							r.getString("nombre"),
							r.getString("curso"),
							r.getDouble("nota")),
				nombre);
		return alumnos.size()>0;
	}

	@Override
	public void altaAlumno(Alumno alumno) {
		if(!existeAlumno(alumno.getNombre())) {
			String sql="insert into alumnos(nombre,curso,nota) values(?,?,?)";
			template.update(sql,alumno.getNombre(),alumno.getCurso(),alumno.getNota());
		}
	}

	@Override
	public List<String> cursos() {
		String sql="select distinct(curso) from alumnos";
		return template.query(sql,
				(r,f)->r.getString(1));
	}

}
