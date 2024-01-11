package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entity.EntityAggiungiPanino;

public class AggiungiPaninoDAO {
	
	public static EntityAggiungiPanino readAggiungiPanino(String nome) {
		
		Connection conn = null;
		EntityAggiungiPanino eap = null;
		
		try {
			
			conn = DBManager.get_connection();
			
			String query = "SELECT * FROM AGGIUNGIPANINO WHERE CODPANINO = (" + "SELECT IDPANINO FROM PANINO WHERE NOME=?);";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setString(1, nome);
			
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				eap= new EntityAggiungiPanino(result.getInt(1),result.getInt(2), result.getInt(3), result.getInt(4));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close_connection(conn);
		}
		
		return eap;
		
	}
	
	public static void insertAggiungiPanino(EntityAggiungiPanino eap) {
		
		Connection conn= null;
		
		try {
		conn = DBManager.get_connection();
		
		String query = "INSERT INTO AGGIUNGIPANINO VALUES (?,?,?,?);";
		
		PreparedStatement stmt = conn.prepareStatement(query);
	
		stmt.setInt(1, eap.getId());
		stmt.setInt(2,eap.getQuantità());
		stmt.setInt(3, eap.getCodPanino());
		stmt.setInt(4, eap.getCodOrdine());
		
		stmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close_connection(conn);
		}
	
	}
		
	public static EntityAggiungiPanino readId(int id) {
			
		Connection conn = null;
		EntityAggiungiPanino eap = null;
			
		try {
				
			conn = DBManager.get_connection();
				
			String query = "SELECT * FROM AGGIUNGIPANINO WHERE ID=?;";
				
			PreparedStatement stmt = conn.prepareStatement(query);
				
			stmt.setInt(1, id);
				
			ResultSet result = stmt.executeQuery();
				
			if(result.next()) {
				eap= new EntityAggiungiPanino(result.getInt(1),result.getInt(2), result.getInt(3), result.getInt(4));
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBManager.close_connection(conn);
			}
			
		return eap;
			
	}

}