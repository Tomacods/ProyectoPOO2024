package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Exception;
import Modelos.Jugador;
import java.lang.classfile.instruction.ThrowInstruction;
import java.util.ArrayList;
import ventanas.ABMJugadores;

public class ControladorABMJugadores {
    private ABMJugadores vista;
    private Jugador jugadorSeleccionado;

    public ControladorABMJugadores() {
        this.vista = new ABMJugadores();
        this.jugadorSeleccionado = Jugador();
        
        cargarJugadores();

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
        this.vista.jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                salir();
            }
        });
        this.vista.jComboBoxJugadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                seleccionarJugador();
            }
        });

        iniciarVista();
    }

    private void iniciarVista() {
        this.vista.setVisible(true);
    }

    private void agregarJugador() {
        try {
            Jugador nuevoJugador = new Jugador();
            nuevoJugador.setNombre(this.vista.jTextFieldEditarJugador.getText());
            if (nuevoJugador.getNombre().length() == 0) {
                throw new Exception();
            }
            nuevoJugador.setPuntaje(0);
            nuevoJugador.setEstado("activo");
            Jugador.insertarJugador(nuevoJugador);
            cargarJugadores();
        } catch (Exception e){
            
        }
    }

    private void editarJugador() {
        this.jugadorSeleccionado.setNombre(this.vista.jTextFieldEditarJugador.getText());
        Jugador.actualizarJugador(this.jugadorSeleccionado);
        cargarJugadores();
    }

    private void eliminarJugador() {
        Jugador.eliminarJugador(this.jugadorSeleccionado.getId());
        cargarJugadores();
    }

    private void cargarJugadores() {
        ArrayList <Jugador> lista = Jugador.obtenerJugadores();
        vista.jComboBoxJugadores.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            vista.jComboBoxJugadores.addItem(lista.get(i));
        }
    }

    private void seleccionarJugador() {
        this.jugadorSeleccionado = (Jugador) vista.jComboBoxJugadores.getSelectedItem();
    }
    
    private void volver() {
        this.vista.dispose();
    }

    private void salir() {
        this.vista.dispose();
    }
}
