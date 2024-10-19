package Entities;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Conexion {

	public void conectar()
	{
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "Laura0423*");
			System.out.println("Successfully Conected");
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from prog2.personas");
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id_persona"));
				System.out.println("Nombre: " + rs.getString("nombre"));
				System.out.println("Apellido: " + rs.getString("apellido"));
				System.out.println("Cedula: "+ rs.getInt("cedula"));
				System.out.println("Edad: " + rs.getInt("edad"));
				System.out.println("Fecha Nacimiento: " + rs.getString("fecha_nacimiento"));
				System.out.println("Nit Biologico:" + rs.getInt("nit_biologico"));
				System.out.println("---------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
