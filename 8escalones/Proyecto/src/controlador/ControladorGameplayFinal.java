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
    }

    public void jugarEscalonFinal() throws SQLException {
        //System.out.println("¡¡Bienvenidos al Escalon Final!!");
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
            //jugador = Jugador.obtenerJugador(jugador.getId());
            //vista.getjTextFieldJugador().setText(jugador.getNombre());  ESTO LO NECESITAMOS CON LA VISTA NUEVA
            MultipleChoicePregunta pregunta = preguntas.get(new Random().nextInt(preguntas.size()));
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
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            preguntas.remove(pregunta);
        }
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