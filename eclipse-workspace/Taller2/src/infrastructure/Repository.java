package infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;

public class Repository {
	Connection connection = null;

	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "Ab.1031161766.1");
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean closeConnection(Connection conn){
		try {
			conn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
