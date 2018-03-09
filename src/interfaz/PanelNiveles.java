package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelNiveles extends JDialog implements ActionListener{

	//-------------------------------------------
	//ATRIBUTOS
	//-------------------------------------------
	private JButton nivelUno;
	private JButton nivelDos;
	private JButton nivelTres;
	private JButton nivelCuatro;
	private JButton nivelCinco;
	private JButton botonSalir;
	
	public static final String UNO = "1";
	public static final String DOS = "2";
	public static final String TRES = "3";
	public static final String CUATRO = "4";
	public static final String CINCO = "5";
	public static final String SALIR = "salir";
	
	private InterfazBichos principal;
	private PanelJuego juego;
	
	//-------------------------------------------
	//CONSTRUCTOR
	//-------------------------------------------
	public PanelNiveles(InterfazBichos v){
	principal = v;
	juego = new PanelJuego(principal);
	setSize(400,200);
	setLocationRelativeTo(this);
	setResizable(false);
	setTitle("Selector de niveles");
	
	//Primer panel auxiliar
	JPanel aux1 = new JPanel();
	aux1.setBackground(Color.WHITE);
	aux1.setLayout(new GridLayout(2,1));
	aux1.add(new JLabel());
	JLabel texto1 = new JLabel("Selecciona un nivel:");
	texto1.setForeground(Color.BLUE);
	aux1.add(texto1);
	
	//Segundo panel auxiliar
	JPanel aux2 = new JPanel();
	aux2.setBackground(Color.WHITE);
	aux2.setLayout(new GridLayout(2,5));
	nivelUno = new JButton("1");
	nivelUno.setActionCommand(UNO);
	nivelUno.addActionListener(this);
	nivelDos = new JButton("2");
	nivelDos.setActionCommand(DOS);
	nivelDos.addActionListener(this);
	nivelTres = new JButton("3");
	nivelTres.setActionCommand(TRES);
	nivelTres.addActionListener(this);
	nivelCuatro = new JButton("4");
	nivelCuatro.setActionCommand(CUATRO);
	nivelCuatro.addActionListener(this);
	nivelCinco = new JButton("5");
	nivelCinco.setActionCommand(CINCO);
	nivelCinco.addActionListener(this);
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(nivelUno);
	aux2.add(nivelDos);
	aux2.add(nivelTres);
	aux2.add(nivelCuatro);
	aux2.add(nivelCinco);
	
	//Tercer panel auxiliar
	JPanel aux3 = new JPanel();
	aux3.setBackground(Color.BLUE);
	aux3.setLayout(new GridLayout(3,3));
	botonSalir = new JButton("Salir");
	botonSalir.setActionCommand(SALIR);
	botonSalir.addActionListener(this);
	aux3.add(new JLabel());
	aux3.add(new JLabel());
	aux3.add(new JLabel());
	aux3.add(new JLabel());
	aux3.add(botonSalir);
	aux3.add(new JLabel());
	aux3.add(new JLabel());
	aux3.add(new JLabel());
	aux3.add(new JLabel());
	
	//Se agregan los paneles auxiliares al JDialog
	add(aux1, BorderLayout.NORTH);
	add(aux2, BorderLayout.CENTER);
	add(aux3, BorderLayout.SOUTH);
	}
	
	//-------------------------------------------
	//ACTIONPERFORMED
	//-------------------------------------------
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals(SALIR)){
			this.setVisible(false);
			principal.setVisible(true);
		}
		else if (comando.equals(UNO)){
			this.setVisible(false);
			juego.setVisible(true);
		}
		else if (comando.equals(DOS)){
			this.setVisible(false);
			juego.setVisible(true);
		}
		else if (comando.equals(TRES)){
			this.setVisible(false);
			juego.setVisible(true);
		}
		else if (comando.equals(CUATRO)) {
			this.setVisible(false);
			juego.setVisible(true);
		}
		else if (comando.equals(CINCO)) {
			this.setVisible(false);
			juego.setVisible(true);
		}
		
	}

}
