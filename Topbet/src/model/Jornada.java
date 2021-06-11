package model;

import java.util.List;

public class Jornada {
	private List<Evento> eventos;
	private int numero;
	private Competicion competicion;
	public Jornada(List<Evento> eventos, int numero, Competicion competicion) {
		super();
		this.eventos = eventos;
		this.numero = numero;
		this.competicion = competicion;
	}
	public List<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Competicion getCompeticion() {
		return competicion;
	}
	public void setCompeticion(Competicion competicion) {
		this.competicion = competicion;
	}
	
	
	
	
}
