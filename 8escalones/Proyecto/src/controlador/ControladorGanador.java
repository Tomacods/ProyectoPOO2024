package controlador;
import Vista.Ganador;
import Modelos.Jugador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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