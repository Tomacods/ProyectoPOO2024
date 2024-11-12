public abstract class Pregunta {//ES UNA INTERFAZ NO UNA ABSTRACCION AAAAA
    private int idPregunta;
    private String enunciado;
    private int idTematica;
    private String tipoPregunta;

    // Constructor
    public Pregunta(int idPregunta, String enunciado, int idTematica, String tipoPregunta) {
        this.idPregunta = idPregunta;
        this.enunciado = enunciado;
        this.idTematica = idTematica;
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

    public int getIdTematica() {
        return idTematica;
    }

    public void setIdTematica(int idTematica) {
        this.idTematica = idTematica;
    }

    public String getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(String tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public int getValorAproximado() {
        // TODO Auto-generated method stub
        return valorAproximado;
    }
    }

    //public abstract boolean esCorrecta(String respuesta);
}