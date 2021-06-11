package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import conexion.Conexion;
import factory.DeportistaFactory;
import model.Deportista;
import model.Equipo;
import model.Piloto;

public class DAODeportista {
	private static DAODeportista daop = null;
	
	private DAODeportista() {
		
	}
	
	public static DAODeportista getDAOP() {
		if (daop == null)
			daop = new DAODeportista();
		return daop;
	}
	
	public List<Deportista> listadoDeportistas(int equipoId) {
		ResultSet rs;
		List<Deportista> lista = new ArrayList<>();

		Connection con = new Conexion().getConexion();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "select * from Deportista, tiene where c_jugador in (select c_jugador from tiene where c_equipo = " + equipoId + ")";
			rs = st.executeQuery(ordenSql);
			DAOEquipo daoe = DAOEquipo.getDAOE();
			while (rs.next()) {
				int id = rs.getInt("c_jugador");
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				Date fechaNacimiento = rs.getDate("fecha_nacimiento");
				Integer puntos = rs.getInt("puntos");
				int type = rs.getInt("c_deporte");
				int c_equipo = rs.getInt("c_equipo");
				Equipo equipo = daoe.equipo(equipoId);
				
				lista.add(DeportistaFactory.creaDeportista(id, nombre, apellidos, fechaNacimiento, type, puntos, equipo));
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return lista;
	}
}
