import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JugadorDAOImpl implements JugadorDAO {
    private Connection conexion;
    public JugadorDAOImpl(Connection conexion){
        this.conexion = conexion;
    }


    @Override
    public Jugador obtenerJugadorPorId(int id) {
        Jugador jugador = null;
        String query = "SELECT * FROM jugador WHERE id_jugador = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                jugador = new Jugador(rs.getInt("id_jugador"), rs.getString("nombre"), 
                rs.getString("apellido"), rs.getString("correo"),
                rs.getInt("puntaje"), rs.getString("estado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugador;
    }
    @Override
    public void insertarJugador(Jugador jugador){
        String query = "INSERT INTO jugador(id_jugador, nombre, apellido, correo, puntaje, estado) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)){
            statement.setInt(1, jugador.getId());
            statement.setString(2, jugador.getNombre());
            statement.setString(3, jugador.getApellido());
            statement.setString(4, jugador.getCorreo());
            statement.setInt(5, jugador.getPuntaje());
            statement.setString(6, jugador.getEstado());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace(); 
        }
    }


    @Override
    public void actualizarJugador(Jugador jugador) {
        String query = "UPDATE jugador SET nombre = ?, apellido = ?, correo= ?, puntaje=?, estado=? WHERE id_jugador= ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, jugador.getNombre());
            statement.setString(2, jugador.getApellido());
            statement.setString(3, jugador.getCorreo());
            statement.setInt(4, jugador.getPuntaje());
            statement.setString(5, jugador.getEstado());
            statement.setInt(6, jugador.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarJugador(int id) {
        String query = "DELETE FROM jugador WHERE id_jugador = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

