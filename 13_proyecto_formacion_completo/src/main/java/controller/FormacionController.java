package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import model.Curso;
import service.FormacionService;

@Controller
public class FormacionController {
	@Autowired
	FormacionService service;
	
	@GetMapping(value="Alumnos",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> alumnos() {
		return service.alumnos();
	}
	@GetMapping(value="AlumnosCurso",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> alumnosCurso(@RequestParam("nombre") String nombreCurso) {
		
		return service.alumnosCurso(nombreCurso);
	}
	@GetMapping(value="CursosAlumno",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> cursosAlumno(@RequestParam("usuario") String usuario)  {
		
		return service.cursosAlumno(usuario);
	}
	@GetMapping(value="Cursos",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> cursos( ) {		
		return service.cursos();
	}
	@PostMapping("Login")
	public String autenticar(@RequestParam("user") String user, 
							@RequestParam("pwd") String pwd, 
							HttpSession sesion, 
							HttpServletRequest request) {
		Alumno alumno=service.validarUsuario(user, pwd);
		if(alumno!=null) {
			sesion.setAttribute("alumno", alumno);
			return "menu";
		}else {
			request.setAttribute("mensaje", "Usuario y/o contraseņa incorrectos");
			return "login";
		}
	}
	@PostMapping("AltaCurso")
	public String altaCurso(@ModelAttribute Curso curso) {
		return service.altaCurso(curso)?"menu":"altaCurso";
	}
	@PostMapping("AltaAlumno")
	public String altaAlumno(@ModelAttribute Alumno alumno) {
		return service.altaAlumno(alumno)?"menu":"altaAlumno";
	}
	/*@GetMapping(value="Matriculas",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> matriculas(@RequestParam("fechaIni") String fechaIni, @RequestParam("fechaFin") String fechaFin){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return service.consultarMatriculas(sdf.parse(fechaIni), sdf.parse(fechaFin));
		}catch(ParseException ex) {
			ex.printStackTrace();
			return null;
		}
	}*/
	@GetMapping(value="Matriculas",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> matriculas(@RequestParam("fechaIni") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaIni, 
												@RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin){
		
			return service.consultarMatriculas(fechaIni, fechaFin);
		
	}
}
