package klaseak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa {
	
	private static Connection conn;
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static final String URL = "jdbc:mysql://localhost:3306/TBASATIA";
	
	public Konexioa() {
		conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Errorea konektatzean" + e);
		}
	}
	
	//Metodo hau konexioa itzultzen du
	public Connection getConnection() {
		return conn;
	}
	
	//Metodo honen bidez base datutik deskonektatzen gara
	public void deskonektatu() {
		conn = null;
	}

}
