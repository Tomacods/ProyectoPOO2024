package DAOs;

import Modelos.Respuesta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * RespuestaDAO es una clase de acceso a datos (DAO) para gestionar operaciones CRUD 
 * relacionadas con la entidad Respuesta en la base de datos. Proporciona métodos para 
 * insertar, actualizar, eliminar y consultar respuestas, así como obtener respuestas 
 * asociadas a preguntas específicas y la respuesta correcta en preguntas de tipo 
 * multiple choice.
 * 
 * Métodos principales:
 * <ul>
 *   <li>{@link #insertarRespuesta(Respuesta)}: Inserta una nueva respuesta en la base de datos.</li>
 *   <li>{@link #actualizarRespuesta(Respuesta)}: Actualiza una respuesta existente.</li>
 *   <li>{@link #eliminarRespuesta(int)}: Elimina una respuesta por su ID.</li>
 *   <li>{@link #eliminarRespuestaPregunta(int)}: Elimina todas las respuestas asociadas a una pregunta.</li>
 *   <li>{@link #obtenerRespuesta(int)}: Obtiene una respuesta específica por su ID.</li>
 *   <li>{@link #obtenerRespuestasPorPregunta(int)}: Obtiene todas las respuestas asociadas a una pregunta.</li>
 *   <li>{@link #obtenerTodasLasRespuestas()}: Obtiene todas las respuestas de la base de datos.</li>
 *   <li>{@link #obtenerIdRtaCorrectaMC(int)}: Obtiene el ID de la respuesta correcta para una pregunta de tipo multiple choice.</li>
 * </ul>
 * 
 * Utiliza la clase BaseDeDatos para gestionar la conexión y ejecución de sentencias SQL.
 * 
 * @author tu_nombre
 */
public class RespuestaDAO {
    private final BaseDeDatos connection = BaseDeDatos.obtenerInstancia();

    public RespuestaDAO() {
    }

    // ABM
    public void insertarRespuesta(Respuesta respuesta) throws SQLException {
        String query = "INSERT INTO Respuesta (ID_Pregunta, Texto, Correcta) VALUES (?, ?, ?)";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setInt(1, respuesta.getIdPregunta());
            statement.setString(2, respuesta.getTexto());
            statement.setBoolean(3, respuesta.isEsCorrecta());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Error al insertar respuesta: " + ex.getMessage());
        }
    }

    public void actualizarRespuesta(Respuesta respuesta) throws SQLException {
        String query = "UPDATE Respuesta SET ID_Pregunta = ?, Texto = ?, Correcta = ? WHERE ID_Respuesta = ?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setInt(1, respuesta.getIdPregunta());
            statement.setString(2, respuesta.getTexto());
            statement.setBoolean(3, respuesta.isEsCorrecta());
            statement.setInt(4, respuesta.getIdRespuesta());
            statement.executeUpdate();
        }
    }

    public void eliminarRespuesta(int idRespuesta) throws SQLException {
        String query = "DELETE FROM Respuesta WHERE ID_Respuesta = ?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setInt(1, idRespuesta);
            statement.executeUpdate();
        }
    }

    public void eliminarRespuestaPregunta(int id_pregunta) { // se usa al eliminar una pregunta
        String query = "DELETE FROM respuesta WHERE ID_Pregunta = ?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setInt(1, id_pregunta);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Respuesta obtenerRespuesta(int idRespuesta) throws SQLException {
        String query = "SELECT * FROM Respuesta WHERE ID_Respuesta = ?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setInt(1, idRespuesta);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Respuesta(
                            resultSet.getInt("ID_Respuesta"),
                            resultSet.getInt("ID_Pregunta"),
                            resultSet.getString("Texto"),
                            resultSet.getBoolean("Correcta"));
                }
            }
        } catch (SQLException ex) {
            throw new SQLException("Error al obtener respuesta: " + ex.getMessage());
        }
        return null;
    }

    public ArrayList<Object[]> obtenerRespuestasPorPregunta(int idPregunta) throws SQLException {
        ArrayList<Object[]> respuestas = new ArrayList<>();
        String query = "SELECT * FROM Respuesta WHERE ID_Pregunta = ?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setInt(1, idPregunta);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Object[] fila = new Object[] {
                            resultSet.getInt("ID_Respuesta"),
                            resultSet.getInt("ID_Pregunta"),
                            resultSet.getString("Texto"),
                            resultSet.getBoolean("Correcta")
                    };
                    respuestas.add(fila);
                }
            }
        } catch (SQLException ex) {
            throw new SQLException("Error al obtener respuestas: " + ex.getMessage());
        }
        return respuestas;
    }

    public List<Respuesta> obtenerTodasLasRespuestas() throws SQLException {
        List<Respuesta> respuestas = new ArrayList<>();
        String query = "SELECT * FROM Respuesta";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Respuesta respuesta = new Respuesta(
                        resultSet.getInt("ID_Respuesta"),
                        resultSet.getInt("ID_Pregunta"),
                        resultSet.getString("Texto"),
                        resultSet.getBoolean("Correcta"));
                respuestas.add(respuesta);
            }
        }
        return respuestas;
    }

    public int obtenerIdRtaCorrectaMC(int id_pregunta) {
        String query = "select  id_respuesta, texto from respuesta inner join pregunta_multiple_choise p on p.id_pregunta_mc = respuesta.id_pregunta\n"
                + //
                "where  p.id_pregunta_mc=? and respuesta.correcta = 'True'";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setInt(1, id_pregunta);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id_respuesta = resultSet.getInt("id_respuesta");
                String enunciado = resultSet.getString("texto");
                System.out.println(enunciado);
                return id_respuesta;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // si no la encuentra devuelve -1

    }

}
