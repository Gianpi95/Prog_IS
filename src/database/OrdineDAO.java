package database;

//import exception.DAOException;
//import exception.DBConnectionException;
import entity.EntityOrdine;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.*;

//import database.*;

public class OrdineDAO {
	
	public static EntityOrdine getOrdine(int idOrdine) {
		
		Connection conn = null;
		EntityOrdine eo = null;
		
		try {
			
			
			conn = DBManager.get_connection();
			
			String query = "SELECT * FROM ORDINE WHERE IDORDINE=?;";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, idOrdine);
			
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				eo = new EntityOrdine(result.getInt(1), result.getTime(2), result.getTime(3), result.getFloat(4), result.getInt(5), result.getInt(6));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBManager.close_connection(conn);
		}
		
		return eo;
	}
	
	public static void createOrdine(EntityOrdine eo){
		
		Connection conn= null;
		
		try {
		conn = DBManager.get_connection();
		
		String query = "INSERT INTO ORDINE VALUES (?,NULL,NULL,?,NULL,?);";
		
		PreparedStatement stmt = conn.prepareStatement(query);
	
		stmt.setInt(1, eo.getIdOrdine());
		stmt.setFloat(2,eo.getCostoTotale());
		stmt.setInt(3, eo.getCodCliente());
		
		stmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close_connection(conn);
		}
		
	}

}
