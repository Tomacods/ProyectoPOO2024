public class Contexto {
    
    private Pregunta pregunta;

    public void setEstrategia(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public int idPregunta() {
        return pregunta.getIdPregunta();
    }

    public String enunciado() {
        return pregunta.getEnunciado();
    }

    public String respuestaCorrecta() {
        return pregunta.getRespuestaCorrecta();
    }

    public int idTematica() {
        return pregunta.getIdTematica();
    }
}
