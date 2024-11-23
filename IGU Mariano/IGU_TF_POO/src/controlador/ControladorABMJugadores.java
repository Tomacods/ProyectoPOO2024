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
                //;
            }
        });
        this.vista.jButtonBack.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //;
            }
        });
        this.vista.jButtonEditar.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //;
            }
        });
        this.vista.jButtonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //;
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
        this.vista.jButtonAgregarJugador.set
    }

    public void iniciar_vista() {
        this.vista.setVisible(true);
    }
}
