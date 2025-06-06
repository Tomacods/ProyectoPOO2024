package DAOs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Singleton
/**
 * La clase BaseDeDatos implementa un patrón Singleton para gestionar la conexión a una base de datos PostgreSQL.
 * Proporciona métodos para obtener la instancia única, ejecutar consultas y sentencias de inserción, y preparar sentencias SQL.
 * 
 * <p>Características principales:</p>
 * <ul>
 *   <li>Conexión única a la base de datos definida por los atributos {@code url}, {@code nombre}, {@code usuario} y {@code clave}.</li>
 *   <li>Método {@link #obtenerInstancia()} para acceder a la instancia única de la clase.</li>
 *   <li>Método {@link #query(PreparedStatement)} para ejecutar consultas SQL y obtener un {@link ResultSet}.</li>
 *   <li>Método {@link #insert(String)} para ejecutar sentencias de inserción, actualización o eliminación.</li>
 *   <li>Métodos {@link #prepareStatement(String)} y {@link #prepareStatement(String, int)} para preparar sentencias SQL parametrizadas.</li>
 *   <li>Método {@link #getConnection()} para obtener la conexión actual.</li>
 * </ul>
 * 
 * <p>Nota: Es necesario modificar los datos de conexión para adaptarlos a la configuración local de cada usuario.</p>
 * 
 * <p>Ejemplo de uso:</p>
 * <pre>
 *     BaseDeDatos bd = BaseDeDatos.obtenerInstancia();
 *     PreparedStatement ps = bd.prepareStatement("SELECT * FROM tabla WHERE id = ?");
 *     ps.setInt(1, 1);
 *     ResultSet rs = bd.query(ps);
 * </pre>
 * 
 * @author tomas
 */
public class BaseDeDatos {
    private static Connection connection;
    private static BaseDeDatos bd;
    private String url = "jdbc:postgresql://localhost/"; //SI LO VAN A USAR TIENEN Q CAMBIAR LOS DATOS CON SU COMPU
    private String nombre="8Escalones";
    private String usuario="postgres";
    private String clave="1234";
    
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
    
    private void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ResultSet query(PreparedStatement querysStatement) {
                ResultSet rs= null;
                try {
                    rs = querysStatement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return rs;
            }
    
    public Boolean insert(String query) {
                try {
                    Statement statement = getConnection().createStatement();
                    //executeUpdate es para realizar insert, update o delete, esto devuelve 1 
                    int res1 =statement.executeUpdate(query);
                    if(res1 == 1) {
                        return true;
                    }
                    return false;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            
    public Connection getConnection() {
                return connection;
            }
            
    public static PreparedStatement prepareStatement(String query) throws SQLException {
                return connection.prepareStatement(query);
        }
    
    public static PreparedStatement prepareStatement(String query, int autoGeneratedKeys) throws SQLException {
            return connection.prepareStatement(query, autoGeneratedKeys);
        }
}
