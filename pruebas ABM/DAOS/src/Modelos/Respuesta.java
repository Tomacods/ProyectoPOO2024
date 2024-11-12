package Modelos;

public class Respuesta {
    private int idRespuesta;
    private int idPregunta;
    private String texto;
    private boolean esCorrecta;


    public Respuesta(int idRespuesta, int idPregunta, String texto, boolean esCorrecta) {
        this.idRespuesta = idRespuesta;
        this.idPregunta = idPregunta;
        this.texto = texto;
        this.esCorrecta = esCorrecta;
    }
    public Respuesta(){
    }

    //setters y getters

    public int getIdRespuesta() {
        return idRespuesta;
    }
    
    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }
    
}
