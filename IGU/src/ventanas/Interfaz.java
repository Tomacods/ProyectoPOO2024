package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import ventanas.Fondo;
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
import java.awt.Cursor;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.util.HashSet;
import java.util.Set;
import javax.swing.SpringLayout;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
		setTitle("Los 8 Escalones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int resoX = 1024;
		int resoY = 768;
		setBounds(100, 100, resoX, resoY);
		contentPane = new Fondo();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            
		
		JButton btnNewButton = new JButton("JUGAR");
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnNewButton);
		btnNewButton.setForeground(Color.MAGENTA);
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		
		JButton btnOpciones = new JButton("OPCIONES");
		btnOpciones.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnOpciones);
		btnOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOpciones.setForeground(Color.MAGENTA);
		btnOpciones.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		
		JButton btnHistorial = new JButton("HISTORIAL");
		btnHistorial.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnHistorial);
		btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHistorial.setForeground(Color.MAGENTA);
		btnHistorial.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		
		JLabel lblFondo = new JLabel("");
		ImageIcon imgFondo = new ImageIcon(new ImageIcon("MenuPrincipal.png").getImage().getScaledInstance(resoY, resoX, Image.SCALE_DEFAULT));
		lblFondo.setIcon(imgFondo);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblFondo, GroupLayout.PREFERRED_SIZE, 1010, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(375, 375, 375)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 284, GroupLayout.PREFERRED_SIZE))
					.addGap(375, 375, 375)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblFondo, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(490, 490, 490)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
					.addGap(490, 490, 490)
		);
		contentPane.setLayout(gl_contentPane);
	}
}
