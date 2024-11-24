package Modelos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Juego {
    private int idJuego;
    private Date fecha;
    private String estado;
    private ArrayList<Jugador> jugadores;
    private int idJugadorGanador;

    // Constructor
    public Juego(int idJuego, Date fecha, String estado, int idJugadorGanador) {
        this.idJuego = idJuego;
        this.fecha = fecha;
        this.estado = estado;
        this.idJugadorGanador = idJugadorGanador;
    }

    public void comenzarJuego() throws SQLException{
        Random rnd = new Random();
        ArrayList<Tematica> tematicas = new ArrayList<>();//Bajar todas las tematicas, NECESITAMOS METODOS DAOS
        tematicas = Tematica.obtenerTematicas();
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores = Jugador.obtenerJugadores();
        Escalon escalon = new Escalon(0,"sin comenzar",null,jugadores,this);
        for (int i=1;i<=7; i++){
            Tematica tematica =  tematicas.get(rnd.nextInt(tematicas.size()));
            tematicas.remove(tematica);
            escalon = new Escalon(i,"Comenzado",tematica,jugadores,this);
            escalon.jugarEscalon();
        }
        escalon.jugarEscalonFinal();
    }


    // Getters y Setters

    public int getIdJuego() {
        return this.idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdJugadorGanador() {
        return idJugadorGanador;
    }

    public void setIdJugadorGanador(int idJugadorGanador) {
        this.idJugadorGanador = idJugadorGanador;
    }

    // Método para iniciar el juego
    public void iniciarJuego() {
        this.estado = "en curso";
    }

    // Método para finalizar el juego
    public void finalizarJuego(int idJugadorGanador) {
        this.estado = "completado";
        this.idJugadorGanador = idJugadorGanador;
    }

    // Método para verificar si el juego está en curso
    public boolean estaEnCurso() {
        return "en curso".equals(this.estado);
    }
}