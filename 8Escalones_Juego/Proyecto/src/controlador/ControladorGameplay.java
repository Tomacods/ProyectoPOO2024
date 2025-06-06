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
import Vista.Gameplay;
//import Vista.GameplayAproximacion;


/**
 * ControladorGameplay es el controlador principal para la lógica del juego de preguntas y respuestas
 * basado en rondas y temáticas. Gestiona la interacción entre la vista Gameplay y los modelos de Jugador,
 * Tematica y Pregunta, controlando el flujo del juego, la selección de preguntas, el manejo de puntajes,
 * la eliminación de jugadores y la transición entre diferentes etapas del juego.
 *
 * Funcionalidades principales:
 * <ul>
 *   <li>Inicializa la vista y los datos del juego (jugadores, temáticas, identificador de juego).</li>
 *   <li>Gestiona el ciclo de rondas, mostrando preguntas a los jugadores y evaluando sus respuestas.</li>
 *   <li>Actualiza y muestra los puntajes de los jugadores tras cada ronda.</li>
 *   <li>Determina qué jugadores continúan o son eliminados según su desempeño.</li>
 *   <li>Controla la transición entre vistas según el estado del juego (escalón, aproximación, final).</li>
 *   <li>Administra la selección aleatoria de temáticas y preguntas.</li>
 *   <li>Implementa listeners para la captura de respuestas desde la interfaz gráfica.</li>
 * </ul>
 *
 * Dependencias:
 * <ul>
 *   <li>Gameplay (vista principal del juego)</li>
 *   <li>Jugador, Tematica, MultipleChoicePregunta, Respuesta (modelos de datos)</li>
 *   <li>Controladores auxiliares: ControladorGameplayFinal, ControladorSiguienteEscalon, ControladorGameplayAproximacion</li>
 * </ul>
 *
 * Nota: Este controlador asume que la vista y los modelos están correctamente implementados y conectados.
 *
 * @author (Tu Nombre)
 * @version 1.0
 */
public class ControladorGameplay {
   // private Ronda ronda;
    private Gameplay vista;
    private String rtaSelec;
    private int idJuego; // Agregado
    private ArrayList<Jugador> jugadores; // Agregado
    //private Escalon escalon; // Agregado
    private ArrayList<Tematica> tematicasRestantes; 
    //private String estado; // Agregado
    private Tematica tematica;

    public ControladorGameplay(int idJuego, ArrayList<Jugador> jugadores,ArrayList<Tematica> tematicas) throws SQLException {
        this.vista = new Gameplay();
        
        this.idJuego = idJuego;
        this.jugadores = jugadores;
        this.tematicasRestantes = tematicas;
        this.tematica = traerTematicaoObj();
        // this.escalon = new Escalon(0, null, Tematica.obtenerTematica(1), jugadores, null);
        // this.ronda = new Ronda(this.idJuego,this.jugadores ,this.escalon);

        listeners_rtas();
        //traerTematica();
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
            new ControladorGameplayFinal(jugadores, tematicasRestantes); //cambiar esto
        } else {
            if (!tematicasRestantes.isEmpty() && tematicasRestantes.get(0) != null) {
                inicializarPuntos();
                for (int i = 1; i <= 2; i++) {
                    System.out.println("Iniciando ronda " + i + " del juego " + idJuego);
                    vista.getjTextFieldRonda().setText("RONDA "+ i);
                    //Tematica tematica = traerTematicaoObj();
                    realizarPreguntas(tematica, this.jugadores);
                    // Al finalizar las 2 rondas, imprime el puntaje final de cada jugador
                    
                }
                imprimirPuntajes();
                decidirVista();
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

    /* public void inicializarPuntos() {
        // ArrayList<Jugador> jugadores = Jugador.obtenerJugadores();
        for (Jugador jug : jugadores) {
            jug.setPuntaje(0);
        }
    } */

    private void realizarPreguntas(Tematica tematica, ArrayList<Jugador> jugadores) throws SQLException {
        ArrayList<MultipleChoicePregunta> pregMult = MultipleChoicePregunta.obtenerPreguntasMC(tematica.getId());
        // ArrayList<Jugador> jugadores = Jugador.obtenerJugadores();
        vista.getjTextFieldTematica().setText(tematica.getNombre());//poner el nombre tematica
        for (Jugador jugador : jugadores) {
            //jugador = Jugador.obtenerJugador(jugador.getId());7
            
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
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            pregMult.remove(pregunta);
        }
    }

    private void inicializarPuntos() {
        for (Jugador jug: jugadores) {
            jug.setPuntaje(0);
        }
    }

    private Tematica traerTematicaoObj(){
        //ArrayList<Tematica> tematicas = Tematica.obtenerTematicas();
        Tematica tematica = tematicasRestantes.get(new Random().nextInt(tematicasRestantes.size()));
        return tematica;
    }
    
    /* private void traerTematica() { //del array que entra busco el primer elemento para mostrae en la vist
        ArrayList<Tematica> tematicas = Tematica.obtenerTematicas();
        Tematica tematica = tematicas.get(new Random().nextInt(tematicas.size()));
        vista.getjTextFieldTematica().setText(tematica.getNombre());
    } */

    private Jugador preguntarJugador(Jugador jugador, MultipleChoicePregunta pregunta) throws SQLException {
        Integer idRtaCorrecta = Respuesta.obtenerIdRtaCorrectaMC(pregunta.getIdPregunta());
        if (idRtaCorrecta != -1) {
            String respuestaCorrecta = Respuesta.obtenerRespuesta(idRtaCorrecta).getTexto();
            if (rtaSelec != null && rtaSelec.equals(respuestaCorrecta)) {
                System.out.println("Correcto");
                jugador.incrementarPuntaje();
                ventanaRta("CORRECTA \n (" + jugador.getPuntaje() + "/2) preguntas acertadas", jugador);
                System.out.println("si" + " " + jugador.getPuntaje());
            } else {
                System.out.println("Incorrecto");
                ventanaRta("INCORRECTA \n (" + jugador.getPuntaje() + "/2) preguntas acertadas", jugador);
            }
        } else {
            System.out.println("No se ha seleccionado ninguna respuesta.");
        }
        return jugador;
    }

    private void ventanaRta(String rta, Jugador jugador) {
        javax.swing.JOptionPane panel = new javax.swing.JOptionPane(rta, javax.swing.JOptionPane.INFORMATION_MESSAGE);
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
    public void decidirVista() throws SQLException{
        if (obtenerJugadoresConMenorPuntaje().size() == 1){ //queda un jugador solo ese jugador queda eliminado y se saca de el arraylist jugadores
            Jugador jugadorEliminado = obtenerJugadoresConMenorPuntaje().get(0);
            jugadores.remove(jugadorEliminado);
            this.vista.dispose();
            //elimino la tematica actual de la lista de tematicas restantes
            tematicasRestantes.remove(tematica);
            new ControladorSiguienteEscalon(idJuego, jugadores, jugadorEliminado, tematicasRestantes);
          //  new ControladorGameplay(idJuego + 1, jugadores, tematicasRestantes);
        }
        else{
            try {
                this.vista.dispose();
                //elimino la tematica actual de la lista de tematicas restantes
                tematicasRestantes.remove(tematica);
                new ControladorGameplayAproximacion(idJuego,obtenerJugadoresConMenorPuntaje(),jugadores,tematicasRestantes,tematica);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
