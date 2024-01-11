package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.EntityPanineria;

public class PanineriaDAO {

	public static EntityPanineria getPanineria(String nome) {
		
		Connection conn = null;
		EntityPanineria ep = null;
		
		try {
			
			
			conn = DBManager.get_connection();
			
			String query = "SELECT * FROM PANINERIA WHERE NOME=?;";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setString(1, nome);
			
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				ep = new EntityPanineria(result.getInt(1), nome, result.getString(3), result.getString(4), result.getInt(5), result.getInt(6), result.getLong(7), result.getString(8) );
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBManager.close_connection(conn);
		}
		
		return ep;
		
	}
	
}