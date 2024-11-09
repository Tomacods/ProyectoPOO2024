public abstract class Pregunta {
    private int idPregunta;
    private String enunciado;
    private String tipoPregunta;
    //private String categoria;
    private Tematica tematica;

    // Constructor
    public Pregunta(int idPregunta, String enunciado, String tipoPregunta, Tematica tematica/*String categoria*/) {
        this.idPregunta = idPregunta;
        this.enunciado = enunciado;
        this.tipoPregunta = tipoPregunta;
        //this.categoria = categoria;
        this.tematica = tematica;
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

    public String getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(String tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }


    
    public abstract boolean esCorrecta(String respuesta);
}