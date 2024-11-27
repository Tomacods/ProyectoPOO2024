package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import Modelos.Escalon;
import Modelos.Jugador;

import Modelos.MultipleChoicePregunta;
import Modelos.Respuesta;
import Modelos.Ronda;
import Modelos.Tematica;
import Vista.Gameplay;

public class ControladorGameplay {
    private Ronda ronda;
    private Gameplay vista;
    private String rtaSelec;
    private int idJuego; // Agregado
    private ArrayList<Jugador> jugadores; // Agregado
    private Escalon escalon; // Agregado
    private String estado; // Agregado

    public ControladorGameplay(int idJuego, ArrayList<Jugador> jugadores, Escalon escalon) throws SQLException {
        this.idJuego = idJuego;
        this.jugadores = jugadores;
        this.escalon = escalon;
        this.vista = new Gameplay();
        this.ronda = new Ronda(idJuego, jugadores, escalon);

        // Reiniciar puntajes al comenzar un nuevo juego
        // inicializarPuntos(this.jugadores);

        vista.setVisible(true);

        listeners_rtas();
        traerTematica();
        iniciarRonda(jugadores);
    }

    public void iniciarRonda(ArrayList<Jugador> jugadores) throws SQLException {
        if (escalon.getTematica() != null) {
            inicializarPuntos();
            for (int i = 1; i <= 2; i++) {
                System.out.println("Iniciando ronda " + i + " del juego " + idJuego);
                vista.getjTextFieldRonda().setText("RONDA "+ i);
                realizarPreguntas(escalon.getTematica().getId(), jugadores);
                imprimirPuntajes();
            }
            // Al finalizar las 2 rondas, imprime el puntaje final de cada jugador
            System.out.println("\nPuntajes finales:");
            for (Jugador jugador : jugadores) {
                System.out.println(jugador.getNombre() + ": " + jugador.getPuntaje() + " puntos");
            }
        } else {
            System.out.println("Error: La temática es null.");
        }
    }

    public void imprimirPuntajes() {
        System.out.println("\nPuntajes finales:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + ": " + jugador.getPuntaje() + " puntos");
        }
    }

    public void inicializarPuntos() {
        // ArrayList<Jugador> jugadores = Jugador.obtenerJugadores();
        for (Jugador jug : jugadores) {
            jug.setPuntaje(0);
        }
    }

