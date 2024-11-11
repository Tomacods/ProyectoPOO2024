import java.util.List;

public class MultipleChoicePregunta extends Pregunta {
    private List<String> opciones;
    private String respuestaCorrecta;

    public MultipleChoicePregunta(int idPregunta, String enunciado, int idTematica, List<String> opciones, String respuestaCorrecta) {
        super(idPregunta, enunciado, idTematica, "multiple choice");
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public boolean esCorrecta(String respuesta) {
        return respuestaCorrecta.equalsIgnoreCase(respuesta);
    }

    public void imprimirOpciones() {
        String[] abc = {"a", "b", "c", "d"};
        int num = 1;
        for (String op: opciones) {
            System.out.println(abc[num] + ". " + op);
            num = num + 1;
        }
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