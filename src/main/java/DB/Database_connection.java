package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database_connection {
	private static final String URL = "jdbc:mysql://localhost:3307/world"
			+ "?useSSL=false"
			+ "&allowPublicKeyRetrieval=true"
			+ "&ServerTimeZone=Europe/Riga"
			+ "&characterEncoding=utf8"
			+ "&useUnicode=true";

	private static final String USER = "root";
	private static final String PASSWORD = "Parole1";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
