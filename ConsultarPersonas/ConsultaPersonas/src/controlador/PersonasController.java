package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.Conexion;
import dao.DAOPersonaImpl;
import modelo.Persona;
import vista.*;

public class PersonasController implements ActionListener {
	private Ventana vista;
	private DAOPersonaImpl daoPersonaImpl;
	private Persona persona;
	// private Conexion conexion;
	
	public PersonasController(Ventana vista, DAOPersonaImpl daoPersonaImpl) {
		this.vista = vista;
		this.daoPersonaImpl = daoPersonaImpl;
		vista.getBtnAgregar().addActionListener(this);
		vista.getBtnModificar().addActionListener(this);
		vista.getBtnEliminar().addActionListener(this);
		
		vista.getInternalFrame().getBtnCRUD().addActionListener(this);
		vista.getInternalFrame().getBtnCancelarUD().addActionListener(this);
		vista.getInternalFrame().getBtnBuscar().addActionListener(this);
	}
	
	public void iniciar() {
		vista.setVisible(true);
		String URL = JOptionPane.showInputDialog(null, "Ingrese por favor la URL de la base de datos:");
		String user = JOptionPane.showInputDialog(null, "Ingrese por favor el usuario de la base de datos:");
		String password = JOptionPane.showInputDialog(null, "Ingrese por favor la contraseña del usuario de la base de datos:");
		
		this.daoPersonaImpl.setURL(URL);
		this.daoPersonaImpl.setUser(user);
		this.daoPersonaImpl.setPassword(password);
		
		
	    try {
	    	daoPersonaImpl.conectar();
	    	mostrarPersonas();
	    	//JOptionPane.showMessageDialog(null, "Base de datos conectada correctamente.");
	    	daoPersonaImpl.cerrar();
		} catch (Exception ex) {
			ex.printStackTrace();
			// JOptionPane.showMessageDialog(null, "Error al conectar la base de datos.\nReinicie el programa, por favor.");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vista.getBtnAgregar()) {
			vista.getInternalFrame().setVisible(true);
			vista.getInternalFrame().mostrarPanel(1);
			limpiarCampos();
			mostrarPersonas();
		} else if(e.getSource() == vista.getBtnModificar()) {
			vista.getInternalFrame().setVisible(true);
			vista.getInternalFrame().mostrarPanel(2);
			limpiarCampos();
			mostrarPersonas();
		} else if(e.getSource() == vista.getBtnEliminar()) {
			vista.getInternalFrame().setVisible(true);
			vista.getInternalFrame().mostrarPanel(3);
			limpiarCampos();
			mostrarPersonas();
		}
		
		if(e.getSource() == vista.getInternalFrame().getBtnCancelarUD()) {
			limpiarCampos();
			mostrarPersonas();
			vista.getInternalFrame().setVisible(false);
		}
		
		if(e.getSource() == vista.getInternalFrame().getBtnCRUD()) {
			if(vista.getInternalFrame().isFlagAgregar()) {
				agregarPersona();
				mostrarPersonas();
			} else if(vista.getInternalFrame().isFlagModificar()) {
				modificarPersona();
				mostrarPersonas();
			} else if(vista.getInternalFrame().isFlagEliminar()) {
				eliminarPersonas();
				mostrarPersonas();
			}
		} else if(e.getSource() == vista.getInternalFrame().getBtnBuscar()) {
			buscarPersona();
		}
	}
	
	private void agregarPersona() {
		String nombre = vista.getInternalFrame().getTextFieldNombreUD().getText();
		byte edad = Byte.parseByte(vista.getInternalFrame().getTextFieldEdadUD().getText());
		long identificacion = Long.parseLong(vista.getInternalFrame().getTextFieldIdUD().getText());
		String correo = vista.getInternalFrame().getTextFieldCorreoUD().getText();
		long telefono = Long.parseLong(vista.getInternalFrame().getTextFieldTelUD().getText());
		
		persona = new Persona(0, nombre, edad, identificacion, correo, telefono);
		
		try {
			daoPersonaImpl.agregar(persona);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		vista.getInternalFrame().setVisible(false);
		limpiarCampos();
	}
	
	private void modificarPersona() {
		try {
			String nombre = vista.getInternalFrame().getTextFieldNombreUD().getText();
			byte edad = Byte.parseByte(vista.getInternalFrame().getTextFieldEdadUD().getText());
			long identificacion = Long.parseLong(vista.getInternalFrame().getTextFieldIdUD().getText());
			String correo = vista.getInternalFrame().getTextFieldCorreoUD().getText();
			long telefono = Long.parseLong(vista.getInternalFrame().getTextFieldTelUD().getText());
			
			persona = new Persona(persona.getId(), nombre, edad, identificacion, correo, telefono);
			daoPersonaImpl.modificar(persona);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		vista.getInternalFrame().setVisible(false);
		limpiarCampos();
	}
	
	private void buscarPersona() {
		boolean existe = false;
		boolean opcionValida = false;
		String[] datos = new String[2];
		
		int item = vista.getInternalFrame().getCmbOpcionBuscar().getSelectedIndex();
		
		if(item != 0) {
			opcionValida = true;
		}
		
		
		if(opcionValida) {
			datos[0] = vista.getInternalFrame().getCmbOpcionBuscar().getItemAt(item);
			datos[1] = vista.getInternalFrame().getTextFieldBuscar().getText();
			
			try {
				persona = daoPersonaImpl.buscar(datos);
				if(persona == null) {
					JOptionPane.showMessageDialog(null, "La persona consultada con "
							+ datos[0] + ": " + datos[1] + " no existe.");
					limpiarCampos();
					existe = false;
				} else {
					existe = true;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		if(existe) {
			vista.getInternalFrame().getTextFieldNombreUD().setText(persona.getNombre());
			vista.getInternalFrame().getTextFieldEdadUD().setText(String.valueOf(persona.getEdad()));
			vista.getInternalFrame().getTextFieldIdUD().setText(String.valueOf(persona.getIdentificacion()));
			vista.getInternalFrame().getTextFieldCorreoUD().setText(persona.getCorreo());
			vista.getInternalFrame().getTextFieldTelUD().setText(String.valueOf(persona.getTelefono()));
		}
		
		if(!opcionValida) {
			JOptionPane.showMessageDialog(null, "Seleccione una opción válida para buscar.");
			limpiarCampos();
		}
	}
	
	private void eliminarPersonas() {
		try {
			daoPersonaImpl.eliminar(persona);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		vista.getInternalFrame().setVisible(false);
		limpiarCampos();
	}
	
	private void mostrarPersonas() {
		try {
			daoPersonaImpl.mostrar((DefaultTableModel) vista.getTable().getModel());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void limpiarCampos() {
		DefaultTableModel modelo = (DefaultTableModel) vista.getTable().getModel();
		for(int i = 0; i < vista.getTable().getRowCount(); i++) {
			modelo.removeRow(i);
			i -= 1;
		}
		
		vista.getInternalFrame().getTextFieldNombreUD().setText("");
		vista.getInternalFrame().getTextFieldEdadUD().setText("");
		vista.getInternalFrame().getTextFieldIdUD().setText("");
		vista.getInternalFrame().getTextFieldCorreoUD().setText("");
		vista.getInternalFrame().getTextFieldTelUD().setText("");
		
		vista.getInternalFrame().getCmbOpcionBuscar().setSelectedIndex(0);;
		vista.getInternalFrame().getTextFieldBuscar().setText("");
	}
	
}
