package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static String url = "jdbc:mysql://localhost:3306/wallet";
    private static String usuario = "root";
    private static String pass = "";


	public static Connection establecerConexion() {
	       try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            return DriverManager.getConnection(url, usuario, pass);
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	}
}
