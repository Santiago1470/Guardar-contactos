package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

public class Ventana extends JFrame {
	private int ancho = 600;
	private int largo = 500;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JPanel panel;
	private JLabel labelTitulo;
	private JTable table;
	private JScrollPane verTabla;
	private InternalFrame internalFrame;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, ancho, largo);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 584, 462);
		contentPane.add(desktopPane);
		
		internalFrame = new InternalFrame();
		internalFrame.setVisible(false);;
		desktopPane.add(internalFrame);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 584, 463);
		desktopPane.add(panel);
		
		labelTitulo = new JLabel("Personas registradas:");
		labelTitulo.setBounds(10, 11, 130, 14);
		panel.add(labelTitulo);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Edad", "Identificacion", "Correo", "Telefono"
			}
		));
		table.setEnabled(false);
		//table.setBounds(10, 40, 564, 350);
		//panel.add(table);
		
		verTabla = new JScrollPane(table);
		verTabla.setVisible(true);
		verTabla.setBounds(10, 40, 564, 370);
		panel.add(verTabla, BorderLayout.CENTER);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(135, 421, 95, 23);
		btnAgregar.setFocusable(false);
		panel.add(btnAgregar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(238, 421, 110, 23);
		btnModificar.setFocusable(false);
		panel.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(355, 421, 95, 23);
		btnEliminar.setFocusable(false);
		panel.add(btnEliminar);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}


	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}


	public JButton getBtnModificar() {
		return btnModificar;
	}


	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}


	public JButton getBtnEliminar() {
		return btnEliminar;
	}


	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}


	public InternalFrame getInternalFrame() {
		return internalFrame;
	}


	public void setInternalFrame(InternalFrame internalFrame) {
		this.internalFrame = internalFrame;
	}
	
}