    private void realizarPreguntas(int idEscalon, ArrayList<Jugador> jugadores) throws SQLException {
        ArrayList<MultipleChoicePregunta> pregMult = MultipleChoicePregunta.obtenerPreguntasMC(idEscalon);
        // ArrayList<Jugador> jugadores = Jugador.obtenerJugadores();
        for (Jugador jugador : jugadores) {
            //jugador = Jugador.obtenerJugador(jugador.getId());
            vista.getjTextFieldJugador().setText(jugador.getNombre());
            MultipleChoicePregunta pregunta = pregMult.get(new Random().nextInt(pregMult.size()));
            // Limpiar la respuesta seleccionada antes de la nueva pregunta
            rtaSelec = null;
            vista.getjTextFieldPregunta().setText(pregunta.getEnunciado());
            traerRespuestas(pregunta.getIdPregunta());
            System.out.println("Pregunta para " + jugador.getNombre() + ": " + pregunta.getEnunciado());
            boolean respuestaSeleccionada = false;
            while (!respuestaSeleccionada) {
                if (rtaSelec != null && !rtaSelec.isEmpty()) {
                    jugador = preguntarJugador(jugador, pregunta);
                    respuestaSeleccionada = true;
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            pregMult.remove(pregunta);
        }
    }

    private void traerTematica() {
        String tematica = Tematica.obtenerTematica(1).getNombre();
        vista.getjTextFieldTematica().setText(tematica);
    }

    private Jugador preguntarJugador(Jugador jugador, MultipleChoicePregunta pregunta) throws SQLException {
        Integer idRtaCorrecta = Respuesta.obtenerIdRtaCorrectaMC(pregunta.getIdPregunta());
        if (idRtaCorrecta != -1) {
            String respuestaCorrecta = Respuesta.obtenerRespuesta(idRtaCorrecta).getTexto();
            if (rtaSelec != null && rtaSelec.equals(respuestaCorrecta)) {
                System.out.println("Correcto");
                jugador.incrementarPuntaje();
                System.out.println("si" + " " + jugador.getPuntaje());
            } else {
                System.out.println("Incorrecto");
            }
        } else {
            System.out.println("No se ha seleccionado ninguna respuesta.");
        }
        return jugador;
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
        if (respuestas.size() >= 4) {
            vista.getjButtonRtaA().setText(respuestas.get(0).getTexto());
            vista.getjButtonRtaB().setText(respuestas.get(1).getTexto());
            vista.getjButtonRtaC().setText(respuestas.get(2).getTexto());
            vista.getjButtonRtaD().setText(respuestas.get(3).getTexto());
        }
    }

    public ArrayList<Jugador> obtenerJugadoresConMenorPuntaje() {

        ArrayList<Jugador> jugadores = this.jugadores;

        if (jugadores.isEmpty()) {
            return new ArrayList<>();
        }

        int menorPuntaje = jugadores.get(1).getPuntaje();
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntaje() < menorPuntaje) {
                menorPuntaje = jugador.getPuntaje();
            }
        }

        ArrayList<Jugador> jugadoresConMenorPuntaje = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntaje() == menorPuntaje) {
                jugadoresConMenorPuntaje.add(jugador);
            }
        }

        return jugadoresConMenorPuntaje;
    }

    public static void main(String[] args) throws SQLException {

        Tematica tematica = Tematica.obtenerTematica(4);
        ArrayList<Jugador> jugadores = Jugador.obtenerJugadores();
        Escalon esc = new Escalon(0, null, tematica, jugadores, null);
        ControladorGameplay c = new ControladorGameplay(1, jugadores, esc);
        jugadores = c.obtenerJugadoresConMenorPuntaje();

        
        ArrayList<Jugador> jugadoresConMenorPuntaje = c.obtenerJugadoresConMenorPuntaje();
        System.out.println("Jugadores con el menor puntaje:");
        for (Jugador jugador : jugadores) {
        System.out.println("Nombre: " + jugador.getNombre() + ", Puntaje: " +
        jugador.getPuntaje() + " puntos");
        }
        
    }
}


/*
 * private void realizarPreguntas(int idEscalon) throws SQLException {
 * ArrayList<MultipleChoicePregunta> pregMult = new ArrayList<>();
 * pregMult = MultipleChoicePregunta.obtenerPreguntasMC(idEscalon);//Trae las
 * preguntas MC de la BD
 * ArrayList<Jugador>jugadores = Jugador.obtenerJugadores();
 * for (Jugador jugador : jugadores) {
 * String pregunta = pregMult.get(new
 * Random().nextInt(pregMult.size())).getEnunciado();
 * // MultipleChoicePregunta pregunta = pregMult.get(new
 * Random().nextInt(pregMult.size()));
 * //String preguntaStr =
 * MultipleChoicePregunta.obtenerPreguntaMC(2).getEnunciado();
 * int id_pregunta =
 * MultipleChoicePregunta.obtenerPreguntaMC(2).getIdPregunta();
 * vista.getjTextFieldPregunta().setText(pregunta);
 * traerRespuestas(id_pregunta);
 * 
 * System.out.println("Pregunta para " + jugador.getNombre() + ": "+"\n" +
 * pregunta.getEnunciado());
 * jugador = preguntarJugador(jugador, pregunta);
 * pregMult.remove(pregunta);
 * }
 * }
 */
// private Jugador preguntarJugador(Jugador jugador, MultipleChoicePregunta
// pregunta){
// pregunta.imprimirOpciones();

/*
 * String respuesta = "Opción A"; // Se conectaria con el controlador para
 * obtener la respuesta
 * if (pregunta.getRespuestaCorrecta() == respuesta) {
 * System.out.println("Respuesta correcta");
 * jugador.incrementarPuntaje();
 * } else {
 * System.out.println("Respuesta incorrecta");
 * }
 * return jugador;
 * }
 */
