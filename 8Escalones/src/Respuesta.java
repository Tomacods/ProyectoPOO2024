public class Respuesta {
    
    private int idPregunta;
    private int idRespuesta;
    private String texto;
    private boolean correcta;

    public int getIdPregunta() {
        return idPregunta;
    }
    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }
    public int getIdRespuesta() {
        return idRespuesta;
    }
    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public boolean isCorrecta() {
        return correcta;
    }
    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }
}