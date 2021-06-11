package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
//	private static String URL="jdbc:mysql://bbdd.fitargos.es/ddb170696"; // He llevado la base de datos a un hosting que tengo por ahi para unificar la BBDD
	private static String URL="jdbc:mysql://localhost/topbet"; // He llevado la base de datos a un hosting que tengo por ahi para unificar la BBDD
	private Connection connection = null;

	
	public Conexion(){
		
		try {
			 Class.forName("com.mysql.jdbc.Driver");
//			this.connection = DriverManager.getConnection(URL,"ddb170696","T0pB37Un1");
			this.connection = DriverManager.getConnection(URL,"root","");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentra el driver");
		} catch (SQLException e) {
			System.out.println("Error estableciendo conexion" + e.getMessage());
		}
	}
	
	
	public Connection getConexion(){
		return connection;
	}
}
