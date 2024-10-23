public class Jugador {
    private int id;
    private String nombre;
    private String apellido;
    private String correo; //no se si lo pondria, pero en el ejemplo del profe lo puso
    private int puntaje;
    private String estado;

    public Jugador(String apellido, String correo, String estado, String nombre) {
        this.apellido = apellido;
        this.correo = correo;
        this.estado = estado;
        this.id = null; //id;
        this.nombre = nombre;
        this.puntaje = 0;
    }

    // Constructor, getters y setters
    
    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return int return the puntaje
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * @return String return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}