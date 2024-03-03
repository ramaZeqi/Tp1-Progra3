package MVCprincipal;

import controlador.Controlador;
import modelo.LogicaJuego;
import vista.GUIJuego;

public class Principal {

	public static void main(String []args) {
		
		GUIJuego vista=new GUIJuego();
		LogicaJuego modelo=new LogicaJuego();
		Controlador controlador=new Controlador(vista,modelo);
		vista.setControlador(controlador);
		vista.creaGUI();
	}
}
