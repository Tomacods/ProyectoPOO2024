package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelos.Respuesta;


public class RespuestaDAO {
    private connection connection;

public RespuestaDAO(Connection connection){
        this.connection = connection;
    }

//ABM

public void insertarRespuesta(Respuesta respuesta) throws SQLException {
    String query = "INSERT INTO Respuesta (ID_Pregunta, Texto, Correcta) VALUES (?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, respuesta.getIdPregunta());
        statement.setString(2, respuesta.getTexto());
        statement.setBoolean(3, respuesta.isEsCorrecta());
        statement.executeUpdate();
    }catch (SQLException ex){
        throw new SQLException("Error al insertar respuesta: " + ex.getMessage());
    }
}

public void actualizarRespuesta(Respuesta respuesta) throws SQLException {
    String query = "UPDATE Respuesta SET ID_Pregunta = ?, Texto = ?, Correcta = ? WHERE ID_Respuesta = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, respuesta.getIdPregunta());
        statement.setString(2, respuesta.getTexto());
        statement.setBoolean(3, respuesta.isEsCorrecta());
        statement.setInt(4, respuesta.getIdRespuesta());
        statement.executeUpdate();
    }
}

public void eliminarRespuesta(int idRespuesta) throws SQLException {
    String query = "DELETE FROM Respuesta WHERE ID_Respuesta = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, idRespuesta);
        statement.executeUpdate();
    }
}



public Respuesta obtenerRespuesta (int idRespuesta) throws SQLException {
    String query = "SELECT * FROM Respuesta WHERE ID_Respuesta = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, idRespuesta);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return new Respuesta(
                        resultSet.getInt("ID_Respuesta"),
                        resultSet.getInt("ID_Pregunta"),
                        resultSet.getString("Texto"),
                        resultSet.getBoolean("Correcta")
                );
            }
        }
    }catch (SQLException ex){
        throw new SQLException("Error al obtener respuesta: " + ex.getMessage());
    }
    return null;
}
public List<Respuesta> obtenerRespuestasPorPregunta(int idPregunta) throws SQLException {
    List<Respuesta> respuestas = new ArrayList<>();
    String query = "SELECT * FROM Respuesta WHERE ID_Pregunta = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, idPregunta);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                respuestas.add(new Respuesta(
                        resultSet.getInt("ID_Respuesta"),
                        resultSet.getInt("ID_Pregunta"),
                        resultSet.getString("Texto"),
                        resultSet.getBoolean("Correcta")
                ));
            }
        }
    }catch (SQLException ex){
        throw new SQLException("Error al obtener respuestas: " + ex.getMessage());
    }
    return respuestas;
}

public List<Respuesta> obtenerTodasLasRespuestas() throws SQLException {
    List<Respuesta> respuestas = new ArrayList<>();
    String query = "SELECT * FROM Respuesta";
    try (PreparedStatement statement = connection.prepareStatement(query);
         ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
            Respuesta respuesta = new Respuesta(
                resultSet.getInt("ID_Respuesta"),
                resultSet.getInt("ID_Pregunta"),
                resultSet.getString("Texto"),
                resultSet.getBoolean("Correcta")
            );
            respuestas.add(respuesta);
        }
    }
    return respuestas;
}
}
