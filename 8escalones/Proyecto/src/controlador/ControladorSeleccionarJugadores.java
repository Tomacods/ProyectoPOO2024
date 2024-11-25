package controlador;

import Vista.Gameplay;
import Vista.MenuPrincipal;
import Vista.SeleccionarJugador;
import Modelos.Jugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class ControladorSeleccionarJugadores {

    private SeleccionarJugador vistaSeleccionarJugador;
    private ArrayList<Jugador> jugadores = Jugador.obtenerJugadores();

    public ControladorSeleccionarJugadores(SeleccionarJugador vistaSeleccionarJugador) {
        super();
        this.vistaSeleccionarJugador = vistaSeleccionarJugador;
        this.vistaSeleccionarJugador.setVisible(true);

        // Agregar los ActionListeners para los botones
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

        // Cargar los jugadores en los comboBoxes
        traerJugadoresCB();

        // Agregar los ItemListeners para cada ComboBox
        vistaSeleccionarJugador.getComboBoxJ1().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                actualizarComboBoxes();
            }
        });

        vistaSeleccionarJugador.getComboBoxJ2().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                actualizarComboBoxes();
            }
        });

        vistaSeleccionarJugador.getComboBoxJ3().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                actualizarComboBoxes();
            }
        });

        vistaSeleccionarJugador.getComboBoxJ4().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                actualizarComboBoxes();
            }
        });

        vistaSeleccionarJugador.getComboBoxJ5().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                actualizarComboBoxes();
            }
        });

        vistaSeleccionarJugador.getComboBoxJ6().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                actualizarComboBoxes();
            }
        });

        vistaSeleccionarJugador.getComboBoxJ7().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                actualizarComboBoxes();
            }
        });

        vistaSeleccionarJugador.getComboBoxJ8().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                actualizarComboBoxes();
            }
        });

        vistaSeleccionarJugador.getComboBoxJ9().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                actualizarComboBoxes();
            }
        });
    }

    private void salirDelJuego() {
        System.exit(0);
    }

    private void volverAtras() {
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        vistaSeleccionarJugador.dispose();
    }

    private void jugar() {
        Gameplay gameplay = new Gameplay(null);
        gameplay.setVisible(true);
        vistaSeleccionarJugador.dispose();
    }

    private void traerJugadoresCB() {
        for (Jugador jugador : jugadores) {
            vistaSeleccionarJugador.getComboBoxJ1().addItem(jugador.getNombre());
            vistaSeleccionarJugador.getComboBoxJ2().addItem(jugador.getNombre());
            vistaSeleccionarJugador.getComboBoxJ3().addItem(jugador.getNombre());
            vistaSeleccionarJugador.getComboBoxJ4().addItem(jugador.getNombre());
            vistaSeleccionarJugador.getComboBoxJ5().addItem(jugador.getNombre());
            vistaSeleccionarJugador.getComboBoxJ6().addItem(jugador.getNombre());
            vistaSeleccionarJugador.getComboBoxJ7().addItem(jugador.getNombre());
            vistaSeleccionarJugador.getComboBoxJ8().addItem(jugador.getNombre());
            vistaSeleccionarJugador.getComboBoxJ9().addItem(jugador.getNombre());
        }
    }

    private void actualizarComboBoxes() {
        // Obtener las selecciones de todos los ComboBoxes
        String jugador1 = (String) vistaSeleccionarJugador.getComboBoxJ1().getSelectedItem();
        String jugador2 = (String) vistaSeleccionarJugador.getComboBoxJ2().getSelectedItem();
        String jugador3 = (String) vistaSeleccionarJugador.getComboBoxJ3().getSelectedItem();
        String jugador4 = (String) vistaSeleccionarJugador.getComboBoxJ4().getSelectedItem();
        String jugador5 = (String) vistaSeleccionarJugador.getComboBoxJ5().getSelectedItem();
        String jugador6 = (String) vistaSeleccionarJugador.getComboBoxJ6().getSelectedItem();
        String jugador7 = (String) vistaSeleccionarJugador.getComboBoxJ7().getSelectedItem();
        String jugador8 = (String) vistaSeleccionarJugador.getComboBoxJ8().getSelectedItem();
        String jugador9 = (String) vistaSeleccionarJugador.getComboBoxJ9().getSelectedItem();

        // Limpiar todos los ComboBoxes antes de agregar las opciones
        limpiarComboBoxes();

        // Volver a llenar los ComboBoxes con los jugadores disponibles
        for (Jugador jugador : jugadores) {
            // Agregar al ComboBox solo si el jugador no está seleccionado en otros ComboBoxes
            if (!jugador.getNombre().equals(jugador1) && !jugador.getNombre().equals(jugador2) &&
                !jugador.getNombre().equals(jugador3) && !jugador.getNombre().equals(jugador4) &&
                !jugador.getNombre().equals(jugador5) && !jugador.getNombre().equals(jugador6) &&
                !jugador.getNombre().equals(jugador7) && !jugador.getNombre().equals(jugador8) &&
                !jugador.getNombre().equals(jugador9)) {
                vistaSeleccionarJugador.getComboBoxJ1().addItem(jugador.getNombre());
                vistaSeleccionarJugador.getComboBoxJ2().addItem(jugador.getNombre());
                vistaSeleccionarJugador.getComboBoxJ3().addItem(jugador.getNombre());
                vistaSeleccionarJugador.getComboBoxJ4().addItem(jugador.getNombre());
                vistaSeleccionarJugador.getComboBoxJ5().addItem(jugador.getNombre());
                vistaSeleccionarJugador.getComboBoxJ6().addItem(jugador.getNombre());
                vistaSeleccionarJugador.getComboBoxJ7().addItem(jugador.getNombre());
                vistaSeleccionarJugador.getComboBoxJ8().addItem(jugador.getNombre());
                vistaSeleccionarJugador.getComboBoxJ9().addItem(jugador.getNombre());
            }
        }
    }

    private void limpiarComboBoxes() {
        vistaSeleccionarJugador.getComboBoxJ1().removeAllItems();
        vistaSeleccionarJugador.getComboBoxJ2().removeAllItems();
        vistaSeleccionarJugador.getComboBoxJ3().removeAllItems();
        vistaSeleccionarJugador.getComboBoxJ4().removeAllItems();
        vistaSeleccionarJugador.getComboBoxJ5().removeAllItems();
        vistaSeleccionarJugador.getComboBoxJ6().removeAllItems();
        vistaSeleccionarJugador.getComboBoxJ7().removeAllItems();
        vistaSeleccionarJugador.getComboBoxJ8().removeAllItems();
        vistaSeleccionarJugador.getComboBoxJ9().removeAllItems();
    }
}
