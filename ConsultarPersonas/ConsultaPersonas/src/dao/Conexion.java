package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	protected Connection conexion;
	
	// private String URL = "jdbc:mysql://localhost:3306/personas?autoRecinnet=true&useSSL=false";
	// private String user = "root";
	// private String password = "my*st147086*SQL";
	private String URL;
	private String user;
	private String password;
	
	public Conexion() {
		
	}
	
	public void conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection(URL, user, password);
			// JOptionPane.showMessageDialog(null, "Base de datos conectada correctamente.");
		} catch(Exception ex) {
			System.err.println("Error al conectar la base de datos, " + ex);
			JOptionPane.showMessageDialog(null, "Error al conectar la base de datos.");
		}
		
	}
	
	public void cerrar() throws SQLException {
		if(conexion != null) {
			if(!conexion.isClosed()) {
				conexion.close();
			}
		}
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
