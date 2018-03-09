package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelJuego extends JDialog implements ActionListener{

	//-------------------------------------------
	//ATRIBUTOS
	//-------------------------------------------
	private JLabel labTiempo;
	private JLabel labPuntajeAlcanzar;
	private JLabel labPuntajeActual;
	private JLabel labNivel;
	private JTextField txtTiempo;
	private JTextField txtPuntajeAlcanzar;
	private JTextField txtPuntajeActual;
	private JTextField txtNivel;
	private JButton botonSalir;
	private JRadioButton rdSonido;
	private JRadioButton rdPausar;
	
	private PanelTablero pTablero;
	
	private InterfazBichos principal;
	
	public static final String SALIR = "salir";
	
	//-------------------------------------------
	//CONSTRUCTOR
	//-------------------------------------------
	
	public PanelJuego(InterfazBichos v){
	principal = v;
	
	pTablero=new PanelTablero();
	
	setResizable(false);
	setSize(700,400);
	setLocationRelativeTo(this);
	
	//Panel General de los dos auxiliares
	JPanel general = new JPanel();
	general.setLayout(new GridLayout(1,2));
	
	//Primer panel auxiliar
	JPanel aux1 = new JPanel();
	aux1.setLayout(new GridLayout(1,1));
	aux1.add(pTablero);
	
	//Segundo panel auxiliar
	JPanel aux2 = new JPanel();
	aux2.setBackground(Color.WHITE);
	aux2.setLayout(new GridLayout(14,3));
	labTiempo = new JLabel("           Tiempo");
	txtTiempo = new JTextField();
	txtTiempo.setEditable(false);
	
	labPuntajeAlcanzar = new JLabel("   Puntaje Máximo");
	txtPuntajeAlcanzar = new JTextField();
	txtPuntajeAlcanzar.setEditable(false);
	
	labPuntajeActual = new JLabel("      Puntaje actual");
	txtPuntajeActual = new JTextField();
	txtPuntajeActual.setEditable(false);
	
	botonSalir = new JButton("Salir");
	botonSalir.setActionCommand(SALIR);
	botonSalir.addActionListener(this);
	
	labNivel = new JLabel("             Nivel");
	txtNivel = new JTextField();
	txtNivel.setEditable(false);
	
	rdSonido = new JRadioButton("Sonido");
	rdSonido.setBackground(Color.WHITE);
	rdPausar = new JRadioButton("Pausar");
	rdPausar.setBackground(Color.WHITE);
	
	aux2.add(new JLabel());
	aux2.add(labNivel);
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(txtNivel);
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(labTiempo);
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(txtTiempo);
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(labPuntajeAlcanzar);
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(txtPuntajeAlcanzar);
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(labPuntajeActual);
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(txtPuntajeActual);
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(new JLabel());
	aux2.add(botonSalir);
	aux2.add(new JLabel());
//	aux2.add(rdPausar);
//	aux2.add(new JLabel());
//	aux2.add(rdSonido);
	
	general.add(aux1);
	general.add(aux2);
	
	add(general, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals(SALIR)){
			this.setVisible(false);
			principal.setVisible(true);
		}
		
	}

}
