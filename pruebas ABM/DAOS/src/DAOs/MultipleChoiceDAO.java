package DAOs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelos.MultipleChoicePregunta;
import Modelos.Pregunta;
import Modelos.PreguntaAproximacion;
import Modelos.Respuesta;

public class MultipleChoiceDAO {

private Connection connection;
private RespuestaDAO rta;

public MultipleChoiceDAO(Connection connection, RespuestaDAO rta){
    this.connection= connection;
    this.rta= rta;
}


public void insertarPreguntaMultipleChoise(MultipleChoicePregunta pregunta, List<Respuesta> respuestas) throws SQLException {
        String queryPregunta = "INSERT INTO Pregunta_multiple_choise (Enunciado, ID_Tematica) VALUES (?, ?)";
        
        try (PreparedStatement statementPregunta = connection.prepareStatement(queryPregunta, PreparedStatement.RETURN_GENERATED_KEYS)) {
            // Insertar la pregunta
            statementPregunta.setString(1, pregunta.getEnunciado());
            statementPregunta.setInt(2, pregunta.getIdTematica());
            statementPregunta.executeUpdate();

            // Obtener el ID de la pregunta recién insertada
            try (ResultSet generatedKeys = statementPregunta.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idPregunta = generatedKeys.getInt(1);

                    // Insertar las respuestas asociadas a la pregunta
                    for (Respuesta respuesta : respuestas) {
                        respuesta.setIdPregunta(idPregunta);
                        rta.insertarRespuesta(respuesta);
                    }
                } else {
                    throw new SQLException("Error al obtener el ID de la pregunta insertada.");
                }
            }
        }
    }

    public void insertarPregunta(MultipleChoicePregunta pregunta){
                String query="INSERT INTO pregunta_multiple_choise(enunciado, id_tematica) VALUES (?,?)";
                try(PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, pregunta.getEnunciado());
                statement.setInt(2, pregunta.getIdTematica());
                statement.executeUpdate(); 
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
            }

    public void actualizarPreguntaMC(MultipleChoicePregunta pregunta){
                String query="UPDATE pregunta_multiple_choise SET enunciado=?, id_tematica=? WHERE id_pregunta_mc =?";
                try(PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, pregunta.getEnunciado());
                statement.setInt(2, pregunta.getIdTematica());
                statement.setInt(3, pregunta.getIdPregunta());
                statement.executeUpdate(); 
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
            }

    public void eliminarPreguntaMC(int id){
        String query="DELETE FROM pregunta_multiple_choise WHERE id_pregunta_mc= ?";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            
        } catch (SQLException e) {
        e.printStackTrace();
        }
        
    }


    //QUERYS
    public ArrayList<Object[]> obtenerPreguntasMCPorTematica(int id) { //DEVUELVE LAS PREGUNTAS DE CIERTA TEMATICA (SEGUN EL ID)
        ArrayList<Object[]> preguntas = new ArrayList<>();
        String query = "select p.id_pregunta_mc,  p.enunciado, p.id_tematica from pregunta_multiple_choise p inner join tematica t on p.id_tematica = t.id_tematica where t.id_tematica=?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y agregar las preguntas al ArrayList
            while (resultSet.next()) {
                Object[] row = {
                    resultSet.getInt("id_pregunta_mc"),   
                    resultSet.getString("enunciado"),  
                    resultSet.getInt("id_tematica")   
                };
                preguntas.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preguntas;
    }

    

}
/* public MultipleChoiceDAO(Connection Connection){
    this.connection= connection;
}
public void insertarOpciones(int id_pregunta, List<String> opciones, String opcionCorrecta){

    if (opciones.size() != 4) {
        System.err.println("Una pregunta solo puede tener 4 opciones.");
        return;
    }

    String query = "INSERT INTO respuesta (id_pregunta, texto, correcta) VALUES (?,?,?)";
    try(PreparedStatement statement = connection.prepareStatement(query)) {
        for (String opcion : opciones){
        statement.setInt(1, id_pregunta );
        statement.setString(2, opcion);
        statement.setBoolean(3, opcion.equals(opcionCorrecta));
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }


} */

    




    






