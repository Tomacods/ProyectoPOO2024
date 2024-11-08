import java.util.ArrayList;

public class Escalon {
    private int idEscalon;
    private int numeroEscalon;
    private String estado;
    private int idTematica;
    private ArrayList<Pregunta> preguntas;

    public Escalon(int idEscalon, int numeroEscalon, String estado, int idTematica) {
        this.idEscalon = idEscalon;
        this.numeroEscalon = numeroEscalon;
        this.estado = estado;
        this.idTematica = idTematica;
        this.preguntas = new ArrayList<>();
    }

    public void jugarEscalon() {

    }

    public void preguntasEscalon() {
        
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

    public int getIdTematica() { //tendria que llamar al Dao de Tematica para obtener la tematica
        return idTematica;
    }

    public void setIdEscalon(int idEscalon) {
        this.idEscalon = idEscalon;
    }

    public void addPreguntas(Pregunta pregunta) {
        preguntas.add(pregunta);
    }
}