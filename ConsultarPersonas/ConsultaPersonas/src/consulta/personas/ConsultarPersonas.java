package consulta.personas;

import controlador.PersonasController;
import dao.DAOPersonaImpl;
import vista.*;

public class ConsultarPersonas {
	
	public static void main(String[] args) {
		ConsultarPersonas main = new ConsultarPersonas();
		
		Ventana ventanaPrincipal = new Ventana();
		DAOPersonaImpl daoPersonaImpl = new DAOPersonaImpl();
		PersonasController personasController = new PersonasController(ventanaPrincipal, daoPersonaImpl);
		personasController.iniciar();
	}
}
