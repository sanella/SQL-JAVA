import java.sql.*;

public class CreateTable {

	public static void main(String[] args) {

		Connection db = null;
		db = createConnection("bitbase.db");

		if (db == null) {
			System.err.println("Not connected");
			System.exit(1);
		}
		String sql = "create table if not exists users("
				+ "id integer primary key autoincrement,"
				+ "username varchar(20) not null ,"
				+ "password varchar(40) not null"
				+ ");";

		try {
			//napravi statement gdje cemo ubaciti nas sql
			//mozemo koristiti nekad i prepaerd.statement
			Statement stmt = db.createStatement();
			stmt.execute(sql);
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
