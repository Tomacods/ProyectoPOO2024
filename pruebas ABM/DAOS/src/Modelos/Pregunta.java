package Modelos;
public abstract class Pregunta {
    private int idPregunta;
    private String enunciado;//cambiar a protected
    private String categoria;
    private int id_tematica;
    protected IDao Dao; //INTERFAZ Q VA A TENER LOS ABM Y ALL Y UNO X ID QUE VAN A USAR TODOS LOS DAO
    //SEPARAR LOS DAO EN PREGUNTA
    //CREAR EL DAO RESPUESTA
    

    // Constructor
    public Pregunta(int idPregunta, String enunciado, String categoria, int id_tematica) {
        this.idPregunta = idPregunta;
        this.enunciado = enunciado;
        this.categoria = categoria;
        this.id_tematica=id_tematica;
    }
    
    // Getters y Setters
    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    
    public int getId_tematica() {
        return id_tematica;
    }

    public void setId_tematica(int id_tematica) {
        this.id_tematica = id_tematica;
    }

    public abstract boolean esCorrecta(String respuesta);


}