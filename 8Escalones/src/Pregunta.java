public abstract class Pregunta {
    private int idPregunta;
    private String enunciado;
    private Tematica tematica;
    private String tipoPregunta;

    // Constructor
    public Pregunta(int idPregunta, String enunciado, Tematica tematica, String tipoPregunta) {
        this.idPregunta = idPregunta;
        this.enunciado = enunciado;
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

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }

    public String getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(String tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public abstract boolean esCorrecta(String respuesta);
}