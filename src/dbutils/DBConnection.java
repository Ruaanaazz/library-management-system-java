package dbutils;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("connection ok");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String user = "apex4";
            String pass = "apex1234";
           conn = DriverManager.getConnection(url, user, pass);
           System.out.println("connection ok");
					
		}catch(Exception e) {
			System.out.println("error connection"+e);
		}

return conn;
	}

}
