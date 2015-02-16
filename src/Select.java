import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Select {

	public static void main(String[] args) {
		Connection db = null;
		db = createConnection("bitbase.db");

		if (db == null) {
			System.err.println("Not connected");
			System.exit(1);
		}
		
		try {
			String sql  = "SELECT id, username as NICK, password  FROM users";
			Statement stmt = db.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next() ){
				int id;
				String username, password;
				id = rs.getInt("id");
				username = rs.getString("NICK");
				password = rs.getString("password");
				
				System.out.printf("User: %d, %s, %s\n", id, username, password);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Connection createConnection(String baseName) {
		try {
			return DriverManager.getConnection("jdbc:sqlite:" + baseName);
		} catch (SQLException e) {
			return null;
		}

	}
	
}
