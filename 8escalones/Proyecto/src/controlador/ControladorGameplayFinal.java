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
import Modelos.Juego;
import Vista.Gameplay_final;

public class ControladorGameplayFinal {
    private Ronda ronda;
    private Gameplay_final vista;
    private String rtaSelec;
    private int idJuego; // Agregado
    private ArrayList<Jugador> jugadores; // Agregado
    private Escalon escalon; // Agregado
    private String estado; // Agregado

    public ControladorGameplayFinal(int idJuego, ArrayList<Jugador> jugadores, Escalon escalon) throws SQLException {
        this.idJuego = idJuego; 
        this.jugadores = jugadores; 
        this.escalon = escalon; 
        this.vista = new Gameplay_final();
        this.ronda = new Ronda(idJuego, jugadores, escalon);

        vista.setVisible(true);
        vista.setVisible(true);
        jugarEscalonFinal();
        /* listeners_rtas();
        traerTematica();
        iniciarRonda(); */
       // realizarPreguntas(3); // no se donde sale ese id
    }

    public void jugarEscalonFinal() throws SQLException {
        System.out.println("¡¡Bienvenidos al Escalon Final!!");
        ArrayList<MultipleChoicePregunta> preguntas = MultipleChoicePregunta.obtenerTodasPreguntasMC();
        Jugador jugadorGanador = rondaFinal(preguntas, jugadores);
        System.out.println("El ganador es " + jugadorGanador.getNombre());
    }

    public Jugador rondaFinal(ArrayList<MultipleChoicePregunta> preguntas, ArrayList<Jugador> jugadores) throws SQLException{
        inicializarPuntos();
        int pos = 0;
        for (int i = 1; i<=5; i++){
            realizarPreguntas(preguntas, jugadores);
            if (valorAbsoluto(jugadores.get(0).getPuntaje()) - valorAbsoluto(jugadores.get(1).getPuntaje()) >= 3) {
                System.out.println("\n¡" + (jugadores.get(0).getPuntaje() > jugadores.get(1).getPuntaje() ? jugadores.get(0).getNombre() : jugadores.get(1).getNombre()) + " ES EL GANADOR DE LOS 8 ESCALONES!");
                break; // Salir del for
            }
            pos = pos + 1;
        }
        if (jugadores.get(0).getPuntaje() == jugadores.get(1).getPuntaje()) {
            while (jugadores.get(0).getPuntaje() == jugadores.get(1).getPuntaje()) {
                realizarPreguntas(preguntas, jugadores);
                pos++;
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
            System.out.println("Pregunta para " + jugador.getNombre() + ": "+"\n" + pregunta.getEnunciado());
            jugador = preguntarJugador(jugador, pregunta);
            preguntas.remove(pregunta);
        }
    }

    public Jugador preguntarJugador(Jugador jugador, MultipleChoicePregunta pregunta) throws SQLException{
        pregunta.imprimirOpciones();
        String respuesta = "Opción A"; // Se conectaria con el controlador para obtener la respuesta
        ArrayList<Respuesta> respuestas = Respuesta.obtenerRespuestasPorPregunta(pregunta.getIdPregunta());
        Boolean correcta = respuestaCorrecta(respuestas, respuesta);
        if (correcta == true) {
            System.out.println("Respuesta correcta");
            jugador.incrementarPuntaje();
        } else {
            System.out.println("Respuesta incorrecta");
        }
        return jugador;
    }

    private Boolean respuestaCorrecta(ArrayList<Respuesta> respuestas, String resp) {
        Boolean correcta = false;
        for (Respuesta rta : respuestas) {
            if (rta.isEsCorrecta() == true) {
                if (rta.getTexto() == resp) {
                    correcta = true;
                }
            }
        }
        return correcta;
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

    /*private void realizarPreguntas(int idEscalon, ArrayList<Jugador> jugadores) throws SQLException {
        ArrayList<MultipleChoicePregunta> pregMult = MultipleChoicePregunta.obtenerPreguntasMC(idEscalon);
       // ArrayList<Jugador> jugadores = Jugador.obtenerJugadores();

        for (Jugador jugador : jugadores) {
            jugador = Jugador.obtenerJugador(jugador.getId());
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
        vista.getjTextFieldTematica().setText(tematica);
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


    private void traerRespuestas(int idPregunta) throws SQLException {
        ArrayList<Respuesta> respuestas = Respuesta.obtenerRespuestasPorPregunta(idPregunta);
        if (respuestas.size() >= 4) { // Asegúrate de tener al menos 4 respuestas
            vista.getjButtonRtaA().setText(respuestas.get(0).getTexto());
            vista.getjButtonRtaB().setText(respuestas.get(1).getTexto());
            vista.getjButtonRtaC().setText(respuestas.get(2).getTexto());
            vista.getjButtonRtaD().setText(respuestas.get(3).getTexto());
        }
    }


    public static void main(String[] args) throws SQLException {

        Tematica tematica = Tematica.obtenerTematica(4);  // Asegúrate de que este método devuelva un objeto Tematica válido

        Escalon esc = new Escalon(0, null, tematica, null, null);

            new ControladorGameplay(1, Jugador.obtenerJugadores(), esc);
        }
        
    } */

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