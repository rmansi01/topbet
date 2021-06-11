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
	
	private static DAOCompeticion daoc = null;
	private DAOCompeticion() {
		
	}
	
	public static DAOCompeticion getDAOC() {
		if (daoc == null)
			daoc = new DAOCompeticion();
		return daoc;
	}
	
	public List<Competicion> listadoCompeticiones(Deporte deporte) {
		ResultSet rs;
		List<Competicion> lista = new ArrayList<>();

		Connection con = new Conexion().getConexion();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * FROM Competicion where c_deporte = " + deporte.getId();
			rs = st.executeQuery(ordenSql);
			DAOEquipo daoe = DAOEquipo.getDAOE();
			while (rs.next()) {
				int id = rs.getInt("c_competicion");
				String nombre = rs.getString("nombre");
				String temporada = rs.getString("temporada");
				List<Equipo> equipos = daoe.listadoEquipos(id);
				lista.add(new Competicion(id, nombre, temporada, deporte, equipos ));
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return lista;
	}
	
	public Competicion getCompeticion(int id) {
		ResultSet rs;
		Competicion competicion = null;
		Connection con = new Conexion().getConexion();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * FROM Competicion where c_competicion = " + id;
			rs = st.executeQuery(ordenSql);
			DAOEquipo daoe = DAOEquipo.getDAOE();
			DAODeporte daod = DAODeporte.getDAODeporte();
			if (rs.next()) {
//				int id = rs.getInt("c_competicion");
				String nombre = rs.getString("nombre");
				String temporada = rs.getString("temporada");
				int c_deporte = rs.getInt("c_deporte");
				Deporte deporte = daod.getDeporte(c_deporte);
				List<Equipo> equipos = daoe.listadoEquipos(id);
				competicion = new Competicion(id, nombre, temporada, deporte, equipos );
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return competicion;
	}
}