import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Singleton
public class BaseDeDatos {
    private Connection connection;
    private static BaseDeDatos bd;
    private String url = "jdbc:postgresql://localhost/";
    private String nombre="Los8Escalones";
    private String usuario="postgres";
    private String clave="7508";

    private BaseDeDatos() {
        try {

            Class.forName("org.postgresql.Driver");
            this.setConnection(DriverManager.getConnection(url + nombre, usuario, clave)); 
        } catch (ClassNotFoundException e) {
            System.err.println("no se encontró el driver de PostgreSQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("no se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
    }
    

public static BaseDeDatos obtenerInstancia() {
    if (bd == null) {
        bd = new BaseDeDatos();
    }
    return bd;
}

public Connection getConnection() {
    return connection;
}

private void setConnection(Connection connection) {
    this.connection = connection;
}

}
