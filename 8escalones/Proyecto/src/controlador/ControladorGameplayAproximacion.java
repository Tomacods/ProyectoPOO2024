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

public class ControladorGameplayAproximacion {
    private GameplayAproximacion vista;
    private ArrayList<Jugador> empatados;
    private ArrayList<Jugador> siguenJugando;
    private Integer rtaIngresada;

    // lista jugadores, escalones, tematica

    public ControladorGameplayAproximacion(ArrayList<Jugador> jugadores) throws SQLException {
        this.vista = new GameplayAproximacion();
        this.empatados = jugadores;
        this.siguenJugando = jugadores;
        this.vista.setVisible(true);
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
        traerTematica();
        // listener();
        desempatar(3);
    }

    private void salirDelJuego() {
        System.exit(0);
    }

    private void traerTematica() {
        String tematica = Tematica.obtenerTematica(1).getNombre();
        vista.getTematica().setText(tematica);
    }

    private void listener() {
        this.vista.getBoton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // String rtaSelec = vista.getResultadoAprox().getText();
                rtaIngresada = vista.getRtaIngresada(); 
            }
        });
    }

    public Boolean determinarResultado() throws SQLException {
        // Lógica para determinar el resultado de la ronda
        // Por ejemplo, eliminar al jugador con menos puntaje
        // ESTE CODIGO DEBE UTILIZARSE EN EL CONTROLADOR GAMEPLAY EN CONTROLADOR
        // GAMEPLAY_APROXIMACION
        Jugador jugadorMenorPuntaje = empatados.get(1);
        Boolean empate;
        for (Jugador jugador : empatados) {
            if (jugador.getPuntaje() < jugadorMenorPuntaje.getPuntaje()) {
                jugadorMenorPuntaje = jugador;
            }
        }
        for (Jugador jugador : empatados) {
            if (jugadorMenorPuntaje.getPuntaje() == jugador.getPuntaje()) {
                addEmpatados(jugador);
            }
        }
        if (empatados.size() == 1) {
            eliminarJugador(empatados.get(0));
            empate = false;
            return empate;// Llevaria al Controlador de Siguiente Escalon
        } else {
            empate = true;
            return empate;// Llevaria al controlador de Gameplay_Aproximacion
            // desempatar(this.escalon.getTematica().getId());
        }
    }

    public void desempatar(int idEscalon) throws SQLException {
        inicializarPuntos();
        ArrayList<PreguntaAproximacion> pregAprox = new ArrayList<>();
        pregAprox = PreguntaAproximacion.obtenerPreguntasAproximacionTematica(idEscalon);
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
            int peorRta = 0;
            for (Jugador jugador : empatados) {// Conseguis el peor puntaje
                jugador.setPuntaje(((valorAbsoluto(PreguntaAproximacion.obtenerValorAproximado(pregunta.getIdPregunta())) - valorAbsoluto(jugador.getPuntaje()))));
                if (jugador.getPuntaje() > peorRta) { //pregunta.obtenerValorAproximado(pregunta.getIdPregunta()) //creo q va ese arriba en el parentresis
                    /* removeEmpatado(empatados.get(j)); */
                    peorRta = jugador.getPuntaje();
                }
            }
            Iterator<Jugador> iter = empatados.iterator();
            while (iter.hasNext()) {
                Jugador jugador = iter.next();
                if (jugador.getPuntaje() != peorRta) { // Condición para remover
                    iter.remove(); // Elimina el jugador de forma segura
                }
            }
            
            if (empatados.size() == 1) {// Si hay mas de un jugador con el peor puntaje, no entra aca
                eliminarJugador(empatados.get(0));
                eliminado = false;
            }
            
            pregAprox.remove(pregunta);
        }
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
        System.out.println("Jugador eliminado: " + jugador.getNombre());
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
    
    
    public void siguienteEscalon() {
        System.out.println("Jugadores que quedan:");
                for (Jugador jugador: siguenJugando) {
                    System.out.println(jugador.getNombre());
                }
       // new ControladorGameplay(idjuego,obtenerListaSinEliminados() , escalon)
        
    }

    public static void main(String[] args) throws SQLException {
        new ControladorGameplayAproximacion(Jugador.obtenerJugadores());
    }

}