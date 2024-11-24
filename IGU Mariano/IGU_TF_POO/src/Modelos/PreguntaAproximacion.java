package Modelos;
import java.sql.SQLException;
import java.util.ArrayList;

import DAOs.AproximacionDAO;

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

}