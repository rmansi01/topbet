package model;

public class Equipo {
	private int c_equipo, puntos;
	private String nombre, sede, pais, urlEscudo;
	private boolean seleccion;
	
	
	public Equipo(int c_equipo, String nombre, String sede, String pais, String urlEscudo, boolean seleccion) {
		super();
		this.c_equipo = c_equipo;
		this.nombre = nombre;
		this.sede = sede;
		this.pais = pais;
		this.urlEscudo = urlEscudo;
		this.seleccion = seleccion;
	}


	public Equipo(int c_equipo, int puntos, String nombre, String sede, String pais, String urlEscudo,
			boolean seleccion) {
		super();
		this.c_equipo = c_equipo;
		this.puntos = puntos;
		this.nombre = nombre;
		this.sede = sede;
		this.pais = pais;
		this.urlEscudo = urlEscudo;
		this.seleccion = seleccion;
	}


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}


	public int getC_equipo() {
		return c_equipo;
	}
	public void setC_equipo(int c_equipo) {
		this.c_equipo = c_equipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getUrlEscudo() {
		return urlEscudo;
	}
	public void setUrlEscudo(String urlEscudo) {
		this.urlEscudo = urlEscudo;
	}
	public boolean isSeleccion() {
		return seleccion;
	}
	public void setSeleccion(boolean seleccion) {
		this.seleccion = seleccion;
	}
	@Override
	public String toString() {
		return "Equipo [c_equipo=" + c_equipo + ", nombre=" + nombre + ", sede=" + sede + ", pais=" + pais
				+ ", urlEscudo=" + urlEscudo + ", seleccion=" + seleccion + "]";
	}
	
	
	
}
