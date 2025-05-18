package controlador;
import Vista.Ganador;
import Modelos.Jugador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ControladorGanador is responsible for managing the winner view in the application.
 * It displays the winner's information and, after a set period, transitions back to the main menu.
 *
 * <p>Responsibilities:</p>
 * <ul>
 *   <li>Initializes the winner view with the player's name.</li>
 *   <li>Shows the winner view for a fixed duration (10 seconds).</li>
 *   <li>Automatically closes the winner view and returns to the main menu after the duration.</li>
 * </ul>
 *
 * @author tomas
 */
public class ControladorGanador {
    private Jugador jugador;
    private Ganador vista;

    public ControladorGanador( Jugador jugador) {
        this.vista = new Ganador();
        this.vista.setVisible(true);
        this.jugador = jugador;
        inicializarVista();
    }

    private void inicializarVista() {
        vista.jTextFieldJ9.setText(jugador.getNombre());
        vista.setVisible(true);

        Timer timer = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose(); 
                mostrarMenuPrincipal();
            }
        });
        timer.setRepeats(false); // Solo se ejecuta una vez
        timer.start();
    }

    private void mostrarMenuPrincipal() {
        this.vista.dispose();
        new MenuPrincipalController();
    }
}