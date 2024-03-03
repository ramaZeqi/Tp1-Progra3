package vista;


import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Dialog.ModalityType;
import java.awt.Cursor;

public class BTNNumElegido extends JDialog {

	private int numElegido;
	/**
	 * Create the dialog.
	 */	
	
	public BTNNumElegido(int x,int y) {
			
		setLocationByPlatform(true);
		setBounds(x, y, 120, 120);
		getContentPane().setLayout(new GridLayout(3, 3, 0, 0));
		setUndecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		//no cede el foco a otra aplicacion 
		setModal(false);
		setModalityType (ModalityType.DOCUMENT_MODAL);

//-------------------CIERRA EL DIALOG AL HACER CLICK FUERA DE SU VENTANA----------------------
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowDeactivated(WindowEvent e) {
			dispose();
			}
		});
		
	
//--------------------------PANEL DE OPCIONES------------------------------------------------		
 
		JButton num_1 = new JButton("1");
		num_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumElegido(1);
				dispose();
				
			}
		});
		num_1.setFont(new Font("Dialog", Font.PLAIN, 8));
		getContentPane().add(num_1);
		
		JButton num_2 = new JButton("2");
		num_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumElegido(2);
				dispose();
				}
		});
		num_2.setFont(new Font("Dialog", Font.PLAIN, 8));
		getContentPane().add(num_2);
		
		JButton num_3 = new JButton("3");
		num_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumElegido(3);
				dispose();
				}
		});
		num_3.setFont(new Font("Dialog", Font.PLAIN, 8));
		getContentPane().add(num_3);
		
		JButton num_4 = new JButton("4");
		num_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumElegido(4);
				dispose();
				}
		});
		num_4.setFont(new Font("Dialog", Font.PLAIN, 8));
		getContentPane().add(num_4);
		
		JButton num_5 = new JButton("5");
		num_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumElegido(5);
				dispose();
				}
		});
		num_5.setFont(new Font("Dialog", Font.PLAIN, 8));
		getContentPane().add(num_5);
		
		JButton num_6 = new JButton("6");
		num_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumElegido(6);
				dispose();
				}
		});
		num_6.setFont(new Font("Dialog", Font.PLAIN, 8));
		getContentPane().add(num_6);
		
		
		JButton num_7 = new JButton("7");
		num_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumElegido(7);
				dispose();
				}
		});
		num_7.setFont(new Font("Dialog", Font.PLAIN, 8));
		getContentPane().add(num_7);
		
		JButton num_8 = new JButton("8");
		num_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumElegido(8);
				dispose();
				}
		});
		num_8.setFont(new Font("Dialog", Font.PLAIN, 8));
		getContentPane().add(num_8);
		
		JButton num_9=new JButton("9");
		num_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumElegido(9);
				dispose();
			}
		});
		num_9.setFont(new Font("Dialog", Font.PLAIN, 8));
		getContentPane().add(num_9);
		
	

//-------------------------------------------------------------------------------------------		
		
	}
	public int getNumElegido() {

		return this.numElegido;
	}
	public void setNumElegido(int numElegido) {
		this.numElegido = numElegido;
	}
	
}