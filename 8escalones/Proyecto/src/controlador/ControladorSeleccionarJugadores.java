package controlador;

import Vista.Gameplay;
import Vista.SeleccionarJugador;
import Modelos.Jugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class ControladorSeleccionarJugadores {

    private SeleccionarJugador vistaSeleccionarJugador;
    private ArrayList<Jugador> jugadores = Jugador.obtenerJugadores();
    private ArrayList<JComboBox<String>> comboBoxes;
    private boolean updating = false;  // Bandera para evitar eventos recursivos

    public ControladorSeleccionarJugadores(SeleccionarJugador vistaSeleccionarJugador) {
        this.vistaSeleccionarJugador = vistaSeleccionarJugador;
        this.vistaSeleccionarJugador.setVisible(true);
        this.comboBoxes = new ArrayList<>();

        // Añadir los comboboxes a la lista
        comboBoxes.add(vistaSeleccionarJugador.getComboBoxJ1());
        comboBoxes.add(vistaSeleccionarJugador.getComboBoxJ2());
        comboBoxes.add(vistaSeleccionarJugador.getComboBoxJ3());
        comboBoxes.add(vistaSeleccionarJugador.getComboBoxJ4());
        comboBoxes.add(vistaSeleccionarJugador.getComboBoxJ5());
        comboBoxes.add(vistaSeleccionarJugador.getComboBoxJ6());
        comboBoxes.add(vistaSeleccionarJugador.getComboBoxJ7());
        comboBoxes.add(vistaSeleccionarJugador.getComboBoxJ8());
        comboBoxes.add(vistaSeleccionarJugador.getComboBoxJ9());

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

        // Inicializa y agrega ItemListener a cada JComboBox
        for (JComboBox<String> comboBox : comboBoxes) {
            traerJugadoresCB(comboBox);
            comboBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED && !updating) {
                        actualizarComboBoxes();
                    }
                }
            });
        }
    }

    

    private void volverAtras() {
        new MenuPrincipalController();
        vistaSeleccionarJugador.dispose(); // Cierra la ventana actual
    }

    private void jugar() {
        Gameplay gameplay = new Gameplay();
        gameplay.setVisible(true);
        vistaSeleccionarJugador.dispose();
    }

    private void traerJugadoresCB(JComboBox<String> comboBox) {
        comboBox.removeAllItems();
        for (Jugador jugador : jugadores) {
            comboBox.addItem(jugador.getNombre());
        }
    }

    private void actualizarComboBoxes() {
        updating = true;  // Inicio de la actualización

        // Obtener jugadores seleccionados
        ArrayList<String> seleccionados = new ArrayList<>();
        for (JComboBox<String> comboBox : comboBoxes) {
            String seleccionado = (String) comboBox.getSelectedItem();
            if (seleccionado != null) {
                seleccionados.add(seleccionado);
            }
        }

        // Actualizar cada JComboBox
        for (JComboBox<String> comboBox : comboBoxes) {
            String seleccionadoAnterior = (String) comboBox.getSelectedItem();
            comboBox.removeAllItems();
            for (Jugador jugador : jugadores) {
                if (!seleccionados.contains(jugador.getNombre()) || jugador.getNombre().equals(seleccionadoAnterior)) {
                    comboBox.addItem(jugador.getNombre());
                }
            }
            comboBox.setSelectedItem(seleccionadoAnterior);
        }

        updating = false;  // Fin de la actualización
    }
}
