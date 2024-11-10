import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreguntaMCDAO {
private Connection connection;

public preguntaMCDAO(Connection connection){
    this.connection= connection;
}

public void insertarPreguntaMC(MultipleChoicePregunta pregunta){
        String query = "INSERT INTO pregunta_multiple_choise( enunciado, categoria, id_tematica) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1, pregunta.getEnunciado());
            statement.setString(2, pregunta.getCategoria());
            statement.setInt(3, pregunta.getId_tematica());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace(); 
        }
    }

public void actualizarPreguntaMC(MultipleChoicePregunta pregunta){
    String query ="UPDATE pregunta_multiple_choise SET enunciado=?, categoria=?, id_tematica=?) WHERE id_pregunta_mc = ?";
try(PreparedStatement statement = connection.prepareStatement(query)) {
    statement.setString(1, pregunta.getEnunciado());
    statement.setString(2, pregunta.getCategoria());
    statement.setInt(3, pregunta.getId_tematica());
    statement.executeUpdate();
    
} catch (SQLException e) {
    e.printStackTrace();
}
}

public void eliminarPreguntaMC(int id_pregunta){
    String query= "DELETE FROM pregunta_multiple_choise WHERE id_pregunta_mc = ?";
    try(PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, id_pregunta);
        statement.executeUpdate();
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    




}