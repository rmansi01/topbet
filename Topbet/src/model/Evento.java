package model;

import java.util.Date;
import java.util.List;

public class Evento {
	private int cEvento, jornada;
	private String nombre;
	private List<Apuesta> apuestas;
	private Date fecha;
	private Competicion competicion;
	public Evento(int cEvento, int jornada, List<Apuesta> apuestas, String nombre, Date fecha, Competicion competicion) {
		super();
		this.cEvento = cEvento;
		this.jornada = jornada;
		this.apuestas = apuestas;
		this.nombre = nombre;
		this.fecha = fecha;
		this.competicion = competicion;
	}
	public int getcEvento() {
		return cEvento;
	}
	public void setcEvento(int cEvento) {
		this.cEvento = cEvento;
	}
	public int getJornada() {
		return jornada;
	}
	public void setJornada(int jornada) {
		this.jornada = jornada;
	}
	public List<Apuesta> getApuestas() {
		return apuestas;
	}
	public void setApuesta(List<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Competicion getCompeticion() {
		return competicion;
	}
	public void setCompeticion(Competicion competicion) {
		this.competicion = competicion;
	}
	
	
}
