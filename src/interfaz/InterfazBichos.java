package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import mundo.Juego;

public class InterfazBichos extends JDialog implements ActionListener{
	
	//-------------------------------------------
	//ATRIBUTOS
	//-------------------------------------------
	private JButton botonJugar;
	private JButton botonEstadisticas;
	private JButton botonReiniciar;
	private JLabel imagen;
	
	private PanelMenu menu;
	
	private PanelEstadisticas estadisticas;
	private PanelNiveles niveles;
	private PanelLogin login;
	
	public final static String JUGAR = "jugar";
	public final static String ESTADISTICAS = "estadisticas";
	public final static String REINICIAR = "reiniciar";
	
	private Juego mundo;

	//-------------------------------------------
	//CONSTRUCTOR
	//-------------------------------------------
	public InterfazBichos(Juego mundo){
		
	menu=new PanelMenu();
	this.mundo=mundo;
	mundo = new Juego();
	setTitle("El Ataque de los Bichos 1.0");
	setSize(400,700);
	setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	
	
	
	//Inicializacion paneles
	estadisticas = new PanelEstadisticas(this);
	niveles = new PanelNiveles(this);
	
	//Primer panel auxiliar
	JPanel aux1 = new JPanel();
	aux1.setPreferredSize(new Dimension(400,567));
	aux1.setLayout(new GridLayout(1,1));
	imagen = new JLabel(new ImageIcon("img/Fondo.png"));
	aux1.add(imagen);
	
	//Segundo panel auxiliar
	JPanel aux2 = new JPanel();
	aux2.setBackground(Color.BLACK);
	aux2.setLayout(new GridLayout(2,2));
	botonJugar = new JButton("JUGAR");
	botonJugar.setActionCommand(JUGAR);
	botonJugar.addActionListener(this);
	botonEstadisticas = new JButton("ESTADISTICAS");
	botonEstadisticas.setActionCommand(ESTADISTICAS);
	botonEstadisticas.addActionListener(this);
	aux2.add(botonJugar);
	aux2.add(botonEstadisticas);
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	
	//Tercer panel auxiliar
	JPanel aux3 = new JPanel();
	aux3.setBackground(Color.BLACK);
	aux3.setLayout(new GridLayout(2,3));
	botonReiniciar = new JButton("REINICIAR");
	botonReiniciar.setActionCommand(REINICIAR);
	botonReiniciar.addActionListener(this);
	aux3.add(new JLabel());
	aux3.add(botonReiniciar);
	aux3.add(new JLabel());
	aux3.add(new JLabel());
	aux3.add(new JLabel());
	aux3.add(new JLabel());
	
	JPanel aux4 = new JPanel();
	aux4.setLayout(new GridLayout(2,1));
	aux4.add(aux2);
	aux4.add(aux3);
	
	//Se agregan los paneles al Frame
	add(menu, BorderLayout.NORTH);
	add(aux1, BorderLayout.CENTER);
	add(aux4, BorderLayout.SOUTH);
	}
	
	//-------------------------------------------
	//ACTIONPERFORMED
	//-------------------------------------------
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals(JUGAR)){
			this.setVisible(false);
			niveles.setVisible(true);
		}
		else if(comando.equalsIgnoreCase(ESTADISTICAS)){
			this.setVisible(false);
			estadisticas.setVisible(true);
		}
		else if(comando.equals(REINICIAR)){
			JOptionPane.showMessageDialog(this, "El juego ha sido reiniciado");
		}
		
	}

	//-------------------------------------------
	//MAIN
	//-------------------------------------------
	
}
