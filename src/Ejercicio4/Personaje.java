package Ejercicio4;

import java.io.Serializable;

public class Personaje implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id, peso, altura;
	private String dni, nombre, identidad, tipo;
	private int telefono;
	
	public Personaje() {
		super();
	}

	public Personaje(int id, String dni, String nombre, String identidad, String tipo, int peso, int altura) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.identidad = identidad;
		this.tipo = tipo;
		this.peso = peso;
		this.altura = altura;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDNI() {
		return dni;
	}
	public void setDNI(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdentidad() {
		return identidad;
	}
	public void setIdentidad(String identidad) {
		this.identidad = identidad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public String toString() {
		return "Personaje [dni=" + getDNI()+ ", nombre=" + getNombre() + " , identidad=" + getIdentidad() + 
				" tipo=" + getTipo() + " , peso=" + getPeso() + ", altura=" + getAltura() + "]";
		
	}
}

