package model;

import java.util.List;

public class CompeticionMotor extends Competicion{
	private List<Piloto> pilotos;

	public CompeticionMotor(int id, String nombre, String temporada, Deporte deporte, List<Equipo> equipos, List<Piloto> pilotos) {
		super(id, nombre, temporada, deporte, equipos);
		this.pilotos = pilotos;
	}

	public List<Piloto> getPilotos() {
		return pilotos;
	}

	public void setPilotos(List<Piloto> pilotos) {
		this.pilotos = pilotos;
	}
	
	
}
