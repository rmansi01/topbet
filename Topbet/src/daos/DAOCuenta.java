package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import conexion.Conexion;
import model.CuentaBancaria;
import model.Tarjeta;
import model.Usuario;

public class DAOCuenta {
	private static DAOCuenta daoc = null;
	
	private DAOCuenta() {
		
	}
	
	public static DAOCuenta getDAOC() {
		if (daoc == null)
			daoc = new DAOCuenta();
		return daoc;
	}
	
	// insert
			public void insertaCuenta(CuentaBancaria cuenta) {
				// No introduzco las claves porque es autonumerica
				Connection con = new Conexion().getConexion();
				try {
					String ordenSQL;
					ordenSQL = "insert into Tarjeta values(?,?,?)";
					PreparedStatement st = (PreparedStatement) con.prepareStatement(ordenSQL);
					st.setString(1, cuenta.getIban());
					st.setString(2, cuenta.getTitular());
					st.setInt(3, cuenta.getUsuario().getId());
					st.executeUpdate();
					st.close();
					con.close();
				} catch (SQLException e) {
					System.out.println("Error al insertar datos en la BDs: " + e.getMessage());
				}
			}
			
			// Read
			public List<CuentaBancaria> listado(Usuario usuario) {
				ResultSet rs;
				List<CuentaBancaria> lista = new ArrayList<>();

		// Acceso a base de datos MySQL
				Connection con = new Conexion().getConexion();
				Statement st;
				try {
					st = con.createStatement();
					String ordenSql = "SELECT * from tarjeta where c_usuario = " + usuario.getId();
					rs = st.executeQuery(ordenSql);

					while (rs.next()) {
						int id = rs.getInt("c_cuenta");
						String iban = rs.getString("iban");
						String titular = rs.getString("titular");
						lista.add(new CuentaBancaria(iban, titular, usuario, id));
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

				String ordenSQL = "delete from cuenta where c_cuenta= " + clave;
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
