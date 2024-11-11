import java.util.ArrayList;
import java.util.List;

public class MultipleChoicePregunta extends Pregunta {
    private ArrayList<Respuesta> opciones;
    private String respuestaCorrecta;

    public MultipleChoicePregunta(int idPregunta, String enunciado, int idTematica, String respuestaCorrecta) {
        super(idPregunta, enunciado, idTematica, "multiple choice");
        this.opciones = new ArrayList<>();
        this.respuestaCorrecta = respuestaCorrecta;
    }

    /*public boolean esCorrecta(String respuesta) {
        return respuestaCorrecta.equalsIgnoreCase(respuesta);
    }*/

    public void imprimirOpciones() {
        String[] abc = {"a", "b", "c", "d"};
        int num = 1;
        for (Respuesta op: opciones) {
            System.out.println(abc[num] + ". " + op.getTexto());
            num = num + 1;
        }
    }

    public void guardarOpciones(int idPregunta/* acá iria el coso de la base de datos */) {
        for (Respuesta rep: bd){
            if (rep.getIdPregunta() == idPregunta){
                opciones.add(rep);
            }
        }
    }

    // getters y setters

    public ArrayList<Respuesta> getOpciones() {
        return opciones;
    }

    public void setOpciones(ArrayList<Respuesta> opciones) {
        this.opciones = opciones;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
}