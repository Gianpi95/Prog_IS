package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.EntityPanino;

public class PaninoDAO {
	
	public static EntityPanino getPanino(String nome) {
	
		EntityPanino ep = null;
		Connection conn = null;
		
		try {
			
			conn = DBManager.get_connection();
		
			String query = "SELECT * FROM PANINO WHERE NOME=?;";
		
			PreparedStatement stmt = conn.prepareStatement(query);
		
			stmt.setString(1, nome);
			
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				ep = new EntityPanino(result.getInt(1), nome, result.getString(3), result.getFloat(4),result.getInt(5));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close_connection(conn);
		}
		
		return ep;
	
	}

}