package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.EntityCliente;
//import exception.DBConnectionException;
//import exception.DAOException;

public class ClienteDAO {
	
	public static EntityCliente readCliente(int idCliente){
		
		EntityCliente ec = null;
		Connection conn = null;
		
		try {
			conn = DBManager.get_connection();
			
			String query = "SELECT * FROM CLIENTE WHERE IDCLIENTE=?;";
		
			PreparedStatement stmt = conn.prepareStatement(query);
				
			stmt.setInt(1, idCliente);
				
			ResultSet result = stmt.executeQuery();
				
			if(result.next()) {
					ec = new EntityCliente(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5), result.getLong(6), result.getString(7));
			}		
		}catch(SQLException e) {
				e.printStackTrace();
		}finally {
			DBManager.close_connection(conn);
			try {
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ec;
			
	}
}