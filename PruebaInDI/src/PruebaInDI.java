import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PruebaInDI {

	private JFrame frame;
	private JTextField txPassw;
	private JTextField txUser;
	private JLabel JLUser,JLPassword,JLMostrarEstado,JLEstado;
	private JButton btLogin,btRegistar;
	private static Conexion con;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaInDI window = new PruebaInDI();
					
					//Conexión
					con = new Conexion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PruebaInDI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 366, 233);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLUser = new JLabel("Username:");
		JLUser.setBounds(73, 22, 56, 13);
		frame.getContentPane().add(JLUser);
		
		JLPassword = new JLabel("Password:");
		JLPassword.setBounds(73, 56, 56, 13);
		frame.getContentPane().add(JLPassword);
		
		txPassw = new JTextField();
		txPassw.setBounds(139, 53, 149, 19);
		frame.getContentPane().add(txPassw);
		txPassw.setColumns(10);
		
		txUser = new JTextField();
		txUser.setBounds(139, 19, 149, 19);
		frame.getContentPane().add(txUser);
		txUser.setColumns(10);
		
		btLogin = new JButton("Login");
		btLogin.addActionListener(new ActionListener() {
			
			//Cuando le da al botón
			public void actionPerformed(ActionEvent e) {
				//Guardar el método buscarDatos en el acce.
				Acceso acce = con.buscarDatos(txUser.getText(),txPassw.getText());
				
				//Comparar el usuario del bbdd con el usuario introducido
				if(txUser.getText().equals(acce.getUser()) && txPassw.getText().equals(acce.getPassw())){
					//Mostrar exito si el usuario y contraseña es iguales al bbdd
					JLMostrarEstado.setText("Éxito");
				}else {
					//Mostrar error si el usuario y contraseña es diferente al de bbdd
					JLMostrarEstado.setText("Error");
				}
			}
		});
		btLogin.setBounds(87, 117, 201, 21);
		frame.getContentPane().add(btLogin);
		
		btRegistar = new JButton("Registrar");
		btRegistar.setBounds(87, 148, 201, 21);
		frame.getContentPane().add(btRegistar);
		
		JLMostrarEstado = new JLabel("");
		JLMostrarEstado.setBounds(139, 82, 149, 13);
		frame.getContentPane().add(JLMostrarEstado);
		
		
		JLEstado = new JLabel("Estado:");
		JLEstado.setBounds(73, 82, 56, 13);
		frame.getContentPane().add(JLEstado);
	}

}
