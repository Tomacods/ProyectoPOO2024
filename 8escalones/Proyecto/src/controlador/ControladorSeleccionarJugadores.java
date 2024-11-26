package controlador;

import Vista.SeleccionarJugador;
import Modelos.Jugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ControladorSeleccionarJugadores {

    private SeleccionarJugador vistaSeleccionarJugador;
    private ArrayList<Jugador> jugadores = Jugador.obtenerJugadores();
    private ArrayList<JComboBox<String>> comboBoxes;
    private boolean updating = false; // Bandera para evitar eventos recursivos

    public ControladorSeleccionarJugadores() {
        this.vistaSeleccionarJugador = new SeleccionarJugador();
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

        // Configurar botones
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
        this.vistaSeleccionarJugador.jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salirDelJuego();
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
        // new ControladorGameplay();
        vistaSeleccionarJugador.dispose();
    }

    private void salirDelJuego() {
        System.exit(0);
    }

    // Método para cargar jugadores en un JComboBox usando DefaultComboBoxModel
    private void traerJugadoresCB(JComboBox<String> comboBox) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Jugador jugador : jugadores) {
            model.addElement(jugador.getNombre());
        }
        comboBox.setModel(model);
    }

    private void actualizarComboBoxes() {
        updating = true; // Inicio de la actualización

        // Obtener jugadores seleccionados
        ArrayList<String> seleccionados = obtenerJugadoresSeleccionados();

        // Actualizar cada JComboBox
        for (JComboBox<String> comboBox : comboBoxes) {
            actualizarComboBox(comboBox, seleccionados);
        }

        updating = false; // Fin de la actualización
    }

    // Método auxiliar para obtener la lista de jugadores seleccionados
    private ArrayList<String> obtenerJugadoresSeleccionados() {
        ArrayList<String> seleccionados = new ArrayList<>();
        for (JComboBox<String> comboBox : comboBoxes) {
            String seleccionado = (String) comboBox.getSelectedItem();
            if (seleccionado != null) {
                seleccionados.add(seleccionado);
            }
        }
        return seleccionados;
    }

    // Método auxiliar para actualizar un JComboBox específico
    private void actualizarComboBox(JComboBox<String> comboBox, ArrayList<String> seleccionados) {
        String seleccionadoAnterior = (String) comboBox.getSelectedItem();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Jugador jugador : jugadores) {
            if (!seleccionados.contains(jugador.getNombre()) || jugador.getNombre().equals(seleccionadoAnterior)) {
                model.addElement(jugador.getNombre());
            }
        }
        comboBox.setModel(model);
        comboBox.setSelectedItem(seleccionadoAnterior);
    }
}