package model;

import java.util.Date;
import java.util.List;

public class EventoEquipos extends Evento{
	private Equipo local, visitante;
	private int puntosLocal, puntosVisitante;
	public EventoEquipos(int cEvento, int jornada, List<Apuesta> apuestas, String nombre, Date fecha,
			Competicion competicion, List<Equipo> equipos, int puntosLocal,
			int puntosVisitante) {
		super(cEvento, jornada, apuestas, nombre, fecha, competicion, equipos);
		this.local = equipos.get(0);
		this.visitante = equipos.get(1);
		this.puntosLocal = puntosLocal;
		this.puntosVisitante = puntosVisitante;
	}
	public Equipo getLocal() {
		return local;
	}
	public void setLocal(Equipo local) {
		this.local = local;
	}
	public Equipo getVisitante() {
		return visitante;
	}
	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}
	public int getPuntosLocal() {
		return puntosLocal;
	}
	public void setPuntosLocal(int puntosLocal) {
		this.puntosLocal = puntosLocal;
	}
	public int getPuntosVisitante() {
		return puntosVisitante;
	}
	public void setPuntosVisitante(int puntosVisitante) {
		this.puntosVisitante = puntosVisitante;
	}
	
	
}
