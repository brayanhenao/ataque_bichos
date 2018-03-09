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
	private JLabel labContrase�a;
	private JLabel labRepiteContrase�a;
	
	private JTextField txtNombre;
	
	private JPasswordField pContrase�a;
	private JPasswordField pRepiteContrase�a;
	
	private JButton butRegistrar;
	
	
		
	public PanelRegistro (PanelLogin l){
		login=l;
		
		labNombre=new JLabel("Nombre:");
		labNombre.setPreferredSize(new Dimension(100, 25));
		labContrase�a=new JLabel("Contrase�a:");
		labContrase�a.setPreferredSize(new Dimension(100, 25));
		
		butRegistrar=new JButton("Registrar");
		butRegistrar.setActionCommand("REGISTRAR");
		butRegistrar.addActionListener(this);
		butRegistrar.setPreferredSize(new Dimension(100, 25));
		
		txtNombre=new JTextField();
		txtNombre.setPreferredSize(new Dimension(100, 25));
		
		pContrase�a=new JPasswordField();
		pContrase�a.setPreferredSize(new Dimension(100, 25));
		pContrase�a.setEchoChar('*');
		
		pRepiteContrase�a=new JPasswordField();
		pRepiteContrase�a.setPreferredSize(new Dimension(100, 25));
		pRepiteContrase�a.setEchoChar('*');
		
		JLabel lab=new JLabel();
		lab.setPreferredSize(new Dimension(450, 25));
		setSize(323, 296);
		getContentPane().setLayout(new FlowLayout());
		
		getContentPane().add(labNombre);
		getContentPane().add(txtNombre);
		getContentPane().add(labContrase�a);
		getContentPane().add(pContrase�a);
		labRepiteContrase�a=new JLabel("Repite Contrase�a:");
		labRepiteContrase�a.setPreferredSize(new Dimension(100, 25));
		getContentPane().add(labRepiteContrase�a);
		getContentPane().add(pRepiteContrase�a);
		getContentPane().add(lab);
		getContentPane().add(butRegistrar);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		/** El agregar de la lista enlazada no est� bien.
		 * 
		 */
		
		if (e.getActionCommand().equals("REGISTRAR")) {
			if (txtNombre.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Debe ingresar un nombre");
			} else	if (pContrase�a.getText().equals("") || pRepiteContrase�a.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Debe ingresar una contrase�a");
			} else if (!pContrase�a.getText().equals(pRepiteContrase�a.getText())) {
				JOptionPane.showMessageDialog(this, "Las contrase�as deben coincidir");
			} else {
				try {
					login.registrarUsuario(txtNombre.getText(), pContrase�a.getText());
					JOptionPane.showMessageDialog(this, "Se ha registrado al usuario con �xito.");
					this.setVisible(false);
					login.darMundo().guardarInfo();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
				
			}
		}  
	}
	
	

}
