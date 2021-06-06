package model;

import java.util.Date;

public class Piloto extends Deportista{
	private int puntos;
	private Escuderia escuderia;
	public Piloto(int id, String nombre, String apellidos, Date fechaNacimiento, int puntos, Escuderia escuderia) {
		super(id, nombre, apellidos, fechaNacimiento);
		this.puntos = puntos;
		this.escuderia = escuderia;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public Escuderia getEscuderia() {
		return escuderia;
	}
	public void setEscuderia(Escuderia escuderia) {
		this.escuderia = escuderia;
	}
	
	
}
