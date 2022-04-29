package dtos;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AlumnoDto {
	private String usuario;
	private String password;
	private String nombre;
	private String email;
	private Integer edad;
}
