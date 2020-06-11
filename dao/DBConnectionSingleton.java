package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSingleton {
	// MYSQL_CONNECTION_PARAMETERS
	private final static String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private final static String USER = "root";
	private final static String PASSWORD = "root";
	private final static String SCHEMA_NAME = "studentilaurea";
	private final static String PROPERTY = "?useLegacyDatetimeCode=false&useSSL=false&serverTimezone=Europe/Amsterdam";
	private final static String URL = "jdbc:mysql://localhost:3306/" + SCHEMA_NAME + PROPERTY;

	private static Connection connection;
	private static DBConnectionSingleton istance;

	public static DBConnectionSingleton getIstance() {

		if (istance == null) {
			istance = new DBConnectionSingleton();
		}

		return istance;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		// PASSO 0: caricamento driver
		Class.forName(DB_DRIVER_CLASS);
		// PASSO 1: creo la connessione
		Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		// System.out.println("Connessione avviata\n");

		return connection;
	}
}
