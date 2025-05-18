package Modelos;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * La clase Escalon representa un escalón dentro del juego, asociado a una temática,
 * un conjunto de jugadores y un estado. Permite gestionar la lógica de juego de cada escalón,
 * incluyendo la ejecución de rondas y la determinación de los jugadores que avanzan.
 *
 * Campos:
 * - numeroEscalon: número identificador del escalón dentro del juego.
 * - estado: estado actual del escalón (por ejemplo, activo, finalizado).
 * - jugadores: lista de jugadores que participan en el escalón.
 * - tematica: temática asociada al escalón.
 * - juego: referencia al juego al que pertenece el escalón.
 *
 * Métodos principales:
 * - jugarEscalon(): ejecuta la lógica de juego para el escalón, iniciando una ronda y determinando los jugadores que avanzan.
 * - jugarEscalonFinal(): ejecuta la lógica específica para el escalón final, determinando al ganador.
 * - quienesSuben(): muestra los jugadores que avanzan al siguiente escalón.
 * - actualizarJugadores(Jugador): elimina un jugador de la lista de participantes del escalón.
 * - Getters para los campos principales.
 *
 * Excepciones:
 * - Puede lanzar SQLException durante la ejecución de las rondas.
 */
public class Escalon {
    //private int idEscalon;
    private int numeroEscalon;
    private String estado;
    private ArrayList<Jugador> jugadores;
    private Tematica tematica;
    private Juego juego;

    public Escalon(int numeroEscalon, String estado, Tematica tematica,ArrayList<Jugador> jugadores,Juego juego ) {
        this.numeroEscalon = numeroEscalon;
        this.estado = estado;
        this.tematica = tematica;
        this.jugadores = jugadores;
        this.juego = juego;
    }

    public void jugarEscalon() throws SQLException {
        System.out.println("La categoría del escalón " + numeroEscalon + " es " + tematica.getNombre() + ".");
        Ronda ronda = new Ronda(juego.getIdJuego(), jugadores, this);
        ronda.iniciarRonda();
        if (jugadores.size() == 1){
            System.out.println("El ganador es: " + jugadores.get(0).getNombre());
            
        } else {
            quienesSuben();
        }
    }
    public void jugarEscalonFinal() throws SQLException {
        System.out.println("¡¡Bienvenidos al Escalon Final!!");
        Ronda ronda = new Ronda(juego.getIdJuego(), jugadores, this);
        ArrayList<Tematica> tematicas = Tematica.obtenerTematicas();
        Jugador jugadorGanador = ronda.rondaFinal(tematicas, jugadores);
        System.out.println("El ganador es " + jugadorGanador.getNombre());
    }

    private void quienesSuben() {
        System.out.println("Suben los siguientes participantes:");
        for (Jugador jugador: jugadores) {
            System.out.println(jugador.getNombre());
        }
    }

    public void actualizarJugadores(Jugador jugador){
        jugadores.remove(jugador);
    }

    public int getNumeroEscalon() {
        return numeroEscalon;
    }

    public String getEstado() {
        return estado;
    }

    public Tematica getTematica() { //tendria que llamar al Dao de Tematica para obtener la tematica
        return tematica;
    }
}