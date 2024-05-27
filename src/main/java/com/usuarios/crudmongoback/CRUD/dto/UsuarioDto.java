package com.usuarios.crudmongoback.CRUD.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UsuarioDto {
	@NotNull
	private int numIdentificacion;
	private String tipoIdentificacion;
	private String fechaNacimiento;
	private int edad;
	private int telefono;
	private String correo;
	@NotBlank(message = "La contraseña es obligatoria")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?=\\S+$).{8,}$", 
    message = "La contraseña debe tener al menos una mayúscula, un carácter especial, un número y una longitud mínima de 8 caracteres")
    private String contrasena;
	
	public UsuarioDto() {
		super();
	}

	public UsuarioDto(@NotNull int numIdentificacion, String tipoIdentificacion, String fechaNacimiento, int edad,
			int telefono, String correo,
			@NotBlank(message = "La contraseña es obligatoria") @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?=\\S+$).{8,}$", message = "La contraseña debe tener al menos una mayúscula, un carácter especial, un número y una longitud mínima de 8 caracteres") String contrasena) {
		super();
		this.numIdentificacion = numIdentificacion;
		this.tipoIdentificacion = tipoIdentificacion;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.telefono = telefono;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public int getNumIdentificacion() {
		return numIdentificacion;
	}

	public void setNumIdentificacion(int numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	

	
	
}
