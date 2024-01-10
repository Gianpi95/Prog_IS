package database;

import java.sql.*;

public class DBManager{
	
	private static final String DRIVER_URL = "org.h2.Driver";
	private static final String JDBC_URL = "jdbc:h2:~/gestionePaninerie";
	private static final String USER = "root";
	private static final String PASSWORD = "";
		
	public static Connection get_connection(){
		
		Connection conn = null;
		
		try{
			Class.forName(DRIVER_URL);
			conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			//System.out.println("Connesso al DB H2(" + conn + ").");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	public static void close_connection(Connection conn){

		try {
			if(conn != null) {
			conn.close();
			//System.out.println("Connessione " + conn + " chiusa con successo.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}