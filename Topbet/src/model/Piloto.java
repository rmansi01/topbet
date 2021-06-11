package model;

import java.util.Date;

public class Piloto extends Deportista{
	private int puntos;
	
	public Piloto(int id, String nombre, String apellidos, Date fechaNacimiento, int puntos, Equipo escuderia) {
		super(id, nombre, apellidos, fechaNacimiento, escuderia);
		this.puntos = puntos;
		
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	
	
}
