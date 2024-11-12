import java.util.ArrayList;
import java.util.List;
//import DAOs.RespuestaDAO;

public class MultipleChoicePregunta {
    private int idPregunta;
    private String enunciado;
    private int idTematica;
    private List<Respuesta> opciones;
    private String respuestaCorrecta;

    public MultipleChoicePregunta(int idPregunta, String enunciado, int idTematica) {
        this.idPregunta = idPregunta;
        this.enunciado = enunciado;
        this.idTematica = idTematica;
        this.opciones = guardarOpciones();
    }

    public void imprimirOpciones() {
        String[] abc = {"a", "b", "c", "d"};
        int num = 1;
        for (Respuesta op: opciones) {
            System.out.println(abc[num] + ". " + op.getTexto());
            num = num + 1;
        }
    }

    private List<Respuesta> guardarOpciones() {
        //List<Respuesta> mcPreg = obtenerRespuestasPorPregunta(idPregunta);
        return obtenerRespuestasPorPregunta(idPregunta);
    }

    // getters y setters

    public List<Respuesta> getOpciones() {
        return opciones;
    }


    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
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
}