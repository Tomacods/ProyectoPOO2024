import java.util.ArrayList;

public class MultipleChoicePregunta {
    private int idPregunta;
    private String enunciado;
    private int idTematica;
    private ArrayList<Respuesta> opciones;
    private String respuestaCorrecta;

    public MultipleChoicePregunta(int idPregunta, String enunciado, int idTematica, String respuestaCorrecta) {
        this.idPregunta = idPregunta;
        this.enunciado = enunciado;
        this.idTematica = idTematica;
        this.opciones = new ArrayList<>();
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public void imprimirOpciones() {
        String[] abc = {"a", "b", "c", "d"};
        int num = 1;
        for (Respuesta op: opciones) {
            System.out.println(abc[num] + ". " + op.getTexto());
            num = num + 1;
        }
    }

    public void guardarOpciones(int idPregunta) {
        /* for (Respuesta rep: bd){
            if (rep.getIdPregunta() == idPregunta){
                opciones.add(rep);
            }
        } */
    }

    // getters y setters

    public ArrayList<Respuesta> getOpciones() {
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