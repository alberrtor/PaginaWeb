package mx.edu.iems.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PaginaWebConnectionFactory {
	
	private String JDBC_DRIVER;
	private String JDBC_URL_PAGINAWEB;
	private String JDBC_USER;
	private String JDBC_PASS;
	private Connection conn;
	private ResourceBundle bundle;
	private static PaginaWebConnectionFactory paginawebConnectionFactory;

	// Iniciamos los atributos de la clase
	private PaginaWebConnectionFactory() {
		
		// Leemos el archivo de configuracion llamado config.properties
		bundle = ResourceBundle.getBundle("config");
		
		// Leemos los valores del archivo de configuracion y lo asignamos
		JDBC_DRIVER = bundle.getString("driver");
		JDBC_URL_PAGINAWEB = bundle.getString("url_base_paginaweb");
		JDBC_USER = bundle.getString("user");
		JDBC_PASS = bundle.getString("pass");

		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Connection getConnection() throws SQLException{
		conn = DriverManager.getConnection(JDBC_URL_PAGINAWEB, JDBC_USER, JDBC_PASS);

		return conn;
	}

	public static PaginaWebConnectionFactory getInstance(){
		if (paginawebConnectionFactory == null){
			paginawebConnectionFactory = new PaginaWebConnectionFactory();
		}
		
		return paginawebConnectionFactory;
	}
	
}