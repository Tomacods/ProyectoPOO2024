package Modelos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAOs.JugadorDAOImpl;
import DAOs.MultipleChoiceDAO;

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
        this.opciones = new ArrayList<>();//guardarOpciones();
    }

    public void imprimirOpciones() {
        String[] abc = {"a", "b", "c", "d"};
        int num = 1;
        for (Respuesta op: opciones) {
            System.out.println(abc[num] + ". " + op.getTexto());
            num = num + 1;
        }
    }

    /* private List<Respuesta> guardarOpciones() {
        //List<Respuesta> mcPreg = obtenerRespuestasPorPregunta(idPregunta);
        return obtenerRespuestasPorPregunta(idPregunta);
    } */

    // getters y setters

    public List<Respuesta> getOpciones() {
        return opciones;
    }


    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public int getIdPregunta() {
        return idPregunta;
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


    //ABM
        //ABM
    public static void insertarPregunta (MultipleChoicePregunta pregunta, List<Respuesta> respuestas) throws SQLException{
        MultipleChoiceDAO dao = new MultipleChoiceDAO();
        dao.insertarPreguntaMultipleChoise(pregunta, respuestas);
    }
    public static void eliminarPregunta(int id){
        MultipleChoiceDAO dao = new MultipleChoiceDAO();
        dao.eliminarPreguntaMC(id);
    }
    public static void actualizarPregunta(MultipleChoicePregunta pregunta){
        MultipleChoiceDAO dao = new MultipleChoiceDAO();
        dao.actualizarPreguntaMC(pregunta);
    }

    public static ArrayList<MultipleChoicePregunta> obtenerPreguntasMC(int id_tematica){
        MultipleChoiceDAO dao = new MultipleChoiceDAO();
        ArrayList<Object[]> arreglo = dao.obtenerPreguntasMCPorTematica(id_tematica);
        ArrayList <MultipleChoicePregunta> preguntasMC = new ArrayList<>();

        for (Object[] row : arreglo) {
            MultipleChoicePregunta pregunta = new MultipleChoicePregunta((int) row[0], (String) row[1], (int) row[2]);
            preguntasMC.add(pregunta);
        }
        return preguntasMC;
        
    }

    public static MultipleChoicePregunta obtenerPreguntaMC(int id_pregunta) throws SQLException{
        MultipleChoiceDAO dao = new MultipleChoiceDAO();
        MultipleChoicePregunta pregunta = dao.obtenerPreguntaMC(id_pregunta);
        return pregunta;
    }

    public void agregarRespuesta(Respuesta respuesta) {
        this.opciones.add(respuesta);
    }

    public static MultipleChoicePregunta obtenerPreguntaPorEnunciado(String enunciado, int idTematica) {
        // Obtener las preguntas de la temática específica
        ArrayList<MultipleChoicePregunta> preguntas = obtenerPreguntasMC(idTematica);
    
        // Buscar la pregunta que coincide con el enunciado
        for (MultipleChoicePregunta pregunta : preguntas) {
            if (pregunta.getEnunciado().equals(enunciado)) {
                return pregunta; // Devuelve la pregunta completa
            }
        }
        
        // Si no se encuentra, lanzar una excepción indicando que no se encontró
        throw new IllegalArgumentException("No se encontró una pregunta con el enunciado: " + enunciado + " para la temática con ID: " + idTematica);
    }
    

    public static MultipleChoicePregunta obtenerPreguntaConRtas(int id_pregunta) throws SQLException{
        MultipleChoiceDAO dao = new MultipleChoiceDAO();
        MultipleChoicePregunta pregunta = dao.obtenerPreguntaConRespuestas(id_pregunta);
        return pregunta;

    }
    public void imprimirPreguntaYRespuestas() { //para ver si funciona el obtenerPreguntasConRtas
        System.out.println("Pregunta: " + enunciado);
        if (opciones != null) {
            for (Respuesta r : opciones) {
                System.out.println(" - " + r.getTexto() + " (Correcta: " + r.isEsCorrecta() + ")");
            }
        }
    }
    
}