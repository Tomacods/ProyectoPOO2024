package Vista;
import java.net.URL;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorCargaPantalla;


public class PantallaCarga extends JFrame {

    private ControladorCargaPantalla controlador;
    private JPanel borde;
    private JLabel fondoPantallaGif;
    //private JLabel cargando;
    //private JLabel puntosCarga;

    public PantallaCarga(ControladorCargaPantalla controlador){
        setTitle("Pantalla Carga");
        setControlador(controlador);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(800, 600);
        //setBounds(100, 100, 800, 600);
        setBounds(100, 100, 917, 440);
        setUndecorated(false); // Ocultar bordes y barra de título
        setLayout(null);

        URL urlIcono = getClass().getResource("/Imagenes/logo8escalones.png");
        ImageIcon icono = new ImageIcon(urlIcono);
        setIconImage(icono.getImage());
        borde = new JPanel();
        borde.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(borde);
        borde.setLayout(null);

        fondoPantallaGif = new JLabel("Cargando partida");
        //fondoPantallaGif.addMouseListener(getControlador());
		fondoPantallaGif.setBounds(340, 25, 490, 301);
        fondoPantallaGif.setHorizontalAlignment(SwingConstants.CENTER);
		
        //fondoPantallaGif.setIcon(new ImageIcon(getClass().getResource("/Imagenes/8EscalonesCarga.gif")));
        URL urlGif = getClass().getResource("/Imagenes/8EscalonesCargaResize.gif");
        ImageIcon gifIcon = new ImageIcon(urlGif);
        fondoPantallaGif.setIcon(gifIcon);
        borde.add(fondoPantallaGif);
        fondoPantallaGif.setText("");

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