package DAOs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    }




    






