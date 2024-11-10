import java.math.BigDecimal;
import java.sql.Connection;

public class App {
    public static void main(String[] args) {

        BaseDeDatos bd = BaseDeDatos.obtenerInstancia();
        Connection connection = bd.getConnection();

        if (connection!=null){
            System.out.println("conexion exitosa con la bd");

            JugadorDAOImpl jugadorDAO = new JugadorDAOImpl(connection);
            PreguntaAproxDAO pregunta_aproxDAO = new PreguntaAproxDAO(connection);

        PreguntaAproximacion preguntaaproxejemplo = new PreguntaAproximacion(0, "PRUEBA DAO", "Aproximacion", new BigDecimal(78.45), 1);
          //  pregunta_aproxDAO.insertarPreguntaAprox(preguntaaproxejemplo);
            preguntaaproxejemplo.setCategoria("deporte");
            pregunta_aproxDAO.actualizarPreguntaAprox(preguntaaproxejemplo);
           // Jugador jugadorEjemplo = new Jugador(0,"Jugador de prueba DAO", 0, "eliminado");
           // jugadorDAO.insertarJugador(jugadorEjemplo);
            System.out.println("insertado correctamente.");
           // jugadorDAO.eliminarJugador(0);
            
        }

    } 
}

