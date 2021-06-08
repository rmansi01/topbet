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
import model.Deporte;
import model.Equipo;
import model.Usuario;

public class DAOCompeticion {
	public List<Competicion> listadoCompeticiones(Deporte deporte, List<Equipo> deportistas) {
		ResultSet rs;
		List<Competicion> lista = new ArrayList<>();

		Connection con = new Conexion().getConexion();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * FROM Competicion where c_deporte = " + deporte.getId();
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				int id = rs.getInt("c_competicion");
				String nombre = rs.getString("nombre");
				String temporada = rs.getString("temporada");
				lista.add(new Competicion(id, nombre, temporada, deporte, deportistas ));
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