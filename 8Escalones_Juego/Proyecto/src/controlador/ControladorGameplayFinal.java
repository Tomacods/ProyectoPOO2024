package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
//import Modelos.Escalon;
import Modelos.Jugador;
import Modelos.MultipleChoicePregunta;
import Modelos.Respuesta;
//import Modelos.Ronda;
import Modelos.Tematica;
//import Modelos.Juego;
import Vista.Gameplay_final;

/**
 * ControladorGameplayFinal es el controlador encargado de gestionar la lógica del escalón final
 * del juego "8 Escalones". Se encarga de coordinar la interacción entre la vista (Gameplay_final)
 * y el modelo (jugadores, preguntas y respuestas), así como de manejar la lógica de preguntas,
 * respuestas, puntajes y determinación del ganador.
 *
 * Funcionalidades principales:
 * <ul>
 *   <li>Inicializa la vista y los jugadores participantes en la ronda final.</li>
 *   <li>Asigna los nombres de los jugadores a la interfaz gráfica.</li>
 *   <li>Gestiona los listeners de los botones de respuesta para capturar la selección del usuario.</li>
 *   <li>Obtiene y muestra las respuestas posibles para cada pregunta de opción múltiple.</li>
 *   <li>Realiza la ronda final, presentando preguntas a cada jugador y actualizando los puntajes.</li>
 *   <li>Determina el ganador cuando la diferencia de puntaje es suficiente o en caso de empate, continúa hasta desempatar.</li>
 *   <li>Muestra ventanas emergentes indicando si la respuesta fue correcta o incorrecta y los puntajes actuales.</li>
 * </ul>
 *
 * Dependencias:
 * <ul>
 *   <li>Gameplay_final: Vista gráfica del juego.</li>
 *   <li>Jugador: Modelo que representa a los jugadores.</li>
 *   <li>MultipleChoicePregunta y Respuesta: Modelos para preguntas y respuestas de opción múltiple.</li>
 *   <li>ControladorGanador: Controlador para la pantalla de ganador.</li>
 * </ul>
 *
 * Nota: Este controlador asume que siempre hay dos jugadores en la ronda final.
 *
 * @author (Tu Nombre)
 * @version 1.0
 */
public class ControladorGameplayFinal {
    private Gameplay_final vista;
    private String rtaSelec;
    //private int idJuego; // Agregado
    private ArrayList<Jugador> jugadores; // Agregado
    //private Escalon escalon; // Agregado



