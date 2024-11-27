package controlador;

import Vista.SeleccionarJugador;
import Modelos.Jugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import java.sql.SQLException;
import Modelos.Tematica;

public class ControladorSeleccionarJugadores {

    public  ArrayList<Tematica> tematicas = Tematica.obtenerTematicas();
    private SeleccionarJugador vistaSeleccionarJugador;
    private ArrayList<Jugador> jugadores = Jugador.obtenerJugadores();
    public ArrayList<Jugador> seleccionadosOrden = new ArrayList<>(); // Lista para guardar el orden de selección
    private JComboBox<Jugador>[] comboBoxes;
    private boolean isUpdating = false; // Flag to avoid infinite loop

    @SuppressWarnings("unchecked")
    public ControladorSeleccionarJugadores() {
        this.vistaSeleccionarJugador = new SeleccionarJugador();    
        this.vistaSeleccionarJugador.setVisible(true);
        // Almacenar los JComboBox en un array
        comboBoxes = new JComboBox[]{
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
        // Tematica tematica = tematicas.get(1);
        // ArrayList tematicasRestantes = new ArrayList <>(tematicas.subList(1,tematicas.size()));

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
    

    // private void jugar() {
    //     try {
    //         vistaSeleccionarJugador.dispose();
    //         new ControladorGameplay(1, obtenerJugadoresSeleccionados(), tematicas);
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }
    private void jugar() {
        new Thread(() -> {
            try {
                if (obtenerJugadoresSeleccionados().size() == 9) { 
                    vistaSeleccionarJugador.dispose();
                    new ControladorGameplay(1, obtenerJugadoresSeleccionados(), tematicas);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(vistaSeleccionarJugador, "Se necesitan 9 jugadores", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }} catch (SQLException e) {
                    e.printStackTrace();
                }
        }).start();
        //vistaSeleccionarJugador.setVisible(false);
    }

    private void salirDelJuego() {
        System.exit(0);
    }

    private void llenarLista() {
        jugadores = Jugador.obtenerJugadores();
    }

    private void traerJugadoresCB() {
        isUpdating = true; // Evitar actualizar durante el llenado inicial
        for (JComboBox<Jugador> comboBox : comboBoxes) {
            comboBox.removeAllItems();
            comboBox.addItem(null); // Añadir opción no seleccionable
            for (Jugador jugador : jugadores) {
                comboBox.addItem(jugador);
            }
        }
        isUpdating = false; // Permitir actualizaciones después del llenado inicial
    }

    private void listeners() {
        for (JComboBox<Jugador> comboBox : comboBoxes) {
            comboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!isUpdating) {
                        @SuppressWarnings("unchecked")
                        JComboBox<Jugador> source = (JComboBox<Jugador>) e.getSource();
                        if (source.getSelectedIndex() == 0) {
                            // Si se selecciona el primer elemento, restablecer la selección
                            source.setSelectedIndex(-1);
                        } else {
                            actualizarComboBoxes();
                            actualizarSeleccionadosOrden();
                        }
                    }
                }
            });
        }
    }

    private void actualizarComboBoxes() {
        isUpdating = true; // Evitar bucles infinitos
        ArrayList<Jugador> seleccionados = new ArrayList<>();
        for (JComboBox<Jugador> comboBox : comboBoxes) {
            Jugador seleccionado = (Jugador) comboBox.getSelectedItem();
            if (seleccionado != null) {
                seleccionados.add(seleccionado);
            }
        }

        for (JComboBox<Jugador> comboBox : comboBoxes) {
            Jugador seleccionadoActual = (Jugador) comboBox.getSelectedItem();
            comboBox.removeAllItems();
            comboBox.addItem(null); // Añadir opción no seleccionable
            for (Jugador jugador : jugadores) {
                if (!seleccionados.contains(jugador) || jugador.equals(seleccionadoActual)) {
                    comboBox.addItem(jugador);
                }
            }
            comboBox.setSelectedItem(seleccionadoActual);
        }
        isUpdating = false; // Permitir actualizaciones después de completar
    }

    private void actualizarSeleccionadosOrden() {
        seleccionadosOrden.clear();
        for (JComboBox<Jugador> comboBox : comboBoxes) {
            Jugador seleccionado = (Jugador) comboBox.getSelectedItem();
            if (seleccionado != null) {
                seleccionadosOrden.add(seleccionado);
            }
        }
        // Puedes imprimir la lista para verificar el orden de selección
        System.out.println("Orden de selección: " + seleccionadosOrden);
    }

    public ArrayList<Jugador> obtenerJugadoresSeleccionados() {
        ArrayList<Jugador> jugadoresSeleccionados = new ArrayList<>();
        for (JComboBox<Jugador> comboBox : comboBoxes) {
            Jugador jugadorSeleccionado = (Jugador) comboBox.getSelectedItem();
            if (jugadorSeleccionado != null) {
                jugadoresSeleccionados.add(jugadorSeleccionado);
            }
        }
        return jugadoresSeleccionados;
    }
    
}
