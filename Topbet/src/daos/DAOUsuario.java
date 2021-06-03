package daos;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import model.Usuario;

public class DAOUsuario {
	// select de todos los usuarios
	public List<Usuario> listado() {
		ResultSet rs;
		List<Usuario> lista = new ArrayList<>();

		Connection con = new Conexion().getConexion();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * FROM USUARIO";
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				int id = rs.getInt("c_usuario");
				String name = rs.getString("nombre");
				String surname = rs.getString("apellidos");
				String password = rs.getString("password");
				Boolean admin = rs.getBoolean("admin");
				Date f_nacimiento = rs.getDate("f_nacimiento");
				String mail = rs.getString("mail");
				int nBonos = rs.getInt("n_bonos");
				String nif = rs.getString("nif");
				String phone = rs.getString("telefono");
				String nick = rs.getString("nickname");
				lista.add(new Usuario(id, nBonos, name, nick, phone, nif, surname, password, mail, f_nacimiento));
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return lista;
	}
	
	// select de un usuario concreto
	public Usuario getUsuario(int id) {
		ResultSet rs;
		Connection con = new Conexion().getConexion();
		Statement st;
		String select = "select * from usuario where id = " + id;
		try {
			st = con.createStatement();
			rs = st.executeQuery(select);
			while (rs.next()) {
				int id = rs.getInt("c_usuario");
				String name = rs.getString("nombre");
				String surname = rs.getString("apellidos");
				String password = rs.getString("password");
				Boolean admin = rs.getBoolean("admin");
				Date f_nacimiento = rs.getDate("f_nacimiento");
				String mail = rs.getString("mail");
				int nBonos = rs.getInt("n_bonos");
				String nif = rs.getString("nif");
				String phone = rs.getString("telefono");
				String nick = rs.getString("nickname");
				Usuario usuario = new Usuario(id, nBonos, name, nick, phone, nif, surname, password, mail, f_nacimiento);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BD");
		}
	}
}