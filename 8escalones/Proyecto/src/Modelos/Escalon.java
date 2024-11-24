package Modelos;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public void jugarEscalonFinal() {
        System.out.println("¡¡Bienvenidos al Escalon Final!!");
        Ronda ronda = new Ronda(juego.getIdJuego(), jugadores, this);
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