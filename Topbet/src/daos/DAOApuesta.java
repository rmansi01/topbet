package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import model.Apuesta;
import model.Deporte;
import model.Evento;
import model.Usuario;

public class DAOApuesta {
	private static DAOApuesta daoa = null;
	
	private DAOApuesta() {
		
	}
	
	public static DAOApuesta getDAOApuesta() {
		if (daoa == null)
			daoa = new DAOApuesta();
		return daoa;
	}
	
	// select
	public List<Apuesta> listado(Usuario usuario) {
		ResultSet rs;
		List<Apuesta> lista = new ArrayList<>();

		Connection con = new Conexion().getConexion();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * from Apuesta where c_usuario = " + usuario.getId();
			rs = st.executeQuery(ordenSql);
			DAODeporte daod = DAODeporte.getDAODeporte();
			
			

			while (rs.next()) {
				int id = rs.getInt("c_apuesta");
				int cantidadApostada = rs.getInt("cantidad_apostada");
				int cuota = rs.getInt("cuota");
				String desc = rs.getString("descripcion_apuesta");
				int idEvento = rs.getInt("c_evento");
				int idDeporte = rs.getInt("c_deporte");
				Deporte deporte = daod.getDeporte(idDeporte);
				lista.add(new Apuesta(id, cantidadApostada, cuota, desc, usuario, deporte));
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out
					.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return lista;
	}
	
	// select
		public List<Apuesta> listado(int evento) {
			ResultSet rs;
			List<Apuesta> lista = new ArrayList<>();

			Connection con = new Conexion().getConexion();
			Statement st;
			try {
				st = con.createStatement();
				String ordenSql = "SELECT * from Apuesta where c_evento = " + evento;
				rs = st.executeQuery(ordenSql);
				DAODeporte daod = DAODeporte.getDAODeporte();
				DAOUsuario daou = DAOUsuario.getDAOU();
				

				while (rs.next()) {
					int id = rs.getInt("c_apuesta");
					int cantidadApostada = rs.getInt("cantidad_apostada");
					int cuota = rs.getInt("cuota");
					String desc = rs.getString("descripcion_apuesta");
					int idEvento = rs.getInt("c_evento");
					int idDeporte = rs.getInt("c_deporte");
					int cUsuario = rs.getInt("c_usuario");
					Usuario user = daou.getUsuario(cUsuario);
					Deporte deporte = daod.getDeporte(idDeporte);
					lista.add(new Apuesta(id, cantidadApostada, cuota, desc, user, deporte));
				}
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				System.out
						.println("Error al acceder a la BDs: " + e.getMessage());
			}
			return lista;
		}

}
