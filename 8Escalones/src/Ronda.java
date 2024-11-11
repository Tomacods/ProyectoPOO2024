import java.util.Date;
import java.util.List;
import java.util.Random;

public class Ronda {
    private int idRonda;
    private int idJuego;
    private List<Jugador> jugadores;
    private List<Pregunta> preguntas;
    private Escalon escalon; // pq
    private String resultado; // para q (no creo que haga falta usarlo, nota)
    private Date fecha;
    private String estado;

    public Ronda(int idRonda, int idJuego, List<Jugador> jugadores, Escalon escalon) {
        this.idRonda = idRonda;
        this.idJuego = idJuego;
        this.jugadores = jugadores;
        this.preguntas = preguntas;
        this.escalon = escalon;
        this.fecha = new Date();
        this.estado = "en curso";
    }

    public void iniciarRonda() {
        System.out.println("Iniciando ronda " + idRonda + " del juego " + idJuego);
        realizarPreguntas();
        determinarResultado();
        this.estado = "finalizado";
    }

    private void realizarPreguntas() {
        for (Jugador jugador : jugadores) {
            Pregunta pregunta = preguntas.get(new Random().nextInt(preguntas.size()));
            while (pregunta.getTipoPregunta() != "multiple choice"){
                pregunta = preguntas.get(new Random().nextInt(preguntas.size()));
            }
            System.out.println("Pregunta para " + jugador.getNombre() + ": " + pregunta.getEnunciado());
            
            // La respuesta se obtiene de un botón. 
            // Simular respuesta del jugador
            String respuesta = "Opción A"; // Ejemplo de respuesta
            if (pregunta.esCorrecta(respuesta)) {
                System.out.println("Respuesta correcta");
                jugador.incrementarPuntaje();
            } else {
                System.out.println("Respuesta incorrecta");
            }
            preguntas.remove(pregunta);
        }
    }
    
    //metodoo para realizar preguntas por aproximacion
    //recorro la lista de jugadores y de las respuestas que me dicen compararlas con la respuesta correcta, la que mas se aproxime es la que se toma como correcta y el queda en el escalon


    private void determinarResultado() {
        // Lógica para determinar el resultado de la ronda
        // Por ejemplo, eliminar al jugador con menos puntaje
        Jugador jugadorEliminado = jugadores.get(0);
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntaje() < jugadorEliminado.getPuntaje()) {
                jugadorEliminado = jugador;
            }
        }
        jugadores.remove(jugadorEliminado);
        System.out.println("Jugador eliminado: " + jugadorEliminado.getNombre());
    }

    // Getters y Setters

    public int getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Escalon getEscalon() {
        return escalon;
    }

    public void setEscalon(Escalon escalon) {
        this.escalon = escalon;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
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

    public void addPreguntas(Pregunta pregunta) {
        preguntas.add(pregunta);
    }
}