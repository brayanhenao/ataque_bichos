package interfaz;

import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle.Control;

import javax.swing.*;
import javax.xml.soap.Text;

import mundo.Juego;
import mundo.Jugador;

public class PanelLogin extends JFrame implements ActionListener {

	private InterfazBichos principal;
	private PanelRegistro registro;

	private JLabel labUsuario;
	private JLabel labContraseña;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JButton butIngresar;
	private JButton butRegistrar;
	private Juego mundo;
	
	public Juego darMundo(){
		return mundo;
	}
	

	public PanelLogin() {
		mundo=new Juego();
		registro=new PanelRegistro(this);
		principal=new InterfazBichos(mundo);
		labUsuario = new JLabel("Usuario ", SwingConstants.CENTER);
		labUsuario.setPreferredSize(new Dimension(250, 50));
		labContraseña = new JLabel("Contraseña ", SwingConstants.CENTER);
		labContraseña.setPreferredSize(new Dimension(250, 50));

		txtUsuario = new JTextField();
		txtUsuario.setPreferredSize(new Dimension(250, 25));

		butIngresar = new JButton("Ingresar");
		butIngresar.setActionCommand("INGRESAR");
		butIngresar.addActionListener(this);
		butIngresar.setPreferredSize(new Dimension(200, 40));

		butRegistrar = new JButton("Registrar");
		butRegistrar.setActionCommand("REGISTRAR");
		butRegistrar.addActionListener(this);
		butRegistrar.setPreferredSize(new Dimension(200, 40));

		getContentPane().setLayout(new FlowLayout());
		setSize(350, 350);
		passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(250, 25));
		passwordField.setEchoChar('*');

		JLabel va = new JLabel();
		va.setPreferredSize(new Dimension(250, 25));

		getContentPane().add(labUsuario);
		getContentPane().add(txtUsuario);
		getContentPane().add(labContraseña);
		getContentPane().add(passwordField);
		getContentPane().add(va);
		getContentPane().add(butIngresar);
		getContentPane().add(butRegistrar);

	}
	
	public void registrarUsuario(String nombre, String password) throws Exception{
		Jugador ju=mundo.buscarJugador(nombre);
		if (ju!=null) {
			throw new Exception("El jugador ya existe");
		} else mundo.registrarJugador(nombre, password);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ca = e.getActionCommand();

		if (ca.equals("INGRESAR")) {


			 if (mundo.buscarJugador(txtUsuario.getText()) !=
			 null) {
			 if (!mundo.buscarJugador(txtUsuario.getText())
			 .getPassword()
			 .equals(passwordField.getText())) {
			 JOptionPane.showMessageDialog(this,
			 "Contraseña incorrecta.", "XD",
			 JOptionPane.WARNING_MESSAGE);
			 } else {
				 
			
			 principal.setVisible(true);
			 mundo.inicializarNiveles();
			 mundo.generarBichos();
			 mundo.iniciarSesion(txtUsuario.getText());
			 
			 
//			 System.out.println(mundo.buscarJugador(txtUsuario.getText()).isConectado());
			 
			 this.setVisible(false);
			 }
			 } else {
			 JOptionPane.showMessageDialog(this,
			 "Nombre de usuario  incorrecta", "XD",
			 JOptionPane.WARNING_MESSAGE);
			 }

	
		

		} else if (ca.equals("REGISTRAR")) {


			registro.setVisible(true);
			
		}

	}

	public static void main(String[] args) {

		PanelLogin ventana = new PanelLogin();
		ventana.setVisible(true);

	}
}
