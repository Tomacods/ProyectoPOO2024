package controlador;

import Vista.SeleccionarJugador;
import Modelos.Jugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class ControladorSeleccionarJugadores {

    private SeleccionarJugador vistaSeleccionarJugador;
    private ArrayList<String> nombre_jugadores = new ArrayList<>();
    private JComboBox<String>[] comboBoxes;
    private boolean isUpdating = false; // Flag to avoid infinite loop

    @SuppressWarnings("unchecked")
    public ControladorSeleccionarJugadores() {
        this.vistaSeleccionarJugador = new SeleccionarJugador();
        this.vistaSeleccionarJugador.setVisible(true);

        // Almacenar los JComboBox en un array
        comboBoxes = new JComboBox[] {
                vistaSeleccionarJugador.getComboBoxJ1(),
                vistaSeleccionarJugador.getComboBoxJ2(),
                vistaSeleccionarJugador.getComboBoxJ3(),
                vistaSeleccionarJugador.getComboBoxJ4(),
                vistaSeleccionarJugador.getComboBoxJ5(),
                vistaSeleccionarJugador.getComboBoxJ6(),
                vistaSeleccionarJugador.getComboBoxJ7(),
                vistaSeleccionarJugador.getComboBoxJ8(),
                vistaSeleccionarJugador.getComboBoxJ9()
        };

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
        llenarLista();
        traerJugadoresCB();
        listeners();
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

    private void llenarLista() {
        ArrayList<Jugador> jugadores = Jugador.obtenerJugadores();
        for (Jugador jugador : jugadores) {
            nombre_jugadores.add(jugador.getNombre());
        }
    }

    private void traerJugadoresCB() {
        isUpdating = true; // Evitar actualizar durante el llenado inicial
        for (JComboBox<String> comboBox : comboBoxes) {
            comboBox.removeAllItems();
            comboBox.addItem(""); // Añadir opción vacía para deselección
            for (String jugador : nombre_jugadores) {
                comboBox.addItem(jugador);
            }
        }
        isUpdating = false; // Permitir actualizaciones después del llenado inicial
    }

    private void listeners() {
        for (JComboBox<String> comboBox : comboBoxes) {
            comboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!isUpdating) {
                        actualizarComboBoxes();
                    }
                }
            });
        }
    }

    private void actualizarComboBoxes() {
        isUpdating = true; // Evitar bucles infinitos
        ArrayList<String> seleccionados = new ArrayList<>();
        for (JComboBox<String> comboBox : comboBoxes) {
            String seleccionado = (String) comboBox.getSelectedItem();
            if (seleccionado != null && !seleccionado.isEmpty()) {
                seleccionados.add(seleccionado);
            }
        }

        for (JComboBox<String> comboBox : comboBoxes) {
            String seleccionadoActual = (String) comboBox.getSelectedItem();
            comboBox.removeAllItems();
            comboBox.addItem(""); // Añadir opción vacía para deselección
            for (String jugador : nombre_jugadores) {
                if (!seleccionados.contains(jugador) || jugador.equals(seleccionadoActual)) {
                    comboBox.addItem(jugador);
                }
            }
            comboBox.setSelectedItem(seleccionadoActual);
        }
        isUpdating = false; // Permitir actualizaciones después de completar
    }
}
