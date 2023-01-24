package interfaces;

import javax.swing.table.DefaultTableModel;

import modelo.Persona;

public interface DAOPersona {
	public void agregar(Persona persona) throws Exception;
	public void mostrar(DefaultTableModel modelo) throws Exception;
	public Persona buscar(String[] datos) throws Exception;
	public void modificar(Persona persona) throws Exception;
	public void eliminar(Persona persona) throws Exception;
}
