import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelos.*;
import DAOs.*;

public class App {
    public static void main(String[] args) {

        BaseDeDatos bd = BaseDeDatos.obtenerInstancia();
        Connection connection = bd.getConnection();

        if (connection != null) {
            System.out.println("conexión exitosa con la BDD");
            PreguntaMCDAO preguntaMCDAO = new PreguntaMCDAO(connection);


        //    preguntaMCDAO.obtenerPyRHistoria();
        preguntaMCDAO.obtenerRtaCorrectasHistoria();

        }
    }

   
}
