package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.Controlador;


public class Botones_Eleccion implements ActionListener {
	
   private Controlador controlador;
	
	public Botones_Eleccion() {	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButtonConIndice btn=(JButtonConIndice) e.getSource();
		BTNNumElegido MatrizNums= new BTNNumElegido((int)btn.getLocationOnScreen().getX(),(int)btn.getLocationOnScreen().getY());
		MatrizNums.setVisible(true);		
		int valor=MatrizNums.getNumElegido();
		if(valor!=0) 
		{
			btn.setText(Integer.toString(valor));		
			controlador.ActualizarValor(btn.getFila(),btn.getColumna(), valor);
			controlador.Ganador();
		}
		
    }




	
	
	
	
	
	
}