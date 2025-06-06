package DAOs;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;
import java.time.LocalDate;

import Modelos.Escalon;
import Modelos.Jugador;
import Modelos.MultipleChoicePregunta;
import Modelos.Respuesta;
import Modelos.Tematica;
import Modelos.Juego;

/**
 * Clase principal de la aplicación que contiene el método main.
 * 
 * Esta clase se utiliza para realizar pruebas y ejecutar diferentes funcionalidades
 * relacionadas con el manejo de jugadores, temáticas, preguntas y respuestas del juego.
 * Incluye ejemplos de cómo interactuar con los DAOs para insertar, eliminar y obtener
 * información de la base de datos, así como pruebas de conexión y manipulación de objetos
 * del dominio.
 * 
 * Nota: Gran parte del código está comentado y se utiliza para pruebas manuales de las
 * distintas funcionalidades implementadas en el proyecto.
 * 
 * @author tomas
 */
public class App {
    public static void main(String[] args) throws SQLException {
/*         ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores = Jugador.obtenerJugadores(); */
        /* ArrayList<Tematica> tematicas = new ArrayList<>();
        tematicas = Tematica.obtenerTematicas();

    


       // Escalon escalon = new Escalon(1, "Comenzado", Tematica.obtenerTematica(1), jugadores);
      //  escalon.jugarEscalon(); */
/*         Date fechaActual = new Date();
        Juego juego = new Juego(1, fechaActual, "Comenzado", 1);
        juego.comenzarJuego(); */
        // JugadorDAOImpl dao = new JugadorDAOImpl();
        // for
        // dao.actualizarPuntaje();

      //  MultipleChoicePregunta pregunta = MultipleChoicePregunta.obtenerPreguntaConRtas(1);
      //  pregunta.imprimirPreguntaYRespuestas();
       // Tematica tem = new Tematica(0);
       /* ArrayList<Tematica> tematicas = new ArrayList<>();
       tematicas = Tematica.obtenerTematicas();
       for (Tematica tematica : tematicas) {
        System.out.println("ID: " + tematica.getId() + ", Nombre: " + tematica.getNombre());
    }
    Tematica tematica = Tematica.obtenerTematica(1);
    System.out.println(tematica.getNombre()); */
      /*   TematicaDAOImpl tem = new TematicaDAOImpl();
        Tematica nuevaT = new Tematica(0, "Prueba dao"); //FIJARSE SI PODEMOS HACER OTRO CONSTRUCTOR Q PASE SOLO EL NOMBRE
      //  tem.insertarTematica(nuevaT);
    //  tem.eliminarTematica(9);
  //  Respuesta rta = new Respuesta();
        List <Respuesta> opciones = new ArrayList<>();
        opciones.add(new Respuesta("rta 1.0", false));
        opciones.add(new Respuesta("rta 2.0", false));
        opciones.add(new Respuesta("rta 3.0", true));
        opciones.add(new Respuesta("rta 4.0", false));
            


        MultipleChoiceDAO mcd = new MultipleChoiceDAO();
        MultipleChoicePregunta pregunta = new MultipleChoicePregunta(0, "prueba2", 1);
        // mcd.insertarPreguntaMultipleChoise(pregunta, opciones); */
         //  mcd.eliminarPreguntaMC(87); 


   /*    
      try {
       MultipleChoicePregunta pregunta= mcd.obtenerPreguntaMC(1);
        if (pregunta != null) {
            System.out.println("Enunciado de la pregunta: " + pregunta.getEnunciado());
        } else {
            System.out.println("Pregunta no encontrada.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
 */








/* 
        BaseDeDatos bd = BaseDeDatos.obtenerInstancia();
        Connection connection = bd.getConnection(); */

       /*  if (connection != null) {
            System.out.println("conexión exitosa con la BDD");
            RespuestaDAO rtadao = new RespuestaDAO(connection);
            MultipleChoiceDAO mcdao = new MultipleChoiceDAO(connection, rtadao);
            MultipleChoicePregunta pregunta = new MultipleChoicePregunta(0, "PRUEBA DAO", 1);
            Respuesta respuesta1 = new Respuesta(0, 0, "A", true);
            Respuesta respuesta2 = new Respuesta(0, 0, "B", false);
            Respuesta respuesta3 = new Respuesta(0, 0, "C", false);
            Respuesta respuesta4 = new Respuesta(0, 0, "D", false);

            // Insertar la pregunta y sus respuestas
            try {
                mcdao.insertarPreguntaMultipleChoise(pregunta, Arrays.asList(respuesta1, respuesta2, respuesta3, respuesta4));
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("insertado"); */
            // List<String> opciones = Arrays.asList("Opción A 2", "Opción B 2", "Opción C
            // 2", "Opción D 2");
            // String respuestaCorrecta = "Opción B";
            // MultipleChoicePregunta mcejemplo = new MultipleChoicePregunta(0, "Prueba dao
            // 2", "prueba2", opciones, respuestaCorrecta, 1);
            // PreguntaMCDAO preguntaMCDAO = new PreguntaMCDAO(connection);
            // PreguntaDAO preguntadao = new PreguntaDAO(connection);
            // JugadorDAOImpl jug = new JugadorDAOImpl(connection);
            // jug.obtenerJugadores();
            // ArrayList<Object[]> preguntas =
            // preguntadao.obtenerPreguntasMCPorTematica("deporte");
            /* RespuestaDAO rta = new RespuestaDAO(connection);
            try {
                List<Respuesta> respuestas = rta.obtenerRespuestasPorPregunta(1);
                for (Respuesta respuesta : respuestas) {
                    System.out.println("ID Respuesta: " + respuesta.getIdRespuesta() +
                            ", ID Pregunta: " + respuesta.getIdPregunta() +
                            ", Texto: " + respuesta.getTexto() +
                            ", Correcta: " + respuesta.isEsCorrecta());
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } */

            /*
             * for (Object[] pregunta : preguntas) {
             * System.out.println("ID: " + pregunta[0] + ", Contenido: " + pregunta[1] +
             * ", Temática: " + pregunta[2]);
             * }
             */
            // preguntadao.obtenerPreguntasAprox("historia");
            // preguntadao.obtenerOpcionesMC(1);
            // preguntadao.obtenerRtaCorrecta(1);
            // System.out.println(preguntadao.obtenerRtaCorrecta(1));
            // preguntadao.eliminarPregunta(82, "Multiple choice");
            // preguntadao.insertarPregunta(mcejemplo);
            // System.out.println("Pregunta insertada");
            // preguntaMCDAO.obtenerPyR(mcejemplo);
            // preguntaMCDAO.obtenerPreguntasporTematica("deporte");
            // SELECT p.*, r.* FROM PREGUNTA_MULTIPLE_CHOISE p inner join respuesta r on
            // p.id_pregunta_mc = r.id_pregunta
            // where p.id_pregunta_mc = 81;

            // preguntaMCDAO.insertarPreguntaMC(mcejemplo);
            // preguntaMCDAO.insertarOpcionesMC(mcejemplo);
            // preguntaMCDAO.obtenerPyRHistoria();
            // preguntaMCDAO.obtenerRtaCorrectasHistoria();

            // PreguntaAproxDAO preguntaAproxDAO = new PreguntaAproxDAO(connection);
            // preguntaAproxDAO.obtenerPreguntasAproxHistoria();

        }
    }


/*
 * CREATE OR REPLACE FUNCTION obtener_preguntas_por_tematica(
 * tipo_pregunta VARCHAR,
 * tematica_nombre VARCHAR
 * ) RETURNS TABLE(
 * pregunta_id INT,
 * enunciado_pregunta TEXT,
 * categoria_pregunta VARCHAR
 * ) AS $$
 * DECLARE
 * tematica_id INT;
 * BEGIN
 * -- Obtener el ID de la temática a partir de su nombre
 * SELECT ID_Tematica INTO tematica_id
 * FROM Tematica
 * WHERE Nombre_Tematica = tematica_nombre;
 * 
 * -- Verificar si se encontró una temática con el nombre dado
 * IF tematica_id IS NULL THEN
 * RAISE EXCEPTION 'No se encontró una temática con el nombre %',
 * tematica_nombre;
 * END IF;
 * 
 * -- Si el tipo de pregunta es "multiple_choise", selecciona de
 * Pregunta_multiple_choise
 * IF tipo_pregunta = 'multiple_choise' THEN
 * RETURN QUERY
 * SELECT
 * ID_Pregunta_mc AS pregunta_id,
 * Enunciado AS enunciado_pregunta,
 * Categoria AS categoria_pregunta
 * FROM
 * Pregunta_multiple_choise
 * WHERE
 * ID_Tematica = tematica_id;
 * 
 * -- Si el tipo de pregunta es "aproximacion", selecciona de
 * Pregunta_aproximacion
 * ELSIF tipo_pregunta = 'aproximacion' THEN
 * RETURN QUERY
 * SELECT
 * ID_Pregunta AS pregunta_id,
 * Enunciado AS enunciado_pregunta,
 * Categoria AS categoria_pregunta
 * FROM
 * Pregunta_aproximacion
 * WHERE
 * ID_Tematica = tematica_id;
 * 
 * ELSE
 * -- Si el tipo de pregunta no es válido, lanza un error
 * RAISE EXCEPTION 'Tipo de pregunta inválido. Debe ser "multiple_choise" o
 * "aproximacion"';
 * END IF;
 * END;
 * $$ LANGUAGE plpgsql;
 */