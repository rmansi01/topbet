package model;

import java.util.Date;

public class JugadorEquipo extends Deportista{
	private String posicion;
	private int puntosAnotados;
	public JugadorEquipo(int id, String nombre, String apellidos, Date fechaNacimiento, String posicion,
			int puntosAnotados) {
		super(id, nombre, apellidos, fechaNacimiento);
		this.posicion = posicion;
		this.puntosAnotados = puntosAnotados;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public int getPuntosAnotados() {
		return puntosAnotados;
	}
	public void setPuntosAnotados(int puntosAnotados) {
		this.puntosAnotados = puntosAnotados;
	}
	
	
}
