package ventanas;

import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel {
	
	public Image imagen;

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Fondo() {
	}
	
	
	@Override
	public void paint(Graphics g){
		imagen = new ImageIcon(getClass().getResource("MenuPrincipal.png")).getImage();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
}

