package DAOs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelos.MultipleChoicePregunta;
import Modelos.Pregunta;
import Modelos.PreguntaAproximacion;

public class MultipleChoiceDAO {

private Connection connection;

public MultipleChoiceDAO(Connection Connection){
    this.connection= connection;
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
    public ArrayList<Object[]> obtenerPreguntasMCPorTematica(int id) { //DEVOLVERA LAS PREGUNTAS DE CIERTA TEMATICA (SEGUN EL ID)
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

    




    





