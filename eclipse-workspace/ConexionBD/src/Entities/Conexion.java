package Entities;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	Connection con = null;

	public Connection conectar() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "Laura0423*");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean cerrar(Connection conn){
		try {
			conn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
