package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import model.Competicion;
import model.Deporte;
import model.Deportista;
import model.Equipo;

public class DAOEquipo {
	
	private static DAOEquipo daoe = null;
	
	private DAOEquipo() {
		
	}
	
	public static DAOEquipo getDAOE() {
		if (daoe == null)
			daoe = new DAOEquipo();
		return daoe;
	}
	
	public List<Equipo> listadoEquipos(int competicion) {
		ResultSet rs;
		List<Equipo> lista = new ArrayList<>();

		Connection con = new Conexion().getConexion();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT e.*, c.puntuacion_total FROM Equipo e, compite c where e.c_equipo in (select c_equipo from compite where c_competicion = " + competicion + ") and e.c_equipo = c.c_equipo order by puntuacion_total desc";
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				int id = rs.getInt("c_equipo");
				String nombre = rs.getString("nombre");
				String sede = rs.getString("sede");
				String presidente = rs.getString("presidente");
				String escudo = rs.getString("escudo");
				String mister = rs.getString("entrenador");
				String pais = rs.getString("pais");
				int puntuacion = rs.getInt("puntuacion_total");
				Equipo equipo = new Equipo(id, puntuacion, nombre, sede, pais, escudo, false);
				lista.add(equipo);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return lista;
	}
	
	public List<Equipo> listadoEquipos(Deportista deportista) {
		ResultSet rs;
		List<Equipo> lista = new ArrayList<>();

		Connection con = new Conexion().getConexion();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * FROM Equipo where c_equipo in (select c_equipo from tiene where c_jugador = " + deportista.getId() +")";	
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				int id = rs.getInt("c_equipo");
				String nombre = rs.getString("nombre");
				String sede = rs.getString("sede");
				String presidente = rs.getString("presidente");
				String escudo = rs.getString("escudo");
				String mister = rs.getString("entrenador");
				String pais = rs.getString("pais");
				Equipo equipo = new Equipo(id, nombre, sede, pais, escudo, false);
				System.out.println(equipo);
				lista.add(equipo);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return lista;
	}
	public Equipo equipo(int id) {
		ResultSet rs;
//		List<Equipo> lista = new ArrayList<>();
		Equipo equipo = null;
		Connection con = new Conexion().getConexion();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * FROM Equipo where c_equipo =" + id;
			rs = st.executeQuery(ordenSql);

			if (rs.next()) {
				String nombre = rs.getString("nombre");
				String sede = rs.getString("sede");
				String presidente = rs.getString("presidente");
				String escudo = rs.getString("escudo");
				String mister = rs.getString("entrenador");
				String pais = rs.getString("pais");
				equipo = new Equipo(id, nombre, sede, pais, escudo, false);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return equipo;
	}
}
