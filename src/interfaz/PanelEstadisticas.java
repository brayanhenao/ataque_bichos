package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class PanelEstadisticas extends JDialog implements ActionListener{
	
	//-------------------------------------------
	//ATRIBUTOS
	//-------------------------------------------
	private JList lista;
	private JScrollPane bar;
	private JButton botonSalir;
	private InterfazBichos principal;
	
	public static final String SALIR = "salir";
	private JComboBox comboBox;
	
	//-------------------------------------------
	//CONSTRUCTOR
	//-------------------------------------------
	public PanelEstadisticas(InterfazBichos v){
		principal = v;
		setResizable(false);
		setSize(300,300);
		setLocationRelativeTo(this);
		setTitle("Estadisticas");
		
		//Se agrega el JList
		lista = new JList();
		lista.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		bar = new JScrollPane(lista);
		bar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		bar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//Primer panel auxiliar
		JPanel aux2 = new JPanel();
		aux2.setBackground(Color.ORANGE);
		aux2.setLayout(new GridLayout(1,3));
		botonSalir = new JButton("Salir");
		botonSalir.setActionCommand(SALIR);
		botonSalir.addActionListener(this);
		aux2.add(new JLabel());
		aux2.add(botonSalir);
		aux2.add(new JLabel());
		
		//Se agrega el JList y el panel auxiliar al JDialog
		getContentPane().add(bar, BorderLayout.CENTER);
		getContentPane().add(aux2, BorderLayout.SOUTH);
		
		comboBox = new JComboBox();
		getContentPane().add(comboBox, BorderLayout.NORTH);
		comboBox.addItem("Nivel 1");
		comboBox.addItem("Nivel 2");
		comboBox.addItem("Nivel 3");
		comboBox.addItem("Nivel 4");
		comboBox.addItem("Nivel 5");
		
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
		
	}
}
