package Vista;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class Interfaz_test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_test window = new Interfaz_test();
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
	public Interfaz_test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("Images\\Logo_Canal_Trece_actual.png").getImage());
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(0, 0, 586, 363);
		lblImagen.setToolTipText("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("Images\\logo_los8esc.png").getImage().getScaledInstance(586,363,Image.SCALE_DEFAULT));
		frame.getContentPane().setLayout(null);
		lblImagen.setIcon(imageIcon);
		frame.getContentPane().add(lblImagen);
		
		JButton button = new JButton("JUGAR");
		button.setBounds(380, 170, 90, 30);
		frame.getContentPane().add(button);
	}
}
