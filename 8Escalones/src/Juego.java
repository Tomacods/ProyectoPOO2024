import java.util.Date;

public class Juego {
    private int idJuego;
    private Date fecha;
    private String estado;
    private int idJugadorGanador;

    // Constructor
    public Juego(int idJuego, Date fecha, String estado, int idJugadorGanador) {
        this.idJuego = idJuego;
        this.fecha = fecha;
        this.estado = estado;
        this.idJugadorGanador = idJugadorGanador;
    }

    // Getters y Setters
    public int getIdJuego() {
        return idJuego;
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