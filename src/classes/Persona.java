package classes;

import java.io.Serializable;

public class Persona implements Serializable {

	private String nombre;
	private String apellidos;
	private String profesion;
	private int edad;
	
	public Persona(String nombre, String apellidos, String profesion, int edad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.profesion = profesion;
		this.edad = edad;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getProfesion() {
		return profesion;
	}



	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", profesion=" + profesion + ", edad=" + edad
				+ "]";
	}
	
	
}
