package mx.edu.iems.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EscolarConnectionFactory {
	// Los atributos se declaran estaticos para que se puedan llamar de los métodos estáticos.

	private String JDBC_DRIVER;
	private String JDBC_URL_ESCOLAR;
	private String JDBC_USER;
	private String JDBC_PASS;
	private Connection conn;
	private ResourceBundle bundle;
	private static EscolarConnectionFactory escolarConnectionFactory;

	// Iniciamos los atributos de la clase
	private EscolarConnectionFactory() {
		
		// Leemos el archivo de configuracion llamado config.properties
		bundle = ResourceBundle.getBundle("config");
		
		// Leemos los valores del archivo de configuracion y lo asignamos
		JDBC_DRIVER = bundle.getString("driver");
		JDBC_URL_ESCOLAR = bundle.getString("url_base_escolar");
		JDBC_USER = bundle.getString("user");
		JDBC_PASS = bundle.getString("pass");

		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Connection getConnection() throws SQLException{
		conn = DriverManager.getConnection(JDBC_URL_ESCOLAR, JDBC_USER, JDBC_PASS);

		return conn;
	}

	public static EscolarConnectionFactory getInstance(){
		if (escolarConnectionFactory == null){
			escolarConnectionFactory = new EscolarConnectionFactory();
		}
		
		return escolarConnectionFactory;
	}
	
}