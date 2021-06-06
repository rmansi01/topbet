package model;

import java.util.List;
import java.util.Map;

public class Escuderia extends Equipo {
	private List<Piloto> pilotos;
	private Map<Evento, Integer> puntosCarrera;
	public Escuderia(int c_equipo, String nombre, String sede, String pais, String urlEscudo, boolean seleccion,
			List<Piloto> pilotos, Map<Evento, Integer> puntosCarrera) {
		super(c_equipo, nombre, sede, pais, urlEscudo, seleccion);
		this.pilotos = pilotos;
		this.puntosCarrera = puntosCarrera;
	}
	public List<Piloto> getPilotos() {
		return pilotos;
	}
	public void setPilotos(List<Piloto> pilotos) {
		this.pilotos = pilotos;
	}
	public Map<Evento, Integer> getPuntosCarrera() {
		return puntosCarrera;
	}
	public void setPuntosCarrera(Map<Evento, Integer> puntosCarrera) {
		this.puntosCarrera = puntosCarrera;
	}
	
	
}
