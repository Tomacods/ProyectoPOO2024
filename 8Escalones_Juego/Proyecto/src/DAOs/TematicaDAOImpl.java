package DAOs;

import Modelos.Tematica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * TematicaDAOImpl provides data access methods for the "tematica" table in the database.
 * It implements basic CRUD (Create, Read, Update, Delete) operations for Tematica entities.
 * 
 * <p>
 * Methods:
 * <ul>
 *   <li>{@link #insertarTematica(Tematica)}: Inserts a new Tematica into the database.</li>
 *   <li>{@link #actualizarTematica(Tematica)}: Updates an existing Tematica in the database.</li>
 *   <li>{@link #eliminarTematica(int)}: Deletes a Tematica by its ID.</li>
 *   <li>{@link #obtenerTematicas()}: Retrieves all Tematicas as a list of Object arrays.</li>
 *   <li>{@link #obtenerTematica(int)}: Retrieves a single Tematica by its ID.</li>
 * </ul>
 * </p>
 * 
 * <p>
 * This class uses a singleton instance of {@link BaseDeDatos} to manage database connections.
 * All SQLExceptions are either printed to the stack trace or rethrown with a custom message.
 * </p>
 */
public class TematicaDAOImpl {
    private final BaseDeDatos connection = BaseDeDatos.obtenerInstancia();

    // private final Connection connection;

    public TematicaDAOImpl() {

    }

    // ABM

    public void insertarTematica(Tematica tematica) {
        String query = "INSERT INTO tematica (nombre_tematica) VALUES (?)";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setString(1, tematica.getNombre());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarTematica(Tematica tematica) {
        String query = "UPDATE tematica SET nombre_tematica = ? WHERE id_tematica = ?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setString(1, tematica.getNombre());
            statement.setInt(2, tematica.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarTematica(int id_tematica) {
        String query = "DELETE FROM tematica WHERE id_tematica = ?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setInt(1, id_tematica);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // QUERYS
    public ArrayList<Object[]> obtenerTematicas() { // DEVUELVE LAS TEMATICAS
        ArrayList<Object[]> tematicas = new ArrayList<>();
        String query = "SELECT * FROM tematica";

        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Object[] row = {
                        resultSet.getInt("id_tematica"),
                        resultSet.getString("nombre_tematica")
                };
                tematicas.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tematicas;
    }

    public Tematica obtenerTematica(int id_tematica) throws SQLException {
        String query = "SELECT * FROM tematica WHERE id_tematica = ?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setInt(1, id_tematica);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Tematica(
                            resultSet.getInt("id_tematica"),
                            resultSet.getString("nombre_tematica"));
                }
            }
        } catch (SQLException ex) {
            throw new SQLException("Error al obtener tematica: " + ex.getMessage());
        }
        return null;
    }

}
