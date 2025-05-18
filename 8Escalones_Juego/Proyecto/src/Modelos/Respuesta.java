package Modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAOs.BaseDeDatos;
import DAOs.RespuestaDAO;

/**
 * La clase Respuesta representa una posible respuesta a una pregunta en el sistema.
 * Contiene información sobre el identificador de la respuesta, el identificador de la pregunta
 * a la que pertenece, el texto de la respuesta y si es la respuesta correcta.
 * 
 * Proporciona constructores para crear instancias de Respuesta, así como métodos getter y setter
 * para acceder y modificar sus atributos.
 * 
 * Además, incluye métodos estáticos para obtener respuestas asociadas a una pregunta específica,
 * obtener el identificador de la respuesta correcta para preguntas de opción múltiple,
 * y recuperar una respuesta específica por su identificador, utilizando la capa DAO.
 */
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
    public Respuesta(String texto, boolean esCorrecta) {
        this.texto = texto;
        this.esCorrecta = esCorrecta;
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

    public static ArrayList<Respuesta> obtenerRespuestasPorPregunta(int idPregunta) throws SQLException {
    RespuestaDAO dao = new RespuestaDAO(); // Instancia del DAO
    ArrayList<Object[]> arreglo = dao.obtenerRespuestasPorPregunta(idPregunta); // Llamada al método DAO
    ArrayList<Respuesta> respuestas = new ArrayList<>();

    // Convertir las filas en objetos Respuesta
    for (Object[] row : arreglo) {
        Respuesta respuesta = new Respuesta(
            (int) row[0],        // ID_Respuesta
            (int) row[1],        // ID_Pregunta
            (String) row[2],     // Texto
            (boolean) row[3]     // Correcta
        );
        respuestas.add(respuesta);
    }
    return respuestas;
}

public static int obtenerIdRtaCorrectaMC(int id_pregunta) {
    RespuestaDAO dao = new RespuestaDAO(); // Instanciamos el DAO
    return dao.obtenerIdRtaCorrectaMC(id_pregunta); // Llamamos al método del DAO y devolvemos el resultado
}

public static Respuesta obtenerRespuesta(int idRespuesta) throws SQLException {
    RespuestaDAO dao = new RespuestaDAO(); // Instanciamos el DAO
    return dao.obtenerRespuesta(idRespuesta); // Llamamos al método del DAO y devolvemos el resultado
}



    
}
