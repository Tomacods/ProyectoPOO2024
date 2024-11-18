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

    public Escalon(int numeroEscalon, String estado, Tematica tematica,ArrayList<Jugador> jugadores ) {
        this.numeroEscalon = numeroEscalon;
        this.estado = estado;
        this.tematica = tematica;
        this.jugadores = jugadores;
    }

    public void jugarEscalon() throws SQLException {
        System.out.println("La categoría del escalón " + numeroEscalon + " es " + tematica.getNombre() + ".");
        Ronda ronda = new Ronda(juego.getIdJuego(), jugadores, this);
        ronda.iniciarRonda();
        quienesSuben();
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

    /* public int getIdEscalon() {
        return idEscalon;
    } */

    public int getNumeroEscalon() {
        return numeroEscalon;
    }

    public String getEstado() {
        return estado;
    }

    public Tematica getTematica() { //tendria que llamar al Dao de Tematica para obtener la tematica
        return tematica;
    }

    /* public void setIdEscalon(int idEscalon) {
        this.idEscalon = idEscalon;
    } */
}