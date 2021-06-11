package model;

import java.util.Date;
import java.util.List;

public class EventoMotor extends Evento{
	private List<Piloto> parrillaInicial, resultado;
	
	public EventoMotor(int cEvento, int jornada, List<Apuesta> apuestas, String nombre, Date fecha,
			List<Equipo> equipos, Competicion competicion, List<Piloto> parrillaInicial, List<Piloto> resultado) {
		super(cEvento, jornada, apuestas, nombre, fecha, competicion, equipos);
		this.parrillaInicial = parrillaInicial;
		this.resultado = resultado;
	}

	public List<Piloto> getParrillaInicial() {
		return parrillaInicial;
	}

	public void setParrillaInicial(List<Piloto> parrillaInicial) {
		this.parrillaInicial = parrillaInicial;
	}

	public List<Piloto> getResultado() {
		return resultado;
	}

	public void setResultado(List<Piloto> resultado) {
		this.resultado = resultado;
	}
	
}
