package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.Conexion;
import model.Deporte;

public class DAODeporte {
	private static DAODeporte daod = null;
	
	private DAODeporte() {
		
	}
	
	public static DAODeporte getDAODeporte() {
		if (daod == null)
			daod = new DAODeporte();
		return daod;
	}
	
	// select
	public Deporte getDeporte(int id) {
		ResultSet rs;

		// Acceso a base de datos MySQL
		Connection con = new Conexion().getConexion();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * from Deporte where c_deporte = " + id;
			rs = st.executeQuery(ordenSql);

			if (rs.next()) {
				String nombre = rs.getString("nombre");
				return new Deporte(id, nombre);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out
					.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return null;
	}

}
