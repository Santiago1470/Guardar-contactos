package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import interfaces.DAOPersona;
import modelo.Persona;

public class DAOPersonaImpl extends Conexion implements DAOPersona {
	private String tabla = "lista_personas";
	@Override
	public void agregar(Persona persona) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("insert into " + tabla +"(nombre, edad, identificacion, correo, telefono) values (?, ?, ?, ?, ?)");
			
			st.setString(1, persona.getNombre());
			st.setByte(2, persona.getEdad());
			st.setLong(3, persona.getIdentificacion());
			st.setString(4, persona.getCorreo());
			st.setLong(5, persona.getTelefono());
			
			st.executeUpdate();
		} catch (Exception ex) {
			 System.err.println("Error al agregar persona, " + ex);
			 // JOptionPane.showMessageDialog(null, "Error al conectar la base de datos.");
		} finally {
			this.cerrar();
		}
		
	}

	@Override
	public void mostrar(DefaultTableModel modelo) throws Exception {
		Object[] lista = {"", 0, 0, "", 0};
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("select * from " + tabla);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				lista[0] = rs.getString("nombre");
				lista[1] = rs.getByte("edad");
				lista[2] = rs.getLong("identificacion");
				lista[3] = rs.getString("correo");
				lista[4] = rs.getLong("telefono");
				modelo.addRow(lista);
			}
			
		} catch (Exception ex) {
			System.err.println("Error al mostrar persona, " + ex);
		} finally {
			this.cerrar();
		}
	}
	
	@Override
	public Persona buscar(String[] datos) throws Exception {
		String nombreColumna = datos[0].toLowerCase();
		String datoFila = datos[1];
		
		Persona persona;
		
		int id = 0;
		String nombre = "";
		byte edad = 0;
		long identificacion = 0;
		String correo = "";
		long telefono = 0;
		
		try {
			this.conectar();
			
			PreparedStatement st = this.conexion.prepareStatement("select * from " + tabla
					+ " where " + nombreColumna + " = " + datoFila);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				id = rs.getInt("id");
				nombre = rs.getString("nombre");
				edad = rs.getByte("edad");
				identificacion = rs.getLong("identificacion");
				correo = rs.getString("correo");
				telefono = rs.getLong("telefono");
			}
			
		} catch (Exception ex) {
			System.err.println("Error al buscar persona, " + ex);
		} finally{
			this.cerrar();
		}
		if(identificacion != 0) {
			return persona = new Persona(id, nombre, edad, identificacion, correo, telefono);
		}
		return persona = null;
	}

	@Override
	public void modificar(Persona persona) throws Exception {
		try {
			this.conectar();
			
			PreparedStatement st = this.conexion.prepareStatement("update " + tabla
					+ " set nombre = ?, edad = ?, identificacion = ?, correo = ?, telefono = ?"
					+ " where id = ?");
			
			st.setString(1, persona.getNombre());
			st.setByte(2, persona.getEdad());
			st.setLong(3, persona.getIdentificacion());
			st.setString(4, persona.getCorreo());
			st.setLong(5, persona.getTelefono());
			st.setInt(6, persona.getId());
			
			st.executeUpdate();
			
		} catch (Exception ex) {
			System.err.println("Error al modificar persona, " + ex);
		} finally {
			this.cerrar();
		}
		
	}

	@Override
	public void eliminar(Persona persona) throws Exception {
		try {
			this.conectar();
			
			PreparedStatement st = this.conexion.prepareStatement("delete from " + tabla + " where id = ?");
			
			st.setInt(1, persona.getId());
			
			st.executeUpdate();
			
		} catch (Exception ex) {
			System.err.println("Error al eliminar persona, " + ex);
		} finally {
			this.cerrar();
		}
	}
	
}
