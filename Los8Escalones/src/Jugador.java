public class Jugador {
    private int id;
    private String nombre;
    private String apellido;
    private String correo; //no se si lo pondria, pero en el ejemplo del profe lo puso
    private int puntaje;
    private String estado;


    // Constructor, getters y setters
    
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

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }


    public String getEstado() {
        return estado;
    }

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

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}