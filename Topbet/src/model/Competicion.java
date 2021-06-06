package model;

import java.util.List;

public class Competicion {
	private int id;
	private String nombre, temporada;
	private Deporte deporte;
	private List<Equipo> equipos;
	private List<Deportista> jugadores;
	
	public Competicion(int id, String nombre, String temporada, Deporte deporte, List<Equipo> equipos,
			List<Deportista> jugadores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.temporada = temporada;
		this.deporte = deporte;
		this.equipos = equipos;
		this.jugadores = jugadores;
	}
	
	
	public List<Equipo> getEquipos() {
		return equipos;
	}
	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
	public List<Deportista> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Deportista> jugadores) {
		this.jugadores = jugadores;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTemporada() {
		return temporada;
	}
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	public Deporte getDeporte() {
		return deporte;
	}
	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}
	
	
}
