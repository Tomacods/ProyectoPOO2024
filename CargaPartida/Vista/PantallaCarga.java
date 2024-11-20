package Vista;

import java.net.URL;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorCargaPantalla;

public class PantallaCarga extends JFrame {

    private ControladorCargaPantalla controlador;
    private JPanel borde;
    private JLabel fondoPantallaGif;

    public PantallaCarga(ControladorCargaPantalla controlador) {
        setTitle("Pantalla Carga");
        setControlador(controlador);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establecer tamaño ventana
        setBounds(100, 100, 800, 600); // Ventana de 800x600
        setLayout(null);

        // Icono de la ventana
        URL urlIcono = getClass().getResource("/Imagenes/logo8escalones.png");
        ImageIcon icono = new ImageIcon(urlIcono);
        setIconImage(icono.getImage());
        
        borde = new JPanel();
        borde.setBorder(new EmptyBorder(5, 5, 5, 5));
        borde.setLayout(null);
        setContentPane(borde);

        // GIF de fondo
        fondoPantallaGif = new JLabel();
        fondoPantallaGif.setBounds(0, 0, 800, 600); // Tamaño de la ventana

        // Escala el GIF al tamaño de la ventana
        URL urlGif = getClass().getResource("/Imagenes/8EscalonesCarga.gif");
        ImageIcon gifIcono = new ImageIcon(urlGif);
        Image scaledGif = gifIcono.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        fondoPantallaGif.setIcon(new ImageIcon(scaledGif));
        borde.add(fondoPantallaGif);
    }

    public ControladorCargaPantalla getControlador() {
        return controlador;
    }

    public void setControlador(ControladorCargaPantalla controlador) {
        this.controlador = controlador;
    }

    public JLabel getFondoPantallaGif() {
        return fondoPantallaGif;
    }

    public void setFondoPantallaGif(JLabel fondoPantallaGif) {
        this.fondoPantallaGif = fondoPantallaGif;
    }
}
