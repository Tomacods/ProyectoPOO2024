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
    public void insertarOpcionesMC(MultipleChoicePregunta pregunta) {
        String query = "INSERT INTO respuesta (id_pregunta, texto, correcta) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            for (String opcion : pregunta.getOpciones()) {
                statement.setInt(1, pregunta.getIdPregunta());
                statement.setString(2, opcion);
                statement.setBoolean(3, opcion.equals(pregunta.getRespuestaCorrecta()));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
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

private int obtenerIdPregunta(String enunciado, int id_tematica) {
    String query = "SELECT id_pregunta_mc FROM pregunta_multiple_choise WHERE enunciado = ? and id_tematica= ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, enunciado);
        statement.setInt(2, id_tematica);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) { //herramienta para trabajar con los resultados de las consultas SQL https://www.arquitecturajava.com/java-resultset-un-ejemplo-sencillo-con-persona/
            return resultSet.getInt("id_pregunta_mc");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return -1;  //va a retornar -1 cuadno no encuentre el id

}

public void obtenerPreguntasporTematica(String tematica){
    String query = "select  p.enunciado from pregunta_multiple_choise p inner join tematica t on p.id_tematica = t.id_tematica where t.nombre_tematica=?";
    try(PreparedStatement statement = connection.prepareStatement(query)){
        statement.setString(1, tematica);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            String enunciado = resultSet.getString("enunciado");
            System.out.println(enunciado);

        }

    }catch (SQLException e) {
        e.printStackTrace();
    }
}


public void obtenerPyR(MultipleChoicePregunta pregunta){
    int idPregunta= obtenerIdPregunta(pregunta.getEnunciado(), pregunta.getId_tematica());
    if (idPregunta != -1){
        String query = "select p.enunciado, p.categoria, r.texto from pregunta_multiple_choise p inner join respuesta r  on p.id_pregunta_mc = r.id_pregunta where id_pregunta_mc = ?";
    try(PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, idPregunta);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String enunciado = resultSet.getString("Enunciado");
            String categoria = resultSet.getString("categoria");
            String texto = resultSet.getString("texto");
            System.out.println("Enunciado: " + enunciado + ", categoria: " + categoria + "Opcion: " + texto);
            
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }else{
        System.out.println("no se encontro la pregunta: " + pregunta.getEnunciado());

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