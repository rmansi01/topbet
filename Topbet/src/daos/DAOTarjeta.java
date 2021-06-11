package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import conexion.Conexion;
import model.Tarjeta;
import model.Usuario;

public class DAOTarjeta {
	private static DAOTarjeta daot = null;
	private DAOTarjeta() {
		
	}
	public static DAOTarjeta getDAOT() {
		if (daot == null)
			daot = new DAOTarjeta();
		return daot;
	}
	
	// insert
		public void insertaTarjeta(Tarjeta tarjeta) {
			// No introduzco las claves porque es autonumerica
			Connection con = new Conexion().getConexion();
			try {
				String ordenSQL;
				ordenSQL = "insert into Tarjeta values(?,?,?,?,?,?)";
				PreparedStatement st = (PreparedStatement) con.prepareStatement(ordenSQL);
				st.setString(1, tarjeta.getNumero());
				st.setInt(2, tarjeta.getMes());
				st.setInt(3, tarjeta.getAnno());
				st.setInt(4, tarjeta.getCvv());
				st.setString(5, tarjeta.getTitular());
				st.setInt(6, tarjeta.getUsuario().getId());
				st.executeUpdate();
				st.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al insertar datos en la BDs: " + e.getMessage());
			}
		}
		
		// Read
		public List<Tarjeta> listado(Usuario usuario) {
			ResultSet rs;
			List<Tarjeta> lista = new ArrayList<>();

	// Acceso a base de datos MySQL
			Connection con = new Conexion().getConexion();
			Statement st;
			try {
				st = con.createStatement();
				String ordenSql = "SELECT * from tarjeta where c_usuario = " + usuario.getId();
				rs = st.executeQuery(ordenSql);

				while (rs.next()) {
					int id = rs.getInt("c_tarjeta");
					String numero = rs.getString("numero");
					String titular = rs.getString("titular");
					int mes = rs.getInt("mes");
					int anno = rs.getInt("anno");
					int cvv = rs.getInt("cvv");
					lista.add(new Tarjeta(id, numero, titular, cvv, mes, anno, usuario));
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
		
		// delete
		public int borraClase(int clave) {
			int borrados=-1;
	// Acceso a base de datos MySQL
			Connection con = new Conexion().getConexion();

			String ordenSQL = "delete from tarjeta where c_tarjeta= " + clave;
			try {
				PreparedStatement st = (PreparedStatement) con.prepareStatement(ordenSQL);
				st.setInt(1, clave);
				borrados = st.executeUpdate();
				st.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al eliminar datos en la BDs: " + e.getMessage());
			}
			return borrados;
		}


		
		

}
