import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TematicaDAOImpl {
    private Connection connection;

    public TematicaDAOImpl(Connection connection){
        this.connection= connection;

    }

    public void insertarTematica(Tematica tematica){
        String query = "INSERT INTO tematica(nombre_tematica)";
        try(PreparedStatement statement = connection.prepareStatement(query)){
        statement.setString(1, tematica.getNombre());
        statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace(); 
        }
    }
    public void actualizarTematica(Tematica tematica){
        String query= "UPDATE tematica SET nombre_tematica = ? WHERE id_tematica = ?";
        try(
            PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, tematica.getNombre());
                statement.setInt(2, tematica.getId());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void eliminarTematica(int id_tematica){
            String query = "DELETE FROM tematica WHERE id_tematica = ?";
            try(
                PreparedStatement statement = connection.prepareStatement(query)){
                    statement.setInt(1, id_tematica);
                    statement.executeUpdate();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }

}
