public class Escalon {
    private int idEscalon;
    private int numeroEscalon;
    private String estado;

    public Escalon(int idEscalon, int numeroEscalon, String estado) {
        this.idEscalon = idEscalon;
        this.numeroEscalon = numeroEscalon;
        this.estado = estado;
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
}