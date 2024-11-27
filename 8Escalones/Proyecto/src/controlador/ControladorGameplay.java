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
import Vista.GameplayAproximacion;


public class ControladorGameplay {
    private Ronda ronda;
    private Gameplay vista;
    private String rtaSelec;
    private int idJuego; // Agregado
    private ArrayList<Jugador> jugadores; // Agregado
    private Escalon escalon; // Agregado
    private String estado; // Agregado
    private ArrayList<Tematica> tematicasRestantes; 

    public ControladorGameplay(int idJuego, ArrayList<Jugador> jugadores,ArrayList<Tematica> tematicas) throws SQLException {
        this.vista = new Gameplay();
        
        this.idJuego = idJuego;
        this.jugadores = jugadores;
        this.tematicasRestantes = tematicas;
        // this.escalon = new Escalon(0, null, Tematica.obtenerTematica(1), jugadores, null);
        // this.ronda = new Ronda(this.idJuego,this.jugadores ,this.escalon);

        listeners_rtas();
        traerTematica();
        traerEscalon();
        this.vista.setVisible(true);

        iniciarRonda(jugadores);
    }
    
    private void traerEscalon(){
        vista.getjTextFieldEscalon().setText("ESCALON " +  this.idJuego);
    }


    

    public void iniciarRonda(ArrayList<Jugador> jugadores) throws SQLException {
        if (this.idJuego == 8) {
            this.vista.dispose();
            //sacar la tematica actual de la lista de tematicas restantes
            tematicasRestantes.remove(0);
            new ControladorGameplayFinal(idJuego, jugadores, escalon); //cambiar esto
        } else {
        if (!tematicasRestantes.isEmpty() && tematicasRestantes.get(0) != null) {
            inicializarPuntos();
            for (int i = 1; i <= 2; i++) {
                System.out.println("Iniciando ronda " + i + " del juego " + idJuego);
                vista.getjTextFieldRonda().setText("RONDA "+ i);
                realizarPreguntas(this.idJuego, this.jugadores);
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
        //realizar metodo para ver a que vista se lleva la partida siguiente, si a la de aproximacion o a la de escalon
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

    private void realizarPreguntas(int idjuego, ArrayList<Jugador> jugadores) throws SQLException {
        ArrayList<MultipleChoicePregunta> pregMult = MultipleChoicePregunta.obtenerPreguntasMC(idjuego);
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

    private void traerTematica() { //del array que entra busco el primer elemento para mostrae en la vist
        String tematica = Tematica.obtenerTematicas().get(0).getNombre();
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

    public void pasarVista(){
        new GameplayAproximacion().setVisible(true);

      //  ControladorGameplayAprox c = new ControladorGameplayAprox(obtenerJugadoresConMenorPuntaje());
        //se supone que aca le paso la lista al controlador de game aprox y ya entra ahi
    }

    public ArrayList<Jugador> obtenerJugadoresConMenorPuntaje() {
        ArrayList<Jugador> jugadores = this.jugadores;
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
        if (jugadoresConMenorPuntaje.isEmpty()){
        }
        return jugadoresConMenorPuntaje;
    }
    //metodo decidir que si la lista tiene un elemento pasa a la vista de escalon y si no a la de aproximacion
    public void decidirVista(){
        if (obtenerJugadoresConMenorPuntaje().size() == 1){ //queda un jugador solo ese jugador queda eliminado y se saca de el arraylist jugadores
            Jugador jugadorEliminado = obtenerJugadoresConMenorPuntaje().get(0);
            jugadores.remove(jugadorEliminado);
            try {
                this.vista.dispose();
                //elimino la tematica actual de la lista de tematicas restantes
                tematicasRestantes.remove(0);
                new ControladorGameplay(idJuego + 1, jugadores, tematicasRestantes);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                this.vista.dispose();
                //elimino la tematica actual de la lista de tematicas restantes
                tematicasRestantes.remove(0);
                new ControladorGameplayAproximacion(idJuego,obtenerJugadoresConMenorPuntaje(),jugadores,tematicasRestantes);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
