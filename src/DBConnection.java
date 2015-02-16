import java.sql.*;

public class DBConnection {

	public static void main(String[] args) {
		
		Connection c = null;
		try {
			// napravit cemo bazi o konekciju na tu bazu
			c = DriverManager.getConnection("jdbc:sqlite:bitbase.db");
			System.out.println("Connected");
		} catch (SQLException e) {
		System.err.println(e.getMessage());
		}
	}
	
}
