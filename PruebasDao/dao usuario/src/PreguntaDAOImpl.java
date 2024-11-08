import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreguntaDAOImpl {
    
    private Connection conexion;
    public PreguntaDAOImpl(Connection conexion){
        this.conexion = conexion;
    }


    public void insertarPregunta(Pregunta pregunta){
        String query = "INSERT INTO pregunta( enunciado, tipo_pregunta, categoria, valor_aproximado) VALUES (?,?,?,?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)){

            statement.setString(1, pregunta.getEnunciado());
            statement.setString(2, pregunta.getTipoPregunta());
            statement.setString(3, pregunta.getCategoria());
            statement.setInt(4, pregunta.getValorAproximado());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace(); 
        }
    }


    
}
