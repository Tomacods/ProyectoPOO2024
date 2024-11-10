package DAOs;
import Modelos.MultipleChoicePregunta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreguntaMCDAO {
private Connection connection;

public PreguntaMCDAO(Connection connection){
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




public void obtenerPyRHistoria() {
        String query = "SELECT p.ID_Pregunta_mc AS ID_Pregunta, p.Enunciado, r.ID_Respuesta, r.Texto AS Respuesta, r.Correcta "
                +
                "FROM Pregunta_multiple_choise p " +
                "JOIN Respuesta r ON p.ID_Pregunta_mc = r.ID_Pregunta " +
                "WHERE p.ID_Tematica = (SELECT ID_Tematica FROM Tematica WHERE Nombre_Tematica = 'historia') " +
                "ORDER BY p.ID_Pregunta_mc, r.ID_Respuesta";

        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) { //para ejecutar consultas q devuelven datos 

            while (resultSet.next()) { //el result set next se usa para cursores 
                //The next() method of the ResultSet interface moves the pointer of the current (ResultSet) object 
                //to the next row, from the current position
                //https://www.tutorialspoint.com/java-resultset-next-method-with-example
                int idPregunta = resultSet.getInt("ID_Pregunta");
                String enunciado = resultSet.getString("Enunciado");
                int idRespuesta = resultSet.getInt("ID_Respuesta");
                String respuesta = resultSet.getString("Respuesta");
                boolean correcta = resultSet.getBoolean("Correcta");

                System.out.println("Pregunta ID: " + idPregunta + ", Enunciado: " + enunciado);
                System.out.println(
                        "Respuesta ID: " + idRespuesta + ", Respuesta: " + respuesta + ", Correcta: " + correcta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void obtenerRtaCorrectasHistoria(){
        String query = "SELECT p.ID_Pregunta_mc AS ID_pregunta, " +
        "p.Enunciado, " +
        "r.ID_Respuesta, " +
        "r.Texto AS Respuesta_Correcta " +
        "FROM Pregunta_multiple_choise p " +
        "JOIN Respuesta r ON p.ID_Pregunta_mc = r.ID_Pregunta " +
        "WHERE p.ID_Tematica = ( " +
        "    SELECT ID_Tematica " +
        "    FROM Tematica " +
        "    WHERE Nombre_Tematica = 'historia' " +
        ") " +
        "AND r.Correcta = TRUE " +
        "ORDER BY p.ID_Pregunta_mc, r.ID_Respuesta; " ;


    try(PreparedStatement statement = connection.prepareStatement(query);
    ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()){
            int idPregunta = resultSet.getInt("ID_Pregunta");
                String enunciado = resultSet.getString("Enunciado");
                int idRespuesta = resultSet.getInt("ID_Respuesta");
                String respuesta = resultSet.getString("Respuesta_Correcta");
                System.out.println("ID pregunta: " + idPregunta + ", Enunciado: " + enunciado + ", ID respuesta: " + idRespuesta + ", Respuesta: " + respuesta);


        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        
    }

    }

    




}