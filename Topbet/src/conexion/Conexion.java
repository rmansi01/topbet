package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static String URL="jdbc:mysql://bbdd.fitargos.es"; // He llevado la base de datos a un hosting que tengo por ahi para unificar la BBDD
	private Connection conexion = null;
	
	public Conexion(){
		
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			this.conexion = DriverManager.getConnection(URL,"ddb170696","T0pB37Un1");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentra el driver");
		} catch (SQLException e) {
			System.out.println("Error estableciendo conexion");
		}
	}
	public Connection getConexion(){
		return conexion;
	}
}
