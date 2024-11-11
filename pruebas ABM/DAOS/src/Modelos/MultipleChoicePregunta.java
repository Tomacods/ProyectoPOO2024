package Modelos;
import java.util.List;

public class MultipleChoicePregunta extends Pregunta {
    private List<String> opciones;
    private String respuestaCorrecta;

    public MultipleChoicePregunta(int idPregunta, String enunciado, String categoria, List<String> opciones, String respuestaCorrecta, int id_tematica) {
        super(idPregunta, enunciado, categoria,id_tematica );
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public boolean esCorrecta(String respuesta) {
        return respuestaCorrecta.equalsIgnoreCase(respuesta);
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
}