package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import conexion.Conexion;
import model.Apuesta;
import model.Competicion;
import model.Deporte;
import model.Equipo;
import model.Evento;
import model.EventoEquipos;
import model.Jornada;

public class DAOEvento {
	private static DAOEvento daoe = null;
	
	private DAOEvento() {
		
	}
	
	public static DAOEvento getDAOEvento() {
		if (daoe == null)
			daoe = new DAOEvento();
		return daoe;
	}
	
	// select
	public List<Evento> listado(int jornada, int competicionId) {
		ResultSet rs;
		List<Evento> lista = new ArrayList<>();

// Acceso a base de datos MySQL
		Connection con = new Conexion().getConexion();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * from Evento where jornada = " + jornada + " and c_competicion = " + competicionId;
			rs = st.executeQuery(ordenSql);
			DAOApuesta daoa = DAOApuesta.getDAOApuesta();
			DAOEquipo daoeq = DAOEquipo.getDAOE();
			DAOCompeticion daoc = DAOCompeticion.getDAOC();
			while (rs.next()) {
				int id = rs.getInt("c_evento");
				String desc = rs.getString("nombre");
				Date fecha = rs.getDate("fecha");
				List<Apuesta> apuestas = daoa.listado(id);
				List<Equipo> equipos = daoeq.listadoEquipos(competicionId);
				Competicion competicion = daoc.getCompeticion(competicionId);
				lista.add(new Evento(id, jornada ,apuestas, desc, fecha, competicion, equipos));
//				lista.add(objeto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out
					.println("Error al acceder a la BDs: " + e.getMessage() + " al obtener la lista de eventos");
		}
		return lista;
	}
	
	// select
	public EventoEquipos getResuladoPartido(int id) {
		ResultSet rs, rs1;
		EventoEquipos evento = null;

// Acceso a base de datos MySQL
		Connection con = new Conexion().getConexion();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "select e.*, plocal.c_equipo eqLocal, plocal.puntos_favor golesLocal, plocal.local local, pvisitante.c_equipo eqVisitante, pvisitante.puntos_favor golesVisitante, pvisitante.local visitante from Evento e, participa plocal, participa pvisitante where e.c_evento = " + id + " and e.c_evento = plocal.c_evento and plocal.local = true and pvisitante.c_evento = e.c_evento and pvisitante.local = false";
//			String ordenSQL2 = "select e.*, p.c_equipo, p.puntos_favor, p.local from Evento e, participa p where e.c_evento = " + id + " and e.c_evento = p.c_evento and p.local = false";
			rs = st.executeQuery(ordenSql);
//			rs1 = st.executeQuery(ordenSQL2);
			DAOApuesta daoa = DAOApuesta.getDAOApuesta();
			DAOEquipo daoeq = DAOEquipo.getDAOE();
			DAOCompeticion daoc = DAOCompeticion.getDAOC();
			if (rs.next()) {
//				int id = rs.getInt("c_evento");
				String desc = rs.getString("nombre");
				Date fecha = rs.getDate("fecha");
				int jornada = rs.getInt("jornada");
				int competicionId = rs.getInt("c_competicion");
				int idLocal = rs.getInt("eqLocal"), idVisitante = rs.getInt("eqVisitante");
				int puntosLocal = rs.getInt("golesLocal"), puntosVisitante = rs.getInt("golesVisitante");
				List<Apuesta> apuestas = daoa.listado(id);
				List<Equipo> equipos = new ArrayList<>();
				equipos.add(daoeq.equipo(idLocal));
				equipos.add(daoeq.equipo(idVisitante));
				
				Competicion competicion = daoc.getCompeticion(competicionId);
				
				evento = new EventoEquipos(id, jornada, apuestas, desc, fecha, competicion, equipos, puntosLocal, puntosVisitante);
//				lista.add(objeto);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out
					.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return evento;
	}
	
	

}
