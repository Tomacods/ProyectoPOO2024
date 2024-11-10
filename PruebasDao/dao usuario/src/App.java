import java.sql.Connection;

public class App {
    public static void main(String[] args) {

        BaseDeDatos bd = BaseDeDatos.obtenerInstancia();
        Connection connection = bd.getConnection();

        if (connection!=null){
            System.out.println("conexion exitosa con la bd");

            JugadorDAOImpl jugadorDAO = new JugadorDAOImpl(connection);

            
           // Jugador jugadorEjemplo = new Jugador(0,"Jugador de prueba DAO", 0, "eliminado");
           // jugadorDAO.insertarJugador(jugadorEjemplo);
            System.out.println("insertado correctamente.");
           // jugadorDAO.eliminarJugador(0);
            
        }

    } 
}

