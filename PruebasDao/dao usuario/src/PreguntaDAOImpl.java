import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreguntaDAOImpl {
    
    private Connection connection;
    public PreguntaDAOImpl(Connection connection){
        this.connection = connection;
    }


    public void insertarPregunta(Pregunta pregunta){
        String query = "INSERT INTO pregunta( enunciado, tipo_pregunta, categoria, valor_aproximado) VALUES (?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1, pregunta.getEnunciado());
            statement.setString(2, pregunta.getTipoPregunta());
            statement.setString(3, pregunta.getCategoria());
            if (pregunta instanceof PreguntaAproximacion) { //si es pregunta por aproximacion
                
                statement.setInt(4, ((PreguntaAproximacion) pregunta).getValorAproximado());
            } else {
                statement.setInt(4, 0); 
            }
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace(); 
        }
    }

    public void actualizarPregunta(Pregunta pregunta){
        String query = "UPDATE pregunta SET enunciado= ?, tipo_pregunta= ?, categoria=?, valor_aproximado=? ";
        try( PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, pregunta.getEnunciado());
            statement.setString(2, pregunta.getTipoPregunta());
            statement.setString(3, pregunta.getCategoria());
           // statement.setInt(4, 0);
        }
    }


    
}
