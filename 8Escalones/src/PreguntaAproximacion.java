public class PreguntaAproximacion {
    private int idPregunta;
    private String enunciado;
    private int idTematica;
    private String tipoPregunta;
    private int valorAproximado;

    public PreguntaAproximacion(int idPregunta, String enunciado, int idTematica, int valorAproximado) {
        this.idPregunta = idPregunta;
        this.enunciado = enunciado;
        this.idTematica = idTematica;
        this.valorAproximado = valorAproximado;
    }

    //no se si funciona es q en dao sql solo toma float no big decimal
    public int getValorAproximado() {
        return valorAproximado;
    }

    public void setValorAproximado(int valorAproximado) {
        this.valorAproximado = valorAproximado;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public int getIdTematica() {
        return idTematica;
    }

    public String getTipoPregunta() {
        return tipoPregunta;
    }
}