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
import model.Usuario;

public class DAOCompticionMotor extends DAOCompeticion {
	public List<Competicion> listadoPilotos(int ) {
		ResultSet rs;
		List<Competicion> lista = new ArrayList<>();

		Connection con = new Conexion().getConexion();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * FROM Competicion where c_deporte = " + idDeporte;
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
				String dir1 = rs.getString("dir1");
				String dir2 = rs.getString("dir2");
				String ciudad = rs.getString("ciudad");
				String c_postal = rs.getString("c_postal");
				String pais = rs.getString("Pais");
				lista.add(new Usuario(id, nBonos, name, nick, phone, nif, surname, password, mail, f_nacimiento, dir1,
						dir2, ciudad, c_postal, pais));
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
