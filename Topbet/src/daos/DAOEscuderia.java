package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import conexion.Conexion;
import model.Competicion;
import model.Escuderia;
import model.Piloto;
import model.Usuario;

public class DAOEscuderia {
	public List<Piloto> listadoPilotos(Escuderia escuderia) {
		ResultSet rs;
		List<Piloto> lista = new ArrayList<>();

		Connection con = new Conexion().getConexion();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * FROM Deportista where c_jugador in (select c_jugador from tiene where c_equipo = " + escuderia.getC_equipo() + ")" ;
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				int id = rs.getInt("c_jugador");
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				Date fechaNacimiento = rs.getDate("f_nacimiento");
				int puntos = rs.getInt("puntos");
				
				lista.add(new Piloto(id, nombre, apellidos, fechaNacimiento, puntos, escuderia));
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
