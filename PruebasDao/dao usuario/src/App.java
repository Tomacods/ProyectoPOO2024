import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/Los8Escalones";
        String usuario = "postgres";
        String password = "7508";

        try (Connection conexion = DriverManager.getConnection(url, usuario, password)) {
            JugadorDAO jugadorDAO = new JugadorDAOImpl(conexion);

            // Insertar un nuevo usuario
            Jugador nuevoJugador = new Jugador(0, "Mora", "Molina", "moramo@gmail",208, "eliminado");
            jugadorDAO.insertarJugador(nuevoJugador);


            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
