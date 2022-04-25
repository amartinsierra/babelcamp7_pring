package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import service.AlumnosService;
@CrossOrigin("*")
@Controller
public class AlumnosController {
	@Autowired
	AlumnosService alumnosService;
	
	@GetMapping(value="Cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> cursos(){
		return alumnosService.cursos();
	}
	@GetMapping(value="Alumnos", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> alumnos(@RequestParam("curso") String curso){
		return alumnosService.alumnosCurso(curso);
	}
	
	@PostMapping(value="Alta")
	public String alta(@ModelAttribute Alumno alumno) {
		if(!alumnosService.existeAlumno(alumno.getNombre())) {
			alumnosService.altaAlumno(alumno);
			return "redirect:/inicio";
		}else {
			return "redirect:/error";
		}
	}
	
	@GetMapping(value="inicio")
	public String inicio() {
		return "inicio";
	}
	
	
	
}
