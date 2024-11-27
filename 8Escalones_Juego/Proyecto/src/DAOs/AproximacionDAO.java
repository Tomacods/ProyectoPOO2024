package DAOs;

import Modelos.PreguntaAproximacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AproximacionDAO {
    private BaseDeDatos connection = BaseDeDatos.obtenerInstancia();

    public AproximacionDAO() {
    }

    public void insertarPreguntaAproximacion(PreguntaAproximacion pregunta) throws SQLException {
        String query = "INSERT INTO Pregunta_aproximacion (Enunciado, Valor_Aproximado, ID_Tematica) VALUES (?, ?, ?)";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setString(1, pregunta.getEnunciado());
            statement.setInt(2, pregunta.getValorAproximado());
            statement.setInt(3, pregunta.getIdTematica());
            statement.executeUpdate();
        }
    }

    public void actualizarPreguntaAproximacion(PreguntaAproximacion pregunta) throws SQLException {
        String query = "UPDATE Pregunta_aproximacion SET Enunciado = ?, Valor_Aproximado = ?, ID_Tematica = ? WHERE ID_Pregunta = ?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setString(1, pregunta.getEnunciado());
            statement.setInt(2, pregunta.getValorAproximado());
            statement.setInt(3, pregunta.getIdTematica());
            statement.setInt(4, pregunta.getIdPregunta());
            statement.executeUpdate();
        }
    }

    public void eliminarPreguntaAproximacion(int idPregunta) throws SQLException {
        String query = "DELETE FROM Pregunta_aproximacion WHERE ID_Pregunta = ?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setInt(1, idPregunta);
            statement.executeUpdate();
        }
    }

    public PreguntaAproximacion obtenerPreguntaAproximacion(int idPregunta) throws SQLException {
        String query = "SELECT * FROM Pregunta_aproximacion WHERE ID_Pregunta = ?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setInt(1, idPregunta);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new PreguntaAproximacion(
                            resultSet.getInt("ID_Pregunta"),
                            resultSet.getString("Enunciado"),
                            resultSet.getInt("ID_Tematica"),
                            resultSet.getInt("Valor_Aproximado"));
                }
            }
        }
        return null;
    }

    public ArrayList<Object[]> obtenerTodasLasPreguntasAproximacion() throws SQLException {
        ArrayList<Object[]> preguntas = new ArrayList<>();
        String query = "SELECT * FROM Pregunta_aproximacion";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Object[] row = {
                        resultSet.getInt("ID_Pregunta"),
                        resultSet.getString("Enunciado"),
                        resultSet.getInt("ID_Tematica"),
                        resultSet.getInt("Valor_Aproximado")

                };
                preguntas.add(row);
            }
        }
        return preguntas;
    }

    // devolver pregunta por id
    public ArrayList<Object[]> obtenerPreguntasPorTematica(int idTematica) throws SQLException {
        ArrayList<Object[]> preguntas = new ArrayList<>();
        String query = "select p.id_pregunta,  p.enunciado, p.valor_aproximado, p.id_tematica from pregunta_aproximacion p inner join tematica t on p.id_tematica = t.id_tematica where t.id_tematica=?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setInt(1, idTematica);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Object[] pregunta = {
                        resultSet.getInt("id_pregunta"),
                        resultSet.getString("enunciado"),
                        resultSet.getInt("valor_aproximado"),
                        resultSet.getInt("id_tematica")
                };
                preguntas.add(pregunta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preguntas;
    }

    // metodo para obtener la respuesta correcta de una pregunta
    public int obtenerValorAproximado(int idPregunta) throws SQLException {
        String query = "SELECT Valor_Aproximado FROM Pregunta_aproximacion WHERE ID_Pregunta = ?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
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
