package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Exception;
import Modelos.Jugador;
import java.util.ArrayList;
import Vista.ABMJugadores;

public class ControladorABMJugadores {
    private ABMJugadores vista;
    private Jugador jugadorSeleccionado;

    public ControladorABMJugadores() {
        this.vista = new ABMJugadores();
        this.jugadorSeleccionado = new Jugador();
        cargarJugadores();
        iniciarVista();
    }

    private void iniciarVista() {
        this.vista.jButtonAgregarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                agregarJugador();
            }
        });
        this.vista.jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                volver();
            }
        });
        this.vista.jButtonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                editarJugador();
            }
        });
        this.vista.jButtonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                eliminarJugador();
            }
        });
        this.vista.jComboBoxJugadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                seleccionarJugador();
            }
        });
        this.vista.setVisible(true);
    }

    private void agregarJugador() {
        if (this.vista.jTextFieldEditarJugador.getText().length() > 1) {
            Jugador nuevoJugador = new Jugador();
            nuevoJugador.setNombre(this.vista.jTextFieldEditarJugador.getText());
            nuevoJugador.setPuntaje(0);
            nuevoJugador.setEstado("activo");
            Jugador.insertarJugador(nuevoJugador);
            this.vista.jComboBoxJugadores.addItem(nuevoJugador);
        } else {
            javax.swing.JOptionPane.showMessageDialog(vista, "Ingrese un nombre valido.",
            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarJugador() {
        if (this.vista.jTextFieldEditarJugador.getText().length() > 1) {
            this.jugadorSeleccionado.setNombre(this.vista.jTextFieldEditarJugador.getText());
            Jugador.actualizarJugador(this.jugadorSeleccionado);
        }
        else {
            javax.swing.JOptionPane.showMessageDialog(vista, "Ingrese un nombre valido.",
            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);        }
    }

    private void eliminarJugador() {
        Jugador.eliminarJugador(this.jugadorSeleccionado.getId());
        int indice = this.vista.jComboBoxJugadores.getSelectedIndex();
        this.vista.jComboBoxJugadores.removeItemAt(indice);
        ;
    }

    private void cargarJugadores() {
        ArrayList<Jugador> lista = Jugador.obtenerJugadores();
        for (int i = 0; i < lista.size(); i++) {
            vista.jComboBoxJugadores.addItem(lista.get(i));
        }
    }

    private void seleccionarJugador() {
        this.jugadorSeleccionado = (Jugador) vista.jComboBoxJugadores.getSelectedItem();
        System.out.println("Jugador seleccionado: " + this.jugadorSeleccionado.getNombre());
    }

    private void volver() {
        this.vista.dispose();
        new MenuPrincipalController();
    }

}
