package dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBConnection {

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Properties props = new Properties();

            InputStream input = DBConnection.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return null;
            }

            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.username");
            String pass = props.getProperty("db.password");

            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, pass);

            System.out.println("Database connected successfully");

        } catch (Exception e) {
            System.out.println("DB Connection Error: " + e.getMessage());
        }

        return conn;
    }
}
