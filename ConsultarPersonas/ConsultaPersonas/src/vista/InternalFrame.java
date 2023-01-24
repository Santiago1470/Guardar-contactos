package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InternalFrame extends JInternalFrame {
	private int ancho = 0;
	private int largo = 0;
	private boolean flagAgregar = false;
	private boolean flagModificar = false;
	private boolean flagEliminar = false;
	
	private JPanel panelUD, panelBuscar;
	private JSeparator separador;
	
	private JLabel lblNombreUD, lblEdadUD, lblIdUD, lblCorreoUD, lblTelUD;
	private JTextField textFieldNombreUD, textFieldEdadUD, textFieldIdUD,
			textFieldCorreoUD,textFieldTelUD;
	private JButton btnCRUD, btnCancelarUD;

	private JLabel lblBuscar;
	private JComboBox<String> cmbOpcionBuscar;
	private JTextField textFieldBuscar;
	private JButton btnBuscar;

	public InternalFrame() {
		this.setLayout(null);
		
		//separador = new JSeparator();
		//separador.setOrientation(SwingConstants.VERTICAL);
		//separador.setBounds(345, 0, 5, largo);
		//separador.setVisible(true);
		//this.add(separador);
		
		agregarPanelesCRUD();
		agregarPanelBuscar();
	}

	public void mostrarPanel(int opcion) {
		switch (opcion) {
			case 1:
				ancho = 415;
				largo = 240;
	
				panelUD.setBounds(0, 0, ancho, largo);
				panelUD.setVisible(true);
				btnCRUD.setText("AGREGAR");
				flagAgregar = true;
				flagModificar = false;
				flagEliminar = false;
				
				this.setTitle("Agregar persona");
	
				panelBuscar.setVisible(false);
				
				//panelUD.setVisible(false);
	
				break;
	
			case 2, 3:
				ancho = 520;
				largo = 250;
	
				panelUD.setBounds(0, 0, 340, largo);
				panelUD.setVisible(true);
	
				panelBuscar.setBounds(350, 0, (ancho - 350), largo);
				panelBuscar.setVisible(true);
	
				cambiarDatos(opcion);
	
				break;
		}

		this.setBounds(0, 0, ancho, largo);
	}
	
	// C = Create
	// R = Read
	// U = Update
	// D = Delete
	// Agregar paneles Crear(C), Leer(R), flagModificar(U) y flagEliminar(D)
	private void agregarPanelesCRUD() {
		panelUD = new JPanel();
		panelUD.setLayout(null);
		panelUD.setVisible(false);
		this.add(panelUD);

		lblNombreUD = new JLabel("Nombre:");
		lblNombreUD.setBounds(10, 12, 60, 14);
		panelUD.add(lblNombreUD);

		textFieldNombreUD = new JTextField();
		textFieldNombreUD.setBounds(96, 10, 230, 20);
		panelUD.add(textFieldNombreUD);
		textFieldNombreUD.setColumns(10);

		lblEdadUD = new JLabel("Edad:");
		lblEdadUD.setBounds(10, 39, 46, 14);
		panelUD.add(lblEdadUD);

		textFieldEdadUD = new JTextField();
		textFieldEdadUD.setBounds(96, 35, 90, 20);
		panelUD.add(textFieldEdadUD);
		textFieldEdadUD.setColumns(10);

		lblIdUD = new JLabel("Identificacion:");
		lblIdUD.setBounds(10, 63, 90, 14);
		panelUD.add(lblIdUD);

		textFieldIdUD = new JTextField();
		textFieldIdUD.setBounds(96, 60, 150, 20);
		panelUD.add(textFieldIdUD);
		textFieldIdUD.setColumns(10);

		lblCorreoUD = new JLabel("Correo:");
		lblCorreoUD.setBounds(10, 87, 60, 14);
		panelUD.add(lblCorreoUD);

		textFieldCorreoUD = new JTextField();
		textFieldCorreoUD.setBounds(96, 85, 230, 20);
		panelUD.add(textFieldCorreoUD);
		textFieldCorreoUD.setColumns(10);

		lblTelUD = new JLabel("Telefono:");
		lblTelUD.setBounds(10, 112, 60, 14);
		panelUD.add(lblTelUD);

		textFieldTelUD = new JTextField();
		textFieldTelUD.setBounds(96, 110, 150, 20);
		panelUD.add(textFieldTelUD);
		textFieldTelUD.setColumns(10);

		btnCRUD = new JButton();
		btnCRUD.setBounds(120, 160, 105, 25);
		btnCRUD.setFocusable(false);
		panelUD.add(btnCRUD);

		btnCancelarUD = new JButton("CANCELAR");
		btnCancelarUD.setBounds(230, 160, 100, 25);
		btnCancelarUD.setFocusable(false);
		panelUD.add(btnCancelarUD);

	}

	private void cambiarDatos(int opcion) {
		if (opcion == 2) {
			btnCRUD.setText("MODIFICAR");
			this.setTitle("Modificar persona");
			flagAgregar = false;
			flagModificar = true;
			flagEliminar = false;
		} else {
			btnCRUD.setText("ELIMINAR");
			this.setTitle("Eliminar persona");
			flagAgregar = false;
			flagModificar = false;
			flagEliminar = true;
		}
	}
	
	private void agregarPanelBuscar() {
		panelBuscar = new JPanel();
		panelBuscar.setLayout(null);
		panelBuscar.setVisible(false);
		this.add(panelBuscar);
		
		lblBuscar = new JLabel("Buscar por:");
		lblBuscar.setBounds(10, 30, 80, 15);
		panelBuscar.add(lblBuscar);
		
		String[] opciones = {"Seleccionar", "Identificacion", "Correo", "Telefono"};
		cmbOpcionBuscar = new JComboBox<String>(opciones);
		cmbOpcionBuscar.setBounds(10, 50, 110, 20);
		panelBuscar.add(cmbOpcionBuscar);
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.setBounds(10, 80, 130, 20);
		panelBuscar.add(textFieldBuscar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(10, 110, 90, 25);
		btnBuscar.setFocusable(false);
		panelBuscar.add(btnBuscar);
		
	}

	public boolean isFlagAgregar() {
		return flagAgregar;
	}

	public void setFlagAgregar(boolean flagAgregar) {
		this.flagAgregar = flagAgregar;
	}

	public boolean isFlagModificar() {
		return flagModificar;
	}

	public void setFlagModificar(boolean flagModificar) {
		this.flagModificar = flagModificar;
	}

	public boolean isFlagEliminar() {
		return flagEliminar;
	}

	public void setFlagEliminar(boolean flagEliminar) {
		this.flagEliminar = flagEliminar;
	}

	public JButton getBtnCRUD() {
		return btnCRUD;
	}

	public void setBtnCRUD(JButton btnCRUD) {
		this.btnCRUD = btnCRUD;
	}

	public JButton getBtnCancelarUD() {
		return btnCancelarUD;
	}

	public void setBtnCancelarUD(JButton btnCancelarUD) {
		this.btnCancelarUD = btnCancelarUD;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JTextField getTextFieldNombreUD() {
		return textFieldNombreUD;
	}

	public void setTextFieldNombreUD(JTextField textFieldNombreUD) {
		this.textFieldNombreUD = textFieldNombreUD;
	}

	public JTextField getTextFieldEdadUD() {
		return textFieldEdadUD;
	}

	public void setTextFieldEdadUD(JTextField textFieldEdadUD) {
		this.textFieldEdadUD = textFieldEdadUD;
	}

	public JTextField getTextFieldIdUD() {
		return textFieldIdUD;
	}

	public void setTextFieldIdUD(JTextField textFieldIdUD) {
		this.textFieldIdUD = textFieldIdUD;
	}

	public JTextField getTextFieldCorreoUD() {
		return textFieldCorreoUD;
	}

	public void setTextFieldCorreoUD(JTextField textFieldCorreoUD) {
		this.textFieldCorreoUD = textFieldCorreoUD;
	}

	public JTextField getTextFieldTelUD() {
		return textFieldTelUD;
	}

	public void setTextFieldTelUD(JTextField textFieldTelUD) {
		this.textFieldTelUD = textFieldTelUD;
	}	

	public JComboBox<String> getCmbOpcionBuscar() {
		return cmbOpcionBuscar;
	}

	public void setCmbOpcionBuscar(JComboBox<String> cmbOpcionBuscar) {
		this.cmbOpcionBuscar = cmbOpcionBuscar;
	}

	public JTextField getTextFieldBuscar() {
		return textFieldBuscar;
	}

	public void setTextFieldBuscar(JTextField textFieldBuscar) {
		this.textFieldBuscar = textFieldBuscar;
	}

}