/*
 * private Jugador preguntarJugador(Jugador jugador, MultipleChoicePregunta
 * pregunta){
 * // pregunta.imprimirOpciones();
 * 
 * String respuesta = "Opción A"; // Se conectaria con el controlador para
 * obtener la respuesta
 * if (pregunta.getRespuestaCorrecta() == respuesta) {
 * System.out.println("Respuesta correcta");
 * jugador.incrementarPuntaje();
 * } else {
 * System.out.println("Respuesta incorrecta");
 * }
 * return jugador;
 * }
 */

/*
 * private void traerRespuestas(int id_pregunta) throws SQLException {
 * ArrayList<Respuesta> respuestas =
 * Respuesta.obtenerRespuestasPorPregunta(id_pregunta);
 * vista.getjButtonRtaA().setText(respuestas.get(0).getTexto());
 * vista.getjButtonRtaB().setText(respuestas.get(1).getTexto());
 * vista.getjButtonRtaC().setText(respuestas.get(2).getTexto());
 * vista.getjButtonRtaD().setText(respuestas.get(3).getTexto());
 * }
 */
/*
 * private void realizarPreguntas(int idEscalon) throws SQLException {
 * 
 * ArrayList<MultipleChoicePregunta> pregMult =
 * MultipleChoicePregunta.obtenerPreguntasMC(idEscalon);
 * ArrayList<Jugador> jugadores = Jugador.obtenerJugadores();
 * 
 * for (Jugador jugador : jugadores) {
 * jugador = Jugador.obtenerJugador(jugador.getId());
 * vista.getjLabelJugador().setText(jugador.getNombre());
 * MultipleChoicePregunta pregunta = pregMult.get(new
 * Random().nextInt(pregMult.size()));
 * 
 * vista.getjTextFieldPregunta().setText(pregunta.getEnunciado());
 * 
 * traerRespuestas(pregunta.getIdPregunta());
 * 
 * System.out.println("Pregunta para " + jugador.getNombre() + ": " +
 * pregunta.getEnunciado());
 * 
 * jugador = preguntarJugador(jugador, pregunta);
 * 
 * 
 * pregMult.remove(pregunta);
 * }
 * }
 * 
 * private Jugador preguntarJugador(Jugador jugador, MultipleChoicePregunta
 * pregunta) throws SQLException {
 * System.out.println("Respuesta seleccionada por el jugador: " + rtaSelec); //
 * Depuración
 * 
 * Integer idRtaCorrecta =
 * Respuesta.obtenerIdRtaCorrectaMC(pregunta.getIdPregunta());
 * if (idRtaCorrecta != -1) {
 * String respuestaCorrecta =
 * Respuesta.obtenerRespuesta(idRtaCorrecta).getTexto();
 * if (rtaSelec.equals(respuestaCorrecta)) {
 * System.out.println("Respuesta correcta");
 * jugador.incrementarPuntaje();
 * } else {
 * System.out.println("Respuesta incorrecta");
 * }
 * } else {
 * System.out.println("No se encontró una respuesta correcta.");
 * }
 * 
 * return jugador;
 * }
 * 
 * private void listeners_rtas(){
 * this.vista.getjButtonRtaA().addActionListener(new ActionListener() {
 * 
 * @Override
 * public void actionPerformed(ActionEvent e) {
 * rtaSelec= vista.getjButtonRtaA().getText();
 * }
 * });
 * this.vista.getjButtonRtaB().addActionListener(new ActionListener() {
 * 
 * @Override
 * public void actionPerformed(ActionEvent e) {
 * rtaSelec= vista.getjButtonRtaB().getText();
 * }
 * });
 * this.vista.getjButtonRtaC().addActionListener(new ActionListener() {
 * 
 * @Override
 * public void actionPerformed(ActionEvent e) {
 * rtaSelec= vista.getjButtonRtaC().getText();
 * }
 * });
 * this.vista.getjButtonRtaD().addActionListener(new ActionListener() {
 * 
 * @Override
 * public void actionPerformed(ActionEvent e) {
 * rtaSelec= vista.getjButtonRtaD().getText();
 * }
 * });
 * 
 * 
 * }
 */