package model;

public class CuentaBancaria {
	private String iban, titular;
	private Usuario usuario;
	private int id;
	public CuentaBancaria(String iban, String titular, Usuario usuario, int id) {
		super();
		this.iban = iban;
		this.titular = titular;
		this.usuario = usuario;
		this.id = id;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
