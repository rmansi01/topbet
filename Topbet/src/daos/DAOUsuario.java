package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import model.Usuario;

public class DAOUsuario {
	
	private static DAOUsuario daou = null;
	
	private DAOUsuario() {
		
	}
	
	public static DAOUsuario getDAOU() {
		if (daou == null)
			daou = new DAOUsuario();
		return daou;
	}
	
	// Operaciones CRUD
	// Create
	@SuppressWarnings("deprecation")
	public void insertaUsuario(Usuario usuario, boolean admin, String password) {
		int clave;
		Connection con = new Conexion().getConexion();
		try {
			String ordenSQL;
			ordenSQL = "insert into Usuario values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(ordenSQL);
			st.setString(1, usuario.getNombre());
			st.setString(2, usuario.getApellidos());
			st.setDate(3, new java.sql.Date(usuario.getfNacimiento().getYear(), usuario.getfNacimiento().getMonth(),
					usuario.getfNacimiento().getDate()));
			st.setString(4, usuario.getMail());
			st.setString(5, usuario.getNickname());
			st.setInt(6, 0);
			st.setBoolean(7, admin);
			st.setString(8, usuario.getNif());
			st.setString(9, usuario.getPhone());
			st.setString(10, password);
			st.setString(11, usuario.getDir1());
			st.setString(12, usuario.getDir2());
			st.setString(13, usuario.getCiudad());
			st.setString(14, usuario.getC_postal());
			st.setString(15, usuario.getPais());
			st.setBoolean(16, false);
			st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar datos en la BDs: " + e.getMessage());
		}
	}

	// R
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
				String dir1 = rs.getString("dir1");
				String dir2 = rs.getString("dir2");
				String ciudad = rs.getString("ciudad");
				String c_postal = rs.getString("c_postal");
				String pais = rs.getString("Pais");
				boolean banned = rs.getBoolean("banned");
				lista.add(new Usuario(id, nBonos, name, nick, phone, nif, surname, password, mail, f_nacimiento, dir1,
						dir2, ciudad, c_postal, pais, banned));
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
	public Usuario getUsuario(String mail) {
		ResultSet rs;
		Connection con = new Conexion().getConexion();
		Statement st;
		String select = "select * from Usuario where mail = '" + mail + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(select);

			if (rs.next()) {
				int id = rs.getInt("c_usuario");
				String name = rs.getString("nombre");
				String surname = rs.getString("apellidos");
				String password = rs.getString("password");
				Boolean admin = rs.getBoolean("admin");
				Date f_nacimiento = rs.getDate("f_nacimiento");
//			String mail = rs.getString("mail");
				int nBonos = rs.getInt("n_bonos");
				String nif = rs.getString("nif");
				String phone = rs.getString("telefono");
				String nick = rs.getString("nickname");
				String dir1 = rs.getString("direccion1");
				String dir2 = rs.getString("direcccion2");
				String ciudad = rs.getString("ciudad");
				String c_postal = rs.getString("c_postal");
				String pais = rs.getString("Pais");
				boolean banned = rs.getBoolean("banned");
				rs.close();
				st.close();
				con.close();
				return new Usuario(id, nBonos, name, nick, phone, nif, surname, password, mail, f_nacimiento, dir1,
						dir2, ciudad, c_postal, pais, banned);
			}
			return null;
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BD: " + e.getMessage());
			return null;
		}
	}
	
	public Usuario getUsuario(int id) {
		ResultSet rs;
		Connection con = new Conexion().getConexion();
		Statement st;
		String select = "select * from Usuario where c_usuario = " + id ;
		try {
			st = con.createStatement();
			rs = st.executeQuery(select);

			if (rs.next()) {
//				int id = rs.getInt("c_usuario");
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
				String dir1 = rs.getString("direccion1");
				String dir2 = rs.getString("direcccion2");
				String ciudad = rs.getString("ciudad");
				String c_postal = rs.getString("c_postal");
				String pais = rs.getString("Pais");
				boolean banned = rs.getBoolean("banned");
				rs.close();
				st.close();
				con.close();
				return new Usuario(id, nBonos, name, nick, phone, nif, surname, password, mail, f_nacimiento, dir1,
						dir2, ciudad, c_postal, pais, banned);
			}
			return null;
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BD: " + e.getMessage());
			return null;
		}
	}
	
	// U
	// Update user
	public int actualizaUsuarioWithPass(Usuario usuario, Boolean admin, String password) {
		int actualizados = -1;
		Connection con = new Conexion().getConexion();
		String ordenSQL = "update Usuario set nombre=?,apellidos=?, f_nacimiento=?, mail=?, nickname=?, admin=?, nif=?, telefono=?, password=?, direccion1 =?, direcccion2=?, ciudad=?, c_postal =?, pais=? where c_usuario=" + usuario.getId();
		try {
			PreparedStatement st = con.prepareStatement(ordenSQL);
			st.setString(1, usuario.getNombre());
			st.setString(2, usuario.getApellidos());
			st.setDate(3, new java.sql.Date(usuario.getfNacimiento().getYear(), usuario.getfNacimiento().getMonth(),
					usuario.getfNacimiento().getDate()));
			st.setString(4, usuario.getMail());
			st.setString(5, usuario.getNickname());
			st.setBoolean(6, admin);
			st.setString(7, usuario.getNif());
			st.setString(8, usuario.getPhone());
			st.setString(9, password);
			st.setString(10, usuario.getDir1());
			st.setString(11, usuario.getDir2());
			st.setString(12, usuario.getCiudad());
			st.setString(13, usuario.getC_postal());
			st.setString(14, usuario.getPais());
			actualizados = st.executeUpdate();
			st.close();
			//con.close();
		} catch (SQLException e) {
			System.out.println("Error al actualizar datos enla BDs: " + e.getMessage());		}
		return actualizados;
	}
	
	public int actualizaUsuarioNoPass(Usuario usuario, Boolean admin) {
		int actualizados = -1;
		Connection con = new Conexion().getConexion();
		String ordenSQL = "update Usuario set nombre=?,apellidos=?, f_nacimiento=?, mail=?, nickname=?, admin=?, nif=?, telefono=?, direccion1 =?, direcccion2=?, ciudad=?, c_postal =?, pais=? where c_usuario=" + usuario.getId();
		try {
			PreparedStatement st = con.prepareStatement(ordenSQL);
			st.setString(1, usuario.getNombre());
			st.setString(2, usuario.getApellidos());
			st.setDate(3, new java.sql.Date(usuario.getfNacimiento().getYear(), usuario.getfNacimiento().getMonth(),
					usuario.getfNacimiento().getDate()));
			st.setString(4, usuario.getMail());
			st.setString(5, usuario.getNickname());
			st.setBoolean(6, admin);
			st.setString(7, usuario.getNif());
			st.setString(8, usuario.getPhone());
			st.setString(9, usuario.getDir1());
			st.setString(10, usuario.getDir2());
			st.setString(11, usuario.getCiudad());
			st.setString(12, usuario.getC_postal());
			st.setString(13, usuario.getPais());
			actualizados = st.executeUpdate();
			st.close();
			//con.close();
		} catch (SQLException e) {
			System.out.println("Error al actualizar datos enla BDs: " + e.getMessage());		}
		return actualizados;
	}


}