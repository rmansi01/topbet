package model;

public class Competicion {
	private int id;
	private String nombre, temporada;
	private Deporte deporte;
	public Competicion(int id, String nombre, String temporada, Deporte deporte) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.temporada = temporada;
		this.deporte = deporte;
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
