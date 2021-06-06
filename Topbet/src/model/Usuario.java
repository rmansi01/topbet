package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {
	protected int id, nBonos;
	protected String nombre, nickname, phone, nif, apellidos, pass, mail, dir1, dir2, c_postal, ciudad, pais;
	protected Date fNacimiento;
	
	public Usuario(int id, int nBonos, String nombre, String nickname, String phone, String nif, String apellidos,
			String pass, String mail, Date fNacimiento, String dir1, String dir2, String c_postal, String ciudad, String pais) {
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
		this.dir1 = dir1;
		this.dir2 = dir2;
		this.c_postal = c_postal;
		this.ciudad = ciudad;
		this.pais = pais;
	}
	
	public int getId() {
		return id;
	}


	public String getDir1() {
		return dir1;
	}

	public void setDir1(String dir1) {
		this.dir1 = dir1;
	}

	public String getDir2() {
		return dir2;
	}

	public void setDir2(String dir2) {
		this.dir2 = dir2;
	}

	public String getC_postal() {
		return c_postal;
	}

	public void setC_postal(String c_postal) {
		this.c_postal = c_postal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
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
