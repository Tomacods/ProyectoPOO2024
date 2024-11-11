import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import Modelos.*;
import DAOs.*;

public class App {
    public static void main(String[] args) {

        BaseDeDatos bd = BaseDeDatos.obtenerInstancia();
        Connection connection = bd.getConnection();

        if (connection != null) {
            System.out.println("conexión exitosa con la BDD");
            List<String> opciones = Arrays.asList("Opción A", "Opción B", "Opción C", "Opción D");
            String respuestaCorrecta = "Opción B";
            MultipleChoicePregunta mcejemplo = new MultipleChoicePregunta(81, "Prueba dao", "prueba", opciones, respuestaCorrecta, 1);
            PreguntaMCDAO preguntaMCDAO = new PreguntaMCDAO(connection);
            
         //   SELECT p.*, r.* FROM PREGUNTA_MULTIPLE_CHOISE p inner join respuesta r on p.id_pregunta_mc = r.id_pregunta
           //where p.id_pregunta_mc = 81;

          //  preguntaMCDAO.insertarPreguntaMC(mcejemplo);
       //     preguntaMCDAO.insertarOpcionesMC(mcejemplo);
        //    preguntaMCDAO.obtenerPyRHistoria();
      //  preguntaMCDAO.obtenerRtaCorrectasHistoria();

   //   PreguntaAproxDAO preguntaAproxDAO = new PreguntaAproxDAO(connection);
     // preguntaAproxDAO.obtenerPreguntasAproxHistoria();

        }
    }

}
