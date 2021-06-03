package model;

import java.util.Date;

public class Usuario {
	protected int id, nBonos;
	protected String nombre, nickname, phone, nif, apellidos, pass, mail;
	protected Date fNacimiento;
	
	public Usuario(int id, int nBonos, String nombre, String nickname, String phone, String nif, String apellidos,
			String pass, String mail, Date fNacimiento) {
		super();
		this.id = id;
		this.nBonos = nBonos;
		this.nombre = nombre;
		this.nickname = nickname;
		this.phone = phone;
		this.nif = nif;
		this.apellidos = apellidos;
		this.pass = pass;
		this.mail = mail;
		this.fNacimiento = fNacimiento;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getnBonos() {
		return nBonos;
	}


	public void setnBonos(int nBonos) {
		this.nBonos = nBonos;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getNif() {
		return nif;
	}


	public void setNif(String nif) {
		this.nif = nif;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public Date getfNacimiento() {
		return fNacimiento;
	}


	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}


	public void setPass(String actual, String pass) {
		if (checkPassword(actual))
			this.pass = pass;
	}

	public boolean checkPassword(String password) {
		return pass.equals(password);
	}
	
	
	
	
}
