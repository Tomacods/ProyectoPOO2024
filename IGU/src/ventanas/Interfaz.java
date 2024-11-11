package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnHistorial = new JButton("HISTORIAL");
		btnHistorial.setBounds(470, 443, 207, 66);
		btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(null);
		btnHistorial.setForeground(Color.MAGENTA);
		btnHistorial.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		contentPane.add(btnHistorial);
		
		JButton btnOpciones = new JButton("OPCIONES");
		btnOpciones.setBounds(470, 367, 207, 66);
		btnOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOpciones.setForeground(Color.MAGENTA);
		btnOpciones.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		contentPane.add(btnOpciones);
		
		JButton btnNewButton = new JButton("JUGAR");
		btnNewButton.setBounds(470, 291, 207, 66);
		btnNewButton.setForeground(Color.MAGENTA);
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		contentPane.add(btnNewButton);
		
		JLabel lblTitulo2 = new JLabel("8 ESCALONES");
		lblTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo2.setBounds(60, 203, 325, 108);
		lblTitulo2.setForeground(Color.CYAN);
		lblTitulo2.setFont(new Font("Segoe UI Black", Font.BOLD, 45));
		contentPane.add(lblTitulo2);
		
		JLabel lblFondo = new JLabel("New label");
		lblFondo.setBounds(-10, -10, 786, 563);
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Maria\\Desktop\\ImagenesIGU\\1.jpg"));
		contentPane.add(lblFondo);
	}
}
