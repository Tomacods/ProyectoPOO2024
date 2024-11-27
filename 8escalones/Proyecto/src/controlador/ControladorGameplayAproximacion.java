package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import Modelos.Tematica;
import Modelos.Jugador;
import Modelos.PreguntaAproximacion;
import Vista.GameplayAproximacion;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import Modelos.Tematica;


public class ControladorGameplayAproximacion {
    private GameplayAproximacion vista;
    private ArrayList<Jugador> empatados;
    private ArrayList<Jugador> siguenJugando;
    private Integer rtaIngresada;
    private int idJuego;
    private ArrayList<Tematica> tematicasRestantes;
    private Tematica tematicaRonda;

    // lista jugadores, escalones, tematica

    public ControladorGameplayAproximacion(int idJuego,ArrayList<Jugador> empatados,ArrayList<Jugador> jugadores,ArrayList<Tematica> tematicasRestantes, Tematica tematicaActual) throws SQLException {
        this.vista = new GameplayAproximacion();
        this.idJuego = idJuego;
        this.empatados = empatados; // este es el array de jugadores que empataron
        this.siguenJugando = jugadores; // este es el array de jugadores que siguen jugando
        this.tematicasRestantes = tematicasRestantes;
        this.vista.setVisible(true);
        this.tematicaRonda = tematicaActual;


        this.vista.jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salirDelJuego();
            }
        });
        this.vista.jTextFieldRespuestaAprox.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e) {
                char c =e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        listener();
        traerNombreTematica();
        desempatar();
    }

    private void salirDelJuego() {
        System.exit(0);
    }

    private int traerIdTematica(String tematica) {
        ArrayList<Tematica> tematicas = Tematica.obtenerTematicas();
        int id = 0;
        for (Tematica tem: tematicas) {
            if (tem.getNombre() == tematica) {
                id = tem.getId();
            }
        }
        return id;
    }

    private void traerNombreTematica() {
        /* ArrayList<Tematica> tematicas = Tematica.obtenerTematicas();
        Tematica tematica = tematicas.get(new Random().nextInt(tematicas.size())); */
        vista.getTematica().setText(tematicaRonda.getNombre());
    }

    private void listener() {
        this.vista.getBoton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rtaIngresada = vista.getRtaIngresada();
                vista.getBoton().setText("");
            }
        });
    }

    public void desempatar() throws SQLException { //id juego es el id de la tematica actual
        inicializarPuntos();
        ArrayList<PreguntaAproximacion> pregAprox = new ArrayList<>();
        pregAprox = PreguntaAproximacion.obtenerPreguntasAproximacionTematica(tematicaRonda.getId());
        System.out.println("A continuación, ¡Evaluaremos el desempate!");
        Boolean eliminado = true;
        while (eliminado) {
            PreguntaAproximacion pregunta = pregAprox.get(new Random().nextInt(pregAprox.size()));
            vista.getjTextFieldPregunta().setText(pregunta.getEnunciado());
            System.out.println("Pregunta desempate " + ": " + "\n" + pregunta.getEnunciado());
            for (Jugador jugador : empatados) {// Responden jugador aproximacion
                System.out.println("Responde el jugador " + jugador.getNombre());
                vista.getjTextFieldJugador().setText(jugador.getNombre());
                rtaIngresada = null;
                boolean respuestaSeleccionada = false;
                while (!respuestaSeleccionada) {
                    if (rtaIngresada != null ) {
                        jugador = preguntarAproximacion(jugador, pregunta);
                        respuestaSeleccionada = true;
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Respondio "+ jugador.getPuntaje());
            }
            int valorCorrecto = PreguntaAproximacion.obtenerValorAproximado(pregunta.getIdPregunta());
            int peorDiferencia = Integer.MIN_VALUE;
            for (Jugador jugador : empatados) {// Conseguis el peor puntaje
                int diferencia = valorAbsoluto(valorCorrecto - jugador.getPuntaje());
                jugador.setPuntaje(diferencia);
                if (diferencia > peorDiferencia) {
                    peorDiferencia = diferencia;
                }
            }
            Iterator<Jugador> iter = empatados.iterator();
            while (iter.hasNext()) {
                Jugador jugador = iter.next();
                if (jugador.getPuntaje() != peorDiferencia) { // Condición para remover
                    
                    iter.remove(); // Elimina el jugador de forma segura
                    //siguenJugando.add(jugador);
                }
            }

            if (empatados.size() == 1) {// Si hay mas de un jugador con el peor puntaje, no entra aca
                eliminarJugador(empatados.get(0));
                eliminado = false;
            }
            pregAprox.remove(pregunta);
        }
        siguienteEscalon();
    }
    
    public Jugador preguntarAproximacion(Jugador jugador, PreguntaAproximacion pregunta) {
       // int rta = vista.getRtaIn;
        int rta= rtaIngresada;
        jugador.setPuntaje(rta); // Obtener de vista la respuesta ñam ñam
        return jugador;
    } 

    private int valorAbsoluto(int numero) {
        if (numero >= 0) {
            return numero;
        } else { 
            return (numero * -1);
        }
    }

    private void eliminarJugador(Jugador jugador) {
        empatados.remove(jugador);
        siguenJugando.remove(jugador);
        jugador.setEstado("Eliminado");
        System.out.println("Jugador eliminado: " + jugador.getNombre());//ACA
        javax.swing.JOptionPane.showMessageDialog(vista, "El jugador " + jugador.getNombre() + " ha sido eliminado!", "JUGADOR ELIMINADO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    private void inicializarPuntos() {
        for (Jugador jug : empatados) {
            jug.setPuntaje(0);
        }
    }

    public void addEmpatados(Jugador jugador) {
        empatados.add(jugador);
    }

    public void removeEmpatado(Jugador jugador) {
        empatados.remove(jugador);
    }
    public void siguienteEscalon() {
        System.out.println("Jugadores que quedan:");
                for (Jugador jugador: siguenJugando) {
                    System.out.println(jugador.getNombre());
                }
        try {
            this.vista.dispose();
            new ControladorGameplay(idJuego + 1, siguenJugando, tematicasRestantes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
     //tengo q devolver la lista sin el jugador eliminado
    // private ArrayList<Jugador> obtenerListaSinEliminados() {
    //     ArrayList<Jugador> listaSinEliminados = new ArrayList<>();
    //     for (Jugador jugador : empatados) {
    //         if (!"Eliminado".equals(jugador.getEstado())) {
    //             listaSinEliminados.add(jugador);
    //         }
    //     }
    //     return listaSinEliminados;
    //}

    // public static void main(String[] args) throws SQLException {
    //     new ControladorGameplayAproximacion(Jugador.obtenerJugadores());
    // }

