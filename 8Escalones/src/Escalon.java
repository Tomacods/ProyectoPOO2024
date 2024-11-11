import java.util.ArrayList;

public class Escalon {
    private int idEscalon;
    private int numeroEscalon;
    private String estado;
    private ArrayList<Jugador> jugadores;
    private Tematica tematica;
    private ArrayList<Pregunta> preguntas;

    public Escalon(int idEscalon, int numeroEscalon, String estado, Tematica tematica /*int idTematica*/) {
        this.idEscalon = idEscalon;
        this.numeroEscalon = numeroEscalon;
        this.estado = estado;
        this.tematica = tematica;
        this.preguntas = new ArrayList<>();
    }

    public void jugarEscalon() {
        System.out.println("La categoría del escalón " + numeroEscalon + " es " + tematica.getNombre() + ".");
        preguntasEscalon(tematica);
    }

    public ArrayList<Pregunta> preguntasEscalon(Tematica tematica) {
        /*for (Pregunta preg : bd) {
            if (preg.getTematica() == tematica){
                preguntas.add(preg);
            }
        }*/
        return preguntas;
    }

    public void actualizarJugadores(Jugador jugador){
        jugadores.remove(jugador);
    }

    public int getIdEscalon() {
        return idEscalon;
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

    public void setIdEscalon(int idEscalon) {
        this.idEscalon = idEscalon;
    }

    public void addPreguntas(Pregunta pregunta) {
        preguntas.add(pregunta);
    }
}