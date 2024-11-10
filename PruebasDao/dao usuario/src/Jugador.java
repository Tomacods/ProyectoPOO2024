public class Jugador {
    private int id_jugador;
    private String nombre;
    private int puntaje;
    private String estado;

    // Constructor, getters y setters
    
    public Jugador(int id_jugador, String nombre,  int puntaje, String estado) {
        this.id_jugador = id_jugador;
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.estado = estado;
    }

    public Jugador() {
    }

    public int getId() {
        return id_jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public int getPuntaje(){
        return puntaje;
    }

    public void setId(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void incrementarPuntaje() {
        this.puntaje++;
    }
    
}