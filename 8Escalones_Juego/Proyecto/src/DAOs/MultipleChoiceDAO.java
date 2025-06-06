package DAOs;

import Modelos.MultipleChoicePregunta;
import Modelos.Respuesta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO (Data Access Object) class for managing Multiple Choice questions in the database.
 * Provides methods to insert, update, delete, and retrieve multiple choice questions and their associated answers.
 * 
 * <p>
 * This class interacts with the "pregunta_multiple_choise" table and uses {@link RespuestaDAO}
 * for handling related answers.
 * </p>
 * 
 * <ul>
 *   <li>{@link #insertarPreguntaMultipleChoise(MultipleChoicePregunta, List)}: Inserts a new multiple choice question and its answers.</li>
 *   <li>{@link #actualizarPreguntaMC(MultipleChoicePregunta)}: Updates an existing multiple choice question.</li>
 *   <li>{@link #eliminarPreguntaMC(int)}: Deletes a multiple choice question and its answers.</li>
 *   <li>{@link #obtenerPreguntaMC(int)}: Retrieves a multiple choice question by its ID.</li>
 *   <li>{@link #obtenerTodasLasPreguntaMC()}: Retrieves all multiple choice questions.</li>
 *   <li>{@link #obtenerPreguntasMCPorTematica(int)}: Retrieves all questions for a specific topic.</li>
 *   <li>{@link #obtenerPreguntaConRespuestas(int)}: Retrieves a question along with its answers.</li>
 * </ul>
 * 
 * <p>
 * Usage of this class requires a valid database connection managed by {@link BaseDeDatos}.
 * </p>
 * 
 * @author 
 */
public class MultipleChoiceDAO {

    /*
     * private Connection connection;
     * private RespuestaDAO rta;
     */
    private final BaseDeDatos connection = BaseDeDatos.obtenerInstancia();
    private final RespuestaDAO rta;

    /*
     * public MultipleChoiceDAO(Connection connection, RespuestaDAO rta){
     * this.connection= connection;
     * this.rta= rta;
     * }
     */
    public MultipleChoiceDAO() {
        this.rta = new RespuestaDAO(); // para inicializar

    }

    public void insertarPreguntaMultipleChoise(MultipleChoicePregunta pregunta, List<Respuesta> respuestas)
            throws SQLException {
        String queryPregunta = "INSERT INTO Pregunta_multiple_choise (Enunciado, ID_Tematica) VALUES (?, ?)";

        try (PreparedStatement statementPregunta = BaseDeDatos.prepareStatement(queryPregunta,
                PreparedStatement.RETURN_GENERATED_KEYS)) {

            statementPregunta.setString(1, pregunta.getEnunciado());
            statementPregunta.setInt(2, pregunta.getIdTematica());
            statementPregunta.executeUpdate();

            try (ResultSet generatedKeys = statementPregunta.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idPregunta = generatedKeys.getInt(1);

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

    /*
     * public void insertarPregunta(MultipleChoicePregunta pregunta){
     * String
     * query="INSERT INTO pregunta_multiple_choise(enunciado, id_tematica) VALUES (?,?)"
     * ;
     * try(PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
     * statement.setString(1, pregunta.getEnunciado());
     * statement.setInt(2, pregunta.getIdTematica());
     * statement.executeUpdate();
     * } catch (SQLException e) {
     * e.printStackTrace();
     * }
     * 
     * }
     */

    public void actualizarPreguntaMC(MultipleChoicePregunta pregunta) {
        String query = "UPDATE pregunta_multiple_choise SET enunciado=?, id_tematica=? WHERE id_pregunta_mc =?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setString(1, pregunta.getEnunciado());
            statement.setInt(2, pregunta.getIdTematica());
            statement.setInt(3, pregunta.getIdPregunta());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void eliminarPreguntaMC(int id) {
        rta.eliminarRespuestaPregunta(id);
        String query = "DELETE FROM pregunta_multiple_choise WHERE id_pregunta_mc= ?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // QUERYS
    public MultipleChoicePregunta obtenerPreguntaMC(int id_pregunta) throws SQLException {
        String query = "SELECT * FROM pregunta_multiple_choise WHERE id_pregunta_mc = ?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setInt(1, id_pregunta);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new MultipleChoicePregunta(
                            resultSet.getInt("ID_pregunta_mc"),
                            resultSet.getString("enunciado"),
                            resultSet.getInt("id_tematica"));
                }
            }
        } catch (SQLException ex) {
            throw new SQLException("Error al obtener pregunta: " + ex.getMessage());
        }
        return null;
    }
    public ArrayList<Object[]> obtenerTodasLasPreguntaMC() throws SQLException {
        ArrayList<Object[]> preguntas = new ArrayList<>();
        String query = "SELECT * FROM pregunta_multiple_choise";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Object[] row = {
                        resultSet.getInt("ID_pregunta_mc"),
                        resultSet.getString("enunciado"),
                        resultSet.getInt("ID_Tematica")
                };
                preguntas.add(row);
            }
        }
        return preguntas;
    }

    public ArrayList<Object[]> obtenerPreguntasMCPorTematica(int id) { // DEVUELVE LAS PREGUNTAS DE CIERTA TEMATICA
                                                                       // (SEGUN EL ID)
        ArrayList<Object[]> preguntas = new ArrayList<>();
        String query = "select p.id_pregunta_mc,  p.enunciado, p.id_tematica from pregunta_multiple_choise p inner join tematica t on p.id_tematica = t.id_tematica where t.id_tematica=?";

        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
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

    public MultipleChoicePregunta obtenerPreguntaConRespuestas(int id_pregunta) throws SQLException {
        String queryPregunta = "SELECT * FROM pregunta_multiple_choise WHERE id_pregunta_mc = ?";
        MultipleChoicePregunta pregunta = null;

        try (PreparedStatement statementPregunta = BaseDeDatos.prepareStatement(queryPregunta)) {
            statementPregunta.setInt(1, id_pregunta);
            try (ResultSet resultSetPregunta = statementPregunta.executeQuery()) {
                if (resultSetPregunta.next()) {
                    pregunta = new MultipleChoicePregunta(
                            resultSetPregunta.getInt("ID_pregunta_mc"),
                            resultSetPregunta.getString("enunciado"),
                            resultSetPregunta.getInt("id_tematica"));
                }
            }
        }

        if (pregunta != null) {
            List<Object[]> objetosRespuestas = rta.obtenerRespuestasPorPregunta(id_pregunta);
            List<Respuesta> respuestas = new ArrayList<>();

            for (Object[] obj : objetosRespuestas) {
                Respuesta respuesta = new Respuesta(
                        (int) obj[0], // ID de respuesta
                        (int) obj[1], // ID de pregunta
                        (String) obj[2], // Texto
                        (boolean) obj[3] // Es correcta
                );
                respuestas.add(respuesta);
            }

            for (Respuesta respuesta : respuestas) {
                pregunta.agregarRespuesta(respuesta);
            }
        }

        return pregunta;
    }
}

/*
 * public MultipleChoiceDAO(Connection Connection){
 * this.connection= connection;
 * }
 * public void insertarOpciones(int id_pregunta, List<String> opciones, String
 * opcionCorrecta){
 * 
 * if (opciones.size() != 4) {
 * System.err.println("Una pregunta solo puede tener 4 opciones.");
 * return;
 * }
 * 
 * String query =
 * "INSERT INTO respuesta (id_pregunta, texto, correcta) VALUES (?,?,?)";
 * try(PreparedStatement statement = connection.prepareStatement(query)) {
 * for (String opcion : opciones){
 * statement.setInt(1, id_pregunta );
 * statement.setString(2, opcion);
 * statement.setBoolean(3, opcion.equals(opcionCorrecta));
 * }
 * 
 * } catch (SQLException e) {
 * e.printStackTrace();
 * }
 * 
 * 
 * }
 */
