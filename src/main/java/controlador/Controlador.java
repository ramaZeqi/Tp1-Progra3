package controlador;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.LogicaJuego;
import vista.BTNNumElegido;
import vista.GUIJuego;
import vista.JButtonConIndice;



public class Controlador implements ActionListener{
	
	private GUIJuego vista;
	private LogicaJuego modelo;

	public Controlador(GUIJuego view,LogicaJuego model) {
		this.vista=view;
		this.modelo=model;
	}
	
	public GUIJuego getVista() {
		return vista;
	}

	public LogicaJuego getModelo() {
		return modelo;
	}
	public void AsignarValores() {
		getModelo().generarValorReferecia();
		getVista().setFil_valor(getModelo().getValor_fil());
		getVista().setCol_valor(getModelo().getValor_col());
	}

	public void ActualizarValor(int fila,int columna,int valor) {
		
		getModelo().getMatrizJuego().IngresarValor(fila, columna, valor);
		
	}

	public void ActualizarFilCol(int filas,int columnas) {
		getModelo().setFilasyColumnas(filas, columnas);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			int columnas= Integer.parseInt(getVista().getInputCol().getText());
			int filas= Integer.parseInt(getVista().getInputFil().getText());
			try {
				//limpia los panales para luego iniciar los commponentes en el
				getVista().clearPanels(); //necesario para redimensionar a partir del segundo inicio del juego
				ActualizarFilCol(filas, columnas);
				getVista().Inicia_Labels_Col_Fil(filas,columnas,getVista().getPnlFilas(),getVista().getPnlColumnas());
				AsignarValores();
				getVista().IniciarButtonsEvento(getVista().getBotonera(),filas,columnas);
				//----Timer------
				getVista().getTiempo().start();
				//-------------
				//clean inputs
				getVista().setInputCol("");
				getVista().setInputFil("");
				
				
			}
			catch(IllegalArgumentException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,"Los casilleros de filas y columnas pueden tomar valores de entre 4 a 8" );
		}
			
		}

	
	public void Ganador()
	{
		if(modelo.Ganador()) {
			modelo.clearValor_Col_Fil();
			vista.updateVista();
		}
	}
		
}
	


