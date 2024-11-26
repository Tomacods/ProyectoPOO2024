package controlador;
import java.sql.SQLException;
public interface EstrategiaPregunta {
    void traerPreguntas(int idTematica) throws SQLException;
}