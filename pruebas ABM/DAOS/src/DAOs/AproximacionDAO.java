package DAOs;

import Modelos.PreguntaAproximacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AproximacionDAO {
    Connection  connection;
public AproximacionDAO(Connection connection){
        this.connection = connection;
    }

    public void insertarPreguntaAproximacion(PreguntaAproximacion pregunta) throws SQLException {
        String query = "INSERT INTO Pregunta_aproximacion (Enunciado, Valor_Aproximado, ID_Tematica) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, pregunta.getEnunciado());
            statement.setInt(2, pregunta.getValorAproximado());
            statement.setInt(3, pregunta.getIdTematica());
            statement.executeUpdate();
        }
    }

    public void actualizarPreguntaAproximacion(PreguntaAproximacion pregunta) throws SQLException {
        String query = "UPDATE Pregunta_aproximacion SET Enunciado = ?, Valor_Aproximado = ?, ID_Tematica = ? WHERE ID_Pregunta = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, pregunta.getEnunciado());
            statement.setInt(2, pregunta.getValorAproximado());
            statement.setInt(3, pregunta.getIdTematica());
            statement.setInt(4, pregunta.getIdPregunta());
            statement.executeUpdate();
        }
    }

    public void eliminarPreguntaAproximacion(int idPregunta) throws SQLException {
        String query = "DELETE FROM Pregunta_aproximacion WHERE ID_Pregunta = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPregunta);
            statement.executeUpdate();
        }
    }

    public PreguntaAproximacion obtenerPreguntaAproximacion(int idPregunta) throws SQLException {
        String query = "SELECT * FROM Pregunta_aproximacion WHERE ID_Pregunta = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPregunta);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new PreguntaAproximacion(
                        resultSet.getInt("ID_Pregunta"),
                        resultSet.getString("Enunciado"),
                        resultSet.getInt("Valor_Aproximado"),
                        resultSet.getInt("ID_Tematica")
                    );
                }
            }
        }
        return null;
    }
    public List<PreguntaAproximacion> obtenerTodasLasPreguntasAproximacion() throws SQLException {
        List<PreguntaAproximacion> preguntas = new ArrayList<>();
        String query = "SELECT * FROM Pregunta_aproximacion";
        try (PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                PreguntaAproximacion pregunta = new PreguntaAproximacion(
                    resultSet.getInt("ID_Pregunta"),
                    resultSet.getString("Enunciado"),
                    resultSet.getInt("Valor_Aproximado"),
                    resultSet.getInt("ID_Tematica")
                );
                preguntas.add(pregunta);
            }
        }
        return preguntas;
    }
    //devolver pregunta por id
    public List<PreguntaAproximacion> obtenerPreguntasPorTematica(int idTematica) throws SQLException {
        List<PreguntaAproximacion> preguntas = new ArrayList<>();
        String query = "SELECT * FROM Pregunta_aproximacion WHERE ID_Tematica = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idTematica);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    PreguntaAproximacion pregunta = new PreguntaAproximacion(
                        resultSet.getInt("ID_Pregunta"),
                        resultSet.getString("Enunciado"),
                        resultSet.getInt("Valor_Aproximado"),
                        resultSet.getInt("ID_Tematica")
                    );
                    preguntas.add(pregunta);
                }
            }
        }
        return preguntas;
    }
    //metodo para obtener la respuesta correcta de una pregunta
    public int obtenerValorAproximado(int idPregunta) throws SQLException {
        String query = "SELECT Valor_Aproximado FROM Pregunta_aproximacion WHERE ID_Pregunta = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPregunta);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Valor_Aproximado");
                }
            }
        }
        return -1;
    }
}
