package vista;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import controlador.Controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIJuego {

	private int sec;
	private JFrame frame;
	private Controlador controlador;
	private JLabel [] fil_valor;
	private JLabel [] col_valor;
	private Timer tiempo;
	private JLabel lbltiempo;
	private JTextField inputFil,inputCol;
	private JPanel botonera,pnlCrear,pnlFilas,pnlColumnas;
	
	public GUIJuego() {
		try
		{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) { 
			JOptionPane.showMessageDialog(null,e.getMessage());
		} 
	} 
	/* * Launch the application.
	 */
	public void creaGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI();
										
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }

//----------------SETTERS--------------------------------------------------------------------------------
	public JLabel getLbltiempo() {
		return lbltiempo;
	}
	public void setLbltiempo(JLabel lbltiempo) {
		this.lbltiempo = lbltiempo;
	}
	public JLabel[] getFil_valor() {
		return fil_valor;
	}
	
	 public void setFil_valor(int [] valor_fil) {
			for(int fila=0;fila<this.fil_valor.length;fila++) {
				this.fil_valor[fila].setText(Integer.toString(valor_fil[fila]));
			}
		}
	public JLabel[] getCol_valor() {
		return col_valor;
	}
	public void setCol_valor(int  [] valor_col) {
		for(int columna=0;columna<this.col_valor.length;columna++) {
			this.col_valor[columna].setText(Integer.toString(valor_col[columna]));
		}
	}
	public JTextField getInputFil() {
		return inputFil;
	}
	public void setInputFil(String inputFil) {
		this.inputFil.setText(inputFil);
	}
	public JTextField getInputCol() {
		return inputCol;
	}
	public void setInputCol(String inputCol) {
		this.inputCol.setText(inputCol);
	}
	public Timer getTiempo() {
		return tiempo;
	}
	public JPanel getBotonera() {
		return botonera;
	}
	public JPanel getPnlFilas() {
		return pnlFilas;
	}
	public JPanel getPnlColumnas() {
		return pnlColumnas;
	}
	public Controlador getControlador() {
		return controlador;
	}
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
//-------------------------------------------------------------------------------------------------------
//---------------------METODOS AUXILIARES----------------------------------------------------------------------------------
	public void Inicia_Labels_Col_Fil(int filas, int columnas,JPanel pnlfilas,JPanel pnlcolumnas) {
		col_valor=new JLabel [columnas];
		fil_valor=new JLabel [filas];
		for(int fila=0;fila<filas;fila++) {
			getFil_valor()[fila]=new JLabel();
			pnlfilas.add(fil_valor[fila]);
		}
		for(int columna=0;columna<columnas;columna++) {
			getCol_valor()[columna]=new JLabel();
			pnlcolumnas.add(col_valor[columna]);	
		}
	}

	public void IniciarButtonsEvento(JPanel buttons,int filas,int columnas) {
		Botones_Eleccion panel=new Botones_Eleccion();
		panel.setControlador(getControlador());
		buttons.setLayout(new GridLayout(filas,columnas, 0, 0));	
		JButtonConIndice btn[][]=new JButtonConIndice[filas][columnas];
		for(int fila=0;fila<filas;fila++) {
			for(int columna=0;columna<columnas;columna++) {
				btn[fila][columna]=new JButtonConIndice(fila,columna);
				btn[fila][columna].addActionListener(panel);		
				buttons.add(btn[fila][columna]);
			}
		}
	}
	private void EstadoPanelBontones(JPanel panel, Boolean isEnabled) {
	    panel.setEnabled(isEnabled);

	    Component[] components = panel.getComponents();

	    for (Component component : components) {
	        if (component instanceof JPanel) {
	        	EstadoPanelBontones((JPanel) component, isEnabled);
	        }
	        component.setEnabled(isEnabled);
	    }
	}
	//indica cuando acaba el juego (ganador) 
	public void updateVista() {
		tiempo.stop();
		EstadoPanelBontones(botonera,false);
		JOptionPane.showMessageDialog(null,"Ganaste\nTardaste "+this.lbltiempo.getText()+" segundos en resolver el juego");
	}
	//resetea a 0 los paneles de componentes
	public void clearPanels()
	{
		getLbltiempo().setText("0");
		sec=0;
		EstadoPanelBontones(botonera,true);
		botonera.removeAll();
		pnlFilas.removeAll();;
		pnlColumnas.removeAll();
	}
	/* Create the application.
	 */
//-------------------------------------------------------------------------------------------------------	
	private void GUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));   
		//------------------------------------------------------------------
		pnlCrear = new JPanel();
		frame.getContentPane().add(pnlCrear, BorderLayout.NORTH);
		
		pnlFilas = new JPanel();
		frame.getContentPane().add(pnlFilas, BorderLayout.EAST);
		pnlFilas.setLayout(new GridLayout(0,1, 0, 0));
		
		pnlColumnas = new JPanel();
		frame.getContentPane().add(pnlColumnas, BorderLayout.SOUTH);
		pnlColumnas.setLayout(new GridLayout(1,0, 0, 0));
		
		botonera = new JPanel();
		frame.getContentPane().add(botonera, BorderLayout.CENTER);
		
		JLabel lblFilas = new JLabel("Filas");
		pnlCrear.add(lblFilas);
		
		inputFil = new JTextField();
		pnlCrear.add(inputFil);
		inputFil.setColumns(10);
		
		JLabel lblColumna = new JLabel("Columna");
		pnlCrear.add(lblColumna);
		
		inputCol = new JTextField();
		pnlCrear.add(inputCol);
		inputCol.setColumns(10);
		
		setLbltiempo(new JLabel("0"));
		getLbltiempo().setForeground(Color.RED);
		tiempo = new Timer(1000,new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	sec++;
		    	lbltiempo.setText(Integer.toString(sec));
		    	
		    }
		});
		
		
		//----------------------------Crea Tablero-----------------------------------		
		
		JButton btnCrear = new JButton("Crear");
		pnlCrear.add(btnCrear);
		btnCrear.addActionListener(controlador);
		pnlCrear.add(getLbltiempo());
	
		//-------------------------------------------------------------------------------------------------------------------
		//----------------------VISIBILIZO EL FRAME------------------------------------------------------------------------		
		frame.setVisible(true);
	
	
	}


}

