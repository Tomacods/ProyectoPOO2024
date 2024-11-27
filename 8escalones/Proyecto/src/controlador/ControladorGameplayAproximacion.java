package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import Modelos.Tematica;
import Modelos.Jugador;
import Modelos.PreguntaAproximacion;
import Vista.GameplayAproximacion;

public class ControladorGameplayAproximacion {
    private GameplayAproximacion vista;
    private ArrayList<Jugador>empatados;
    //lista jugadores, escalones, tematica 

    public ControladorGameplayAproximacion(ArrayList<Jugador>jugadores) throws SQLException{
        this.vista=new GameplayAproximacion();
        this.empatados= jugadores;
        this.vista.setVisible(true);
        this.vista.jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salirDelJuego();
            }
        });
        traerTematica();
        //listener();
        desempatar(3, false);
    }

    private void salirDelJuego() {
        System.exit(0);
    }

    private void traerTematica() {
        String tematica = Tematica.obtenerTematica(1).getNombre();
        vista.getTematica().setText(tematica);
    }

    private void listener() {
        this.vista.getResultadoAprox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rtaSelec = vista.getResultadoAprox().getText();
            }
        });
    }
   public Boolean determinarResultado() throws SQLException {
        // Lógica para determinar el resultado de la ronda
        // Por ejemplo, eliminar al jugador con menos puntaje
        // ESTE CODIGO DEBE UTILIZARSE EN EL CONTROLADOR GAMEPLAY EN CONTROLADOR GAMEPLAY_APROXIMACION
        Jugador jugadorMenorPuntaje = empatados.get(1);
        Boolean empate;
        for (Jugador jugador : empatados) {
            if (jugador.getPuntaje() < jugadorMenorPuntaje.getPuntaje()) {
                jugadorMenorPuntaje = jugador;
            }
        }
        for(Jugador jugador : empatados){
            if(jugadorMenorPuntaje.getPuntaje() == jugador.getPuntaje()){
                addEmpatados(jugador);
            }
        }
        if (empatados.size()== 1){
            eliminarJugador(empatados.get(0));
            return empate = false;//Llevaria al Controlador de Siguiente Escalon
        }else{
            return empate = true;//Llevaria al controlador de Gameplay_Aproximacion
            //desempatar(this.escalon.getTematica().getId());
        }
    }

    public void desempatar(int idEscalon, boolean empate) throws SQLException {
        ArrayList<PreguntaAproximacion> pregAprox = new ArrayList<>();
        pregAprox = PreguntaAproximacion.obtenerPreguntasAproximacionTematica(idEscalon);
        System.out.println("A continuación, ¡Evaluaremos el desempate!");
        Boolean eliminado = true;
        while (eliminado) {
            PreguntaAproximacion pregunta = pregAprox.get(new Random().nextInt(pregAprox.size()));
            vista.getjTextFieldPregunta().setText(pregunta.getEnunciado());
            System.out.println("Pregunta desempate " + ": "+"\n" + pregunta.getEnunciado());
            for (Jugador jugador : empatados){//Responden jugador aproximacion
                System.out.println("Responde el jugador " + jugador.getNombre());
                jugador = preguntarAproximacion(jugador, pregunta);
            }
            int peorRta = 0;
            for(Jugador jugador : empatados){//Conseguis el peor puntaje
                jugador.setPuntaje(valorAbsoluto((pregunta.getValorAproximado() - jugador.getPuntaje())));
                if (jugador.getPuntaje() > peorRta) {
                    /* removeEmpatado(empatados.get(j)); */
                    peorRta = jugador.getPuntaje();
                }
            }
            for(Jugador jugador : empatados){//Sacas a los jugadores que se salvaron
                if (jugador.getPuntaje() != peorRta) {
                    removeEmpatado(jugador);
                }
            }
            if(empatados.size() == 1){//Si hay mas de un jugador con el peor puntaje, no entra aca
                eliminarJugador(empatados.get(0));
                eliminado= false;
            }
            pregAprox.remove(pregunta);
        }
    }

public Jugador preguntarAproximacion(Jugador jugador, PreguntaAproximacion pregunta) {
    int rta = 2;
    jugador.setPuntaje(rta); //Obtener de vista la respuesta
    return jugador;
}
    private int valorAbsoluto(int numero){
        if (numero>=0){
            return numero;
        }else{
        return (numero*-1);
        }
    }

    private void eliminarJugador(Jugador jugador){
        empatados.remove(jugador);
        jugador.setEstado("Eliminado");
        System.out.println("Jugador eliminado: " + jugador.getNombre());
    }

    private void inicializarPuntos() {
        for (Jugador jug: empatados) {
            jug.setPuntaje(0);
        }
    }
    public void addEmpatados(Jugador jugador) {
        empatados.add(jugador);
    }
    
    public void removeEmpatado(Jugador jugador) {
        empatados.remove(jugador);
    }

    public static void main(String[] args) throws SQLException {
        new ControladorGameplayAproximacion(Jugador.obtenerJugadores());
    }

}