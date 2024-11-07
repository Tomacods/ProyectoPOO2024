import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/Los8Escalones";
        String usuario = "postgres";
        String password = "7508";

        // Cargar el controlador JDBC
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Controlador no encontrado. Asegúrate de tener el JAR del controlador en tu classpath.");
            e.printStackTrace();
            return; // Termina el programa si no se puede cargar el controlador
        }

        // Intentar conectarse a la base de datos
        try (Connection conexion = DriverManager.getConnection(url, usuario, password)) {
            JugadorDAO jugadorDAO = new JugadorDAOImpl(conexion);

            // Insertar un nuevo jugador
            Jugador nuevoJugador = new Jugador(0, "Mora", "Molina", "moramo@gmail.com", 208, "eliminado");
            jugadorDAO.insertarJugador(nuevoJugador);

            System.out.println("Jugador insertado exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        }
    }
}
