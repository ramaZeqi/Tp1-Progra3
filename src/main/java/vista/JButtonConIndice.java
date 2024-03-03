package vista;

import javax.swing.JButton;

public class JButtonConIndice extends JButton{
	
	
		private int fila;
	    private int columna;
	    public JButtonConIndice(int fila, int columna){
	        this.fila = fila;
	        this.columna = columna;
	    }
	    public int getFila(){
	        return fila;
	    }
	    public int getColumna(){
	        return columna;
	    }
	 
	
}
