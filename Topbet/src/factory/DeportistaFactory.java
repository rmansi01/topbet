package factory;

import java.util.Date;

import model.Deportista;
import model.Equipo;
import model.Piloto;

public class DeportistaFactory {
	public static Deportista creaDeportista(int id, String nombre, String apellidos, Date fechaNacimiento, int type,
			int puntos, Equipo equipo) {
		if (type == 4 || type == 5)
			return new Piloto(id, nombre, apellidos, fechaNacimiento, puntos, equipo);
		else 
			return new Deportista(id, nombre, apellidos, fechaNacimiento, equipo);
	}
}
