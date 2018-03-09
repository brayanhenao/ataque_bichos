package interfaz;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelRegistro extends JDialog implements ActionListener{

	private PanelLogin login;

	private JLabel labNombre;
	private JLabel labContraseña;
	private JLabel labRepiteContraseña;
	
	private JTextField txtNombre;
	
	private JPasswordField pContraseña;
	private JPasswordField pRepiteContraseña;
	
	private JButton butRegistrar;
	
	
		
	public PanelRegistro (PanelLogin l){
		login=l;
		
		labNombre=new JLabel("Nombre:");
		labNombre.setPreferredSize(new Dimension(100, 25));
		labContraseña=new JLabel("Contraseña:");
		labContraseña.setPreferredSize(new Dimension(100, 25));
		
		butRegistrar=new JButton("Registrar");
		butRegistrar.setActionCommand("REGISTRAR");
		butRegistrar.addActionListener(this);
		butRegistrar.setPreferredSize(new Dimension(100, 25));
		
		txtNombre=new JTextField();
		txtNombre.setPreferredSize(new Dimension(100, 25));
		
		pContraseña=new JPasswordField();
		pContraseña.setPreferredSize(new Dimension(100, 25));
		pContraseña.setEchoChar('*');
		
		pRepiteContraseña=new JPasswordField();
		pRepiteContraseña.setPreferredSize(new Dimension(100, 25));
		pRepiteContraseña.setEchoChar('*');
		
		JLabel lab=new JLabel();
		lab.setPreferredSize(new Dimension(450, 25));
		setSize(323, 296);
		getContentPane().setLayout(new FlowLayout());
		
		getContentPane().add(labNombre);
		getContentPane().add(txtNombre);
		getContentPane().add(labContraseña);
		getContentPane().add(pContraseña);
		labRepiteContraseña=new JLabel("Repite Contraseña:");
		labRepiteContraseña.setPreferredSize(new Dimension(100, 25));
		getContentPane().add(labRepiteContraseña);
		getContentPane().add(pRepiteContraseña);
		getContentPane().add(lab);
		getContentPane().add(butRegistrar);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		/** El agregar de la lista enlazada no está bien.
		 * 
		 */
		
		if (e.getActionCommand().equals("REGISTRAR")) {
			if (txtNombre.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Debe ingresar un nombre");
			} else	if (pContraseña.getText().equals("") || pRepiteContraseña.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Debe ingresar una contraseña");
			} else if (!pContraseña.getText().equals(pRepiteContraseña.getText())) {
				JOptionPane.showMessageDialog(this, "Las contraseñas deben coincidir");
			} else {
				try {
					login.registrarUsuario(txtNombre.getText(), pContraseña.getText());
					JOptionPane.showMessageDialog(this, "Se ha registrado al usuario con éxito.");
					this.setVisible(false);
					login.darMundo().guardarInfo();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
				
			}
		}  
	}
	
	

}