    public ControladorGameplayFinal(/* int idJuego, */ ArrayList<Jugador> jugadores, ArrayList<Tematica> tematicas) throws SQLException {
        /* this.idJuego = idJuego;  */
        this.jugadores = jugadores; 
        this.vista = new Gameplay_final();
       // this.ronda = new Ronda(idJuego, jugadores, escalon);
        vista.setVisible(true);
        traerJugador();
        listeners_rtas();
        jugarEscalonFinal();
    }
    private void traerJugador(){
        this.vista.getJugador1().setText((jugadores.get(0)).getNombre());
        this.vista.getJugador2().setText((jugadores.get(1)).getNombre());
    }
    private void listeners_rtas() {
        this.vista.getjButtonRtaA().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rtaSelec = vista.getjButtonRtaA().getText();
            }
        });

        this.vista.getjButtonRtaB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                rtaSelec = vista.getjButtonRtaB().getText();
            }
        });

        this.vista.getjButtonRtaC().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                rtaSelec = vista.getjButtonRtaC().getText();
            }
        });

        this.vista.getjButtonRtaD().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rtaSelec = vista.getjButtonRtaD().getText();
            }
        });
    }

    private void traerRespuestas(int idPregunta) throws SQLException {
        ArrayList<Respuesta> respuestas = Respuesta.obtenerRespuestasPorPregunta(idPregunta);
        Collections.shuffle(respuestas);
        if (respuestas.size() >= 4) {
            vista.getjButtonRtaA().setText(respuestas.get(0).getTexto());
            vista.getjButtonRtaB().setText(respuestas.get(1).getTexto());
            vista.getjButtonRtaC().setText(respuestas.get(2).getTexto());
            vista.getjButtonRtaD().setText(respuestas.get(3).getTexto());
        }
    }

    public void jugarEscalonFinal() throws SQLException {
        //System.out.println("¡¡Bienvenidos al Escalon Final!!");
        ArrayList<MultipleChoicePregunta> preguntas = MultipleChoicePregunta.obtenerTodasPreguntasMC(); 
        java.util.Collections.shuffle(preguntas);
        Jugador jugadorGanador = rondaFinal(preguntas, jugadores);
        System.out.println("El ganador es " + jugadorGanador.getNombre());
        this.vista.dispose();
        new ControladorGanador(jugadorGanador);
    }

    public Jugador rondaFinal(ArrayList<MultipleChoicePregunta> preguntas, ArrayList<Jugador> jugadores) throws SQLException{
        inicializarPuntos();
        for (int i = 1; i<=5; i++){
            realizarPreguntas(preguntas, jugadores);
            if (valorAbsoluto(jugadores.get(0).getPuntaje() - jugadores.get(1).getPuntaje()) >= 3) {
                System.out.println("\n¡" + (jugadores.get(0).getPuntaje() > jugadores.get(1).getPuntaje() ? jugadores.get(0).getNombre() : jugadores.get(1).getNombre()) + " ES EL GANADOR DE LOS 8 ESCALONES!");
                break; // Salir del for
            }
        }
        if (jugadores.get(0).getPuntaje() == jugadores.get(1).getPuntaje()) {
            while (jugadores.get(0).getPuntaje() == jugadores.get(1).getPuntaje()) {
                realizarPreguntas(preguntas, jugadores);
            }
        }
        if (jugadores.get(0).getPuntaje() > jugadores.get(1).getPuntaje()) {
            return jugadores.get(0);//DEVUELVE SI GANO EL JUGADOR 0
        } else {
            return jugadores.get(1);//DEVUELVE SI GANO EL JUGADOR 1
        }
    }

    private void realizarPreguntas(ArrayList<MultipleChoicePregunta> preguntas, ArrayList<Jugador> jugadores) throws SQLException {
        for (Jugador jugador : jugadores) {
            MultipleChoicePregunta pregunta = preguntas.get(new Random().nextInt(preguntas.size()));
            rtaSelec = null;
            vista.getjTextFieldPregunta().setText(pregunta.getEnunciado());
            traerRespuestas(pregunta.getIdPregunta());
            System.out.println("Pregunta para " + jugador.getNombre() + ": " + pregunta.getEnunciado());
            boolean respuestaSeleccionada = false;
            while (!respuestaSeleccionada) {
                if (rtaSelec != null && !rtaSelec.isEmpty()) {
                    jugador = preguntarJugador(jugador, pregunta, jugadores); // Procesa la respuesta
                    respuestaSeleccionada = true;
                } else {
                    // Agrega un pequeño retardo para evitar un consumo excesivo de CPU
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            preguntas.remove(pregunta);
        }
    }

    private Jugador preguntarJugador(Jugador jugador, MultipleChoicePregunta pregunta, ArrayList<Jugador> jugadores) throws SQLException {
        Integer idRtaCorrecta = Respuesta.obtenerIdRtaCorrectaMC(pregunta.getIdPregunta());
        if (idRtaCorrecta != -1) {
            String rtaCorrecta = Respuesta.obtenerRespuesta(idRtaCorrecta).getTexto();
            if (rtaSelec != null && rtaSelec.equals(rtaCorrecta)) {
                System.out.println("Correcto");
                jugador.incrementarPuntaje();
                String puntos = "Puntos \n" + jugadores.get(0).getNombre() + ": " + jugadores.get(0).getPuntaje() + "\n" + jugadores.get(1).getNombre() + ": " + jugadores.get(1).getPuntaje();
                ventanaRta("CORRECTA", puntos);
                System.out.println("si" + " " + jugador.getPuntaje());
            } else {
                System.out.println("Incorrecto");
                String puntos = "Puntos \n" + jugadores.get(0).getNombre() + ": " + jugadores.get(0).getPuntaje() + "\n" + jugadores.get(1).getNombre() + ": " + jugadores.get(1).getPuntaje();
                ventanaRta("INCORRECTA", puntos);
            }
        } else {
            System.out.println("No se ha seleccionado ninguna respuesta.");
        }
        return jugador;
    }

    private void ventanaRta(String rta, String puntos) {
        javax.swing.JOptionPane panel = new javax.swing.JOptionPane(rta + "\n" + puntos, javax.swing.JOptionPane.INFORMATION_MESSAGE);
        javax.swing.JDialog cuadro = panel.createDialog("La respuesta es");
        Thread cerrar = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cuadro.dispose();
        });
        cerrar.start();
        cuadro.setVisible(true);
    }

    private void inicializarPuntos() {
        for (Jugador jug: jugadores) {
            jug.setPuntaje(0);
        }
    }

    private int valorAbsoluto(int numero){
        if (numero>=0){
            return numero;
        }else{
        return (numero*-1);
        }
    }
}