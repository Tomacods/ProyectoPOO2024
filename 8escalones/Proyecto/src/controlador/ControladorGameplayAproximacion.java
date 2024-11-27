package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.Timer;

import Modelos.Tematica;
import Modelos.Jugador;
import Modelos.PreguntaAproximacion;
import Vista.GameplayAproximacion;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//import java.lang.reflect.Array;
//import Modelos.Tematica;


public class ControladorGameplayAproximacion {
    private GameplayAproximacion vista;
    private ArrayList<Jugador> empatados;
    private ArrayList<Jugador> siguenJugando;
    private Integer rtaIngresada;
    private int idJuego;
    private ArrayList<Tematica> tematicasRestantes;
    private Tematica tematicaRonda;
    private Jugador jugadorEliminado;

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

    /* private int traerIdTematica(String tematica) {
        ArrayList<Tematica> tematicas = Tematica.obtenerTematicas();
        int id = 0;
        for (Tematica tem: tematicas) {
            if (tem.getNombre() == tematica) {
                id = tem.getId();
            }
        }
        return id;
    } */

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
                vista.resetRtaIngresada();
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
                vista.getBoton().setText("Respuesta");
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
                jugadorEliminado= empatados.get(0);
                eliminarJugador(empatados.get(0), valorCorrecto);
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

    private void eliminarJugador(Jugador jugador, int valorCorrecto) {
        empatados.remove(jugador);
        siguenJugando.remove(jugador);
        jugador.setEstado("Eliminado");
        System.out.println("Jugador eliminado: " + jugador.getNombre());//ACA
        ventanaJugadorEliminado(jugador, valorCorrecto);
    }

    private void ventanaJugadorEliminado(Jugador jugador, int valorCorrecto) {
        javax.swing.JOptionPane panel = new javax.swing.JOptionPane("El jugador " + jugador.getNombre() + " ha sido eliminado!\nLa respuesta correcta era: \n" + valorCorrecto, javax.swing.JOptionPane.INFORMATION_MESSAGE);
        javax.swing.JDialog cuadro = panel.createDialog("Jugador eliminado");
        Thread cerrar = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cuadro.dispose();
        });
        cerrar.start();
        cuadro.setVisible(true);
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
                this.vista.dispose();

                new ControladorSiguienteEscalon(idJuego, siguenJugando, jugadorEliminado, tematicasRestantes);

            
                    Timer timer = new Timer(10000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            vista.dispose(); 
                            try {
                                new ControladorGameplay(idJuego + 1, siguenJugando, tematicasRestantes);
                            } catch (SQLException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                            //mostrarMenuPrincipal();
                            
               
                        }
                    });
                    timer.setRepeats(false); // Solo se ejecuta una vez
                    timer.start(); 
        
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

