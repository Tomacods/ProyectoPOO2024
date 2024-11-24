package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelos.Jugador;
import ventanas.ABMJugadores;

public class ControladorABMJugadores {
    private ABMJugadores vista;
    private Jugador modelo;

    public ControladorABMJugadores(ABMJugadores vista, Jugador modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.jButtonAgregarJugador.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jugador nuevoJugador = new Jugador();
                nuevoJugador.setNombre = this.vista.jTextFieldEditarJugador.getText();
                nuevoJugador.setPuntaje = 0;
                Jugador.insertarJugador(nuevoJugador);
            }
        });
        this.vista.jButtonBack.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // PENDIENTE
                //ControladorMP controlador = new ControladorMP();
                
            }
        });
        this.vista.jButtonEditar.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //;
            }
        });
        this.vista.jButtonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                this.vista.jComboBoxJugadores.
            }
        });
        this.vista.jButtonExit.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //;
            }
        });
        this.vista.jComboBoxJugadores.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //;
            }
        });
    }

    public void iniciar_vista() {
        this.vista.setVisible(true);
    }
}
