package Modelos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAOs.AproximacionDAO;
import DAOs.BaseDeDatos;

public class PreguntaAproximacion {
    private int idPregunta;
    private String enunciado;
    private int idTematica;
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

    public static ArrayList<PreguntaAproximacion> obtenerPreguntasAprox() throws SQLException{
        AproximacionDAO dao = new AproximacionDAO();
        ArrayList<Object[]> arreglo = dao.obtenerTodasLasPreguntasAproximacion();
        ArrayList<PreguntaAproximacion> preguntas = new ArrayList<>();
        for (Object[] row : arreglo) {
            PreguntaAproximacion pregunta = new PreguntaAproximacion((int) row[0], (String) row[1], (int) row[2], (int) row[3]);
            preguntas.add(pregunta);
        }
        return preguntas;
    }

    public static ArrayList<PreguntaAproximacion> obtenerPreguntasAproximacionTematica(int id_tematica) throws SQLException{
        AproximacionDAO dao = new AproximacionDAO();
        ArrayList<Object[]> arreglo = dao.obtenerPreguntasPorTematica(id_tematica);
        ArrayList <PreguntaAproximacion> preguntas = new ArrayList<>();

        for (Object[] row : arreglo) {
            PreguntaAproximacion pregunta = new PreguntaAproximacion((int) row[0], (String) row[1], (int) row[2], (int) row[3]);
            preguntas.add(pregunta);
        }
        return preguntas;
        
    }
public static void insertarPreguntaAproximacion(PreguntaAproximacion preguntaAproximacion) throws SQLException{
        AproximacionDAO dao = new AproximacionDAO();
        dao.insertarPreguntaAproximacion(preguntaAproximacion);
    }
    public static void eliminarPreguntaAprox(int id) throws SQLException{
        AproximacionDAO dao = new AproximacionDAO();
        dao.eliminarPreguntaAproximacion(id);
    }
    public static void actualizarPreguntaAprox(PreguntaAproximacion preguntaAproximacion) throws SQLException{
        AproximacionDAO dao = new AproximacionDAO();
        dao.actualizarPreguntaAproximacion(preguntaAproximacion);
    }
    public static PreguntaAproximacion obtenerPreguntaPorEnunciado(String enunciado, int idTematica) throws SQLException {
        // Obtener las preguntas de la temática específica
        ArrayList<PreguntaAproximacion> preguntas = obtenerPreguntasAproximacionTematica(idTematica);
    
        // Buscar la pregunta que coincide con el enunciado
        for (PreguntaAproximacion pregunta : preguntas) {
            if (pregunta.getEnunciado().equals(enunciado)) {
                return pregunta; // Devuelve la pregunta completa
            }
        }
        
        // Si no se encuentra, lanzar una excepción indicando que no se encontró
        throw new IllegalArgumentException("No se encontró una pregunta con el enunciado: " + enunciado + " para la temática con ID: " + idTematica);
    }

    public void setEnunciado(String nuevaPregunta) {
        this.enunciado= nuevaPregunta;
    }



    public static int obtenerValorAproximado(int id_pregunta) throws SQLException{
        AproximacionDAO dao = new AproximacionDAO();
        return dao.obtenerValorAproximado(id_pregunta);
    }



}