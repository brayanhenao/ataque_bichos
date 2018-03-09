package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class PanelMenu extends JMenuBar implements ActionListener{

	
	private JMenu juego;
	private JMenu ayuda;
	
	private InterfazBichos princi;
	private JMenuItem reiniciar;
	private JMenuItem estadisticas;
	private JMenuItem salir;
	private JMenuItem nuevoJuego;
	private JMenuItem comoSeJuega;
	private JMenuItem acerca;
	
	public PanelMenu() {
		
		juego=new JMenu("Juego");
		ayuda=new JMenu("Ayuda");
		reiniciar=new JMenuItem("Reiniciar nivel");
		estadisticas=new JMenuItem("Estadísticas");
		salir=new JMenuItem("Salir");
		nuevoJuego=new JMenuItem("Nuevo juego");
		comoSeJuega=new JMenuItem("¿Cómo se juega?");
		acerca=new JMenuItem("Acerca de");
		acerca.setActionCommand("acerca");
		acerca.addActionListener(this);
		
		
		
		
		juego.add(reiniciar);
		juego.add(estadisticas);
		juego.add(nuevoJuego);
		juego.add(salir);
		ayuda.add(comoSeJuega);
		ayuda.add(acerca);

		add(juego);
		add(ayuda);
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {

		String ca=	arg0.getActionCommand();
		
		if (ca.equals(acerca.getActionCommand())) {
			JOptionPane.showMessageDialog(this, "EL ATAQUE DE LOS BICHOS 1.0 \n ALGORITMOS Y PROGRAMACIÓN II \n JONATAN ORDOÑEZ \n BRAYAN HENAO");
		}
		
	}

}
