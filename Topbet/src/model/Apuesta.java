package model;

public class Apuesta {
	private int id, cantidad, cuota;
	private String descripcion;
	private Usuario usuario;
	private Deporte deporte;
	public Apuesta(int id, int cantidad, int cuota, String descripcion, Usuario usuario, Deporte deporte) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.cuota = cuota;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.deporte = deporte;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCuota() {
		return cuota;
	}
	public void setCuota(int cuota) {
		this.cuota = cuota;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Deporte getDeporte() {
		return deporte;
	}
	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}
	
	
	
}
