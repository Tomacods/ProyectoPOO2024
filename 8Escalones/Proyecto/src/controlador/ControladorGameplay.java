package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import Modelos.Jugador;

import Modelos.MultipleChoicePregunta;
import Modelos.Respuesta;
import Modelos.Tematica;
import Vista.Gameplay;

public class ControladorGameplay {
    private Gameplay vista;
    private String rtaSelec;

    public ControladorGameplay() throws SQLException {
        this.vista = new Gameplay();
        vista.setVisible(true);

        listeners_rtas();
        traerTematica();
        realizarPreguntas(3); // no se donde sale ese id

    }

/*     public void iniciarRonda() throws SQLException {
        inicializarPuntos();
        for (int i = 1; i <= 2; i++) {
            System.out.println("Iniciando ronda " + i + " del juego " + idJuego);
            realizarPreguntas(this.escalon.getTematica().getId(), jugadores);
        }
        Boolean empate = determinarResultado();
        if (empate == false) {
            this.estado = "finalizado";
        } else {
            desempatar(this.escalon.getTematica().getId(), empate);// Controlador Pregunta Aproximacion
        }
    }

    private void inicializarPuntos() {
        for (Jugador jug : jugadores) {
            jug.setPuntaje(0);
        }
    } */

    private void realizarPreguntas(int idEscalon) throws SQLException {
        ArrayList<MultipleChoicePregunta> pregMult = MultipleChoicePregunta.obtenerPreguntasMC(idEscalon);
        ArrayList<Jugador> jugadores = Jugador.obtenerJugadores();

        for (Jugador jugador : jugadores) {
            jugador = Jugador.obtenerJugador(jugador.getId());
            vista.getjLabelJugador().setText(jugador.getNombre());
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
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            pregMult.remove(pregunta);
        }
    }

    private void traerTematica() {

        String tematica = Tematica.obtenerTematica(1).getNombre();
        vista.getjTextFieldTurnoActual().setText(tematica);
    }

    private Jugador preguntarJugador(Jugador jugador, MultipleChoicePregunta pregunta) throws SQLException {

        Integer idRtaCorrecta = Respuesta.obtenerIdRtaCorrectaMC(pregunta.getIdPregunta());
        if (idRtaCorrecta != -1) {
            String respuestaCorrecta = Respuesta.obtenerRespuesta(idRtaCorrecta).getTexto();
            if (rtaSelec.equals(respuestaCorrecta)) {
                System.out.println("Correcto");
                jugador.incrementarPuntaje();
            } else {
                System.out.println("incorrecto");
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
                // System.out.println("A presionado");
                rtaSelec = vista.getjButtonRtaA().getText();
            }
        });

        this.vista.getjButtonRtaB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println(" B presionado");
                rtaSelec = vista.getjButtonRtaB().getText();
            }
        });

        this.vista.getjButtonRtaC().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("C presionado");
                rtaSelec = vista.getjButtonRtaC().getText(); // Actualizamos la respuesta seleccionada
            }
        });

        this.vista.getjButtonRtaD().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("D presionado");
                rtaSelec = vista.getjButtonRtaD().getText(); // Actualizamos la respuesta seleccionada
            }
        });
    }

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
    private void traerRespuestas(int idPregunta) throws SQLException {
        ArrayList<Respuesta> respuestas = Respuesta.obtenerRespuestasPorPregunta(idPregunta);
        if (respuestas.size() >= 4) { // Asegúrate de tener al menos 4 respuestas
            vista.getjButtonRtaA().setText(respuestas.get(0).getTexto());
            vista.getjButtonRtaB().setText(respuestas.get(1).getTexto());
            vista.getjButtonRtaC().setText(respuestas.get(2).getTexto());
            vista.getjButtonRtaD().setText(respuestas.get(3).getTexto());
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
    public static void main(String[] args) throws SQLException {
        new ControladorGameplay();
    }
}