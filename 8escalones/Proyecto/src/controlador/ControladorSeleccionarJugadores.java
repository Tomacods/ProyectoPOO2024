package controlador;

import Vista.Gameplay;
import Vista.MenuPrincipal;
import Vista.SeleccionarJugador;
import Modelos.Jugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorSeleccionarJugadores {

    private SeleccionarJugador vistaSeleccionarJugador;

    public ControladorSeleccionarJugadores(SeleccionarJugador vistaSeleccionarJugador) {  
        super();
        this.vistaSeleccionarJugador = vistaSeleccionarJugador;
        this.vistaSeleccionarJugador.setVisible(true);
        this.vistaSeleccionarJugador.jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salirDelJuego();
            }
        });
        this.vistaSeleccionarJugador.jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAtras();
            }
        });
        this.vistaSeleccionarJugador.jButtonJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugar();
            }
        });
        traerJugadoresCB();
    }


    private void salirDelJuego() {
        System.exit(0);
    }


    private void volverAtras() {
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        vistaSeleccionarJugador.dispose();
    }

    private void jugar(){
        Gameplay gameplay = new Gameplay();
        gameplay.setVisible(true);
        vistaSeleccionarJugador.dispose();
    }

    private void traerJugadoresCB(){ 
        ArrayList<Jugador> jugadores = Jugador.obtenerJugadores(); 
            for (Jugador nombre_jugador : jugadores) {
                vistaSeleccionarJugador.getComboBoxJ1().addItem(nombre_jugador.getNombre());
            }
    }
}
