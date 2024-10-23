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
    
<<<<<<< Updated upstream
    /**
     * @return int return the id
     */
=======
    public Jugador(int id, String nombre, String apellido, String correo, int puntaje, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.puntaje = puntaje;
        this.estado = estado;
    }

    public Jugador() {
    }

>>>>>>> Stashed changes
    public int getId() {
        return id;
    }

<<<<<<< Updated upstream
    /**
     * @return String return the nombre
     */
=======
>>>>>>> Stashed changes
    public String getNombre() {
        return nombre;
    }

<<<<<<< Updated upstream
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String return the apellido
     */
=======
>>>>>>> Stashed changes
    public String getApellido() {
        return apellido;
    }

<<<<<<< Updated upstream
    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return int return the puntaje
     */
=======
    public String getCorreo() {
        return correo;
    }

>>>>>>> Stashed changes
    public int getPuntaje() {
        return puntaje;
    }

<<<<<<< Updated upstream
    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * @return String return the estado
     */
=======
>>>>>>> Stashed changes
    public String getEstado() {
        return estado;
    }

<<<<<<< Updated upstream
    /**
     * @param estado the estado to set
     */
=======
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

>>>>>>> Stashed changes
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}