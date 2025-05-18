package controlador;
import java.sql.SQLException;

/**
 * EstrategiaPregunta defines the contract for strategies that handle the retrieval of questions
 * based on a specific thematic identifier.
 * <p>
 * Implementations of this interface should provide the logic to fetch questions
 * from a data source, such as a database, according to the given thematic ID.
 * </p>
 */
public interface EstrategiaPregunta {
    void traerPreguntas(int idTematica) throws SQLException;
}