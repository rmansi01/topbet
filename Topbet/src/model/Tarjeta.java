package model;

import java.util.Date;

public class Tarjeta {
	private String numero, titular;
	private int cvv, mes, anno;
	private Usuario usuario;
	private int id;
	
	public Tarjeta(int id, String numero, String titular, int cvv, int mes, int anno, Usuario usuario) {
		super();
		this.numero = numero;
		this.titular = titular;
		this.cvv = cvv;
		this.mes = mes;
		this.anno = anno;
		this.id = id;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	
	
	
}
