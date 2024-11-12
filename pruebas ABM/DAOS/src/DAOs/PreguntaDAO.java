package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelos.MultipleChoicePregunta;
import Modelos.Pregunta;
import Modelos.PreguntaAproximacion;


public class PreguntaDAO {
    Connection connection;
public PreguntaDAO(Connection connection){
    this.connection=connection;
}
//ABM
public void insertarPregunta(Pregunta pregunta){
    if (pregunta instanceof PreguntaAproximacion) { //si es pregunta por aproximacion
                String query="INSERT INTO pregunta_aproximacion(enunciado, categoria, valor_aproximado, id_tematica) VALUES (?,?,?,?)";
                try(PreparedStatement statement = connection.prepareStatement(query)) {
                    
                statement.setString(1, pregunta.getEnunciado());
                statement.setString(2, pregunta.getCategoria());
                statement.setFloat(3, ((PreguntaAproximacion) pregunta).getValorAproximado());
                statement.setInt(4, pregunta.getId_tematica());
                statement.executeUpdate(); 
            } catch (SQLException e) {
                    e.printStackTrace();
                } }else if (pregunta instanceof MultipleChoicePregunta)  {
                String query="INSERT INTO pregunta_multiple_choise(enunciado, categoria, id_tematica) VALUES (?,?,?)";
                try(PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, pregunta.getEnunciado());
                statement.setString(2, pregunta.getCategoria());
                statement.setInt(3, pregunta.getId_tematica());
                statement.executeUpdate(); 
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
            }
}

public void actualizarPregunta(Pregunta pregunta){
    
    if (pregunta instanceof PreguntaAproximacion) { //si es pregunta por aproximacion
        String query="UPDATE pregunta_aproximacion SET enunciado=?, categoria=?, valor_aproximado=?, id_tematica=? WHERE id_pregunta =?";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            
        statement.setString(1, pregunta.getEnunciado());
        statement.setString(2, pregunta.getCategoria());
        statement.setFloat(3, ((PreguntaAproximacion) pregunta).getValorAproximado());
        statement.setInt(4, pregunta.getId_tematica());
        statement.setInt(5, pregunta.getIdPregunta());
        statement.executeUpdate(); 
    } catch (SQLException e) {
            e.printStackTrace();
        } 
    } else if (pregunta instanceof MultipleChoicePregunta)  {
        String query="UPDATE pregunta_multiple_choise SET enunciado=?, categoria=?, id_tematica=? WHERE id_pregunta_mc =?";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, pregunta.getEnunciado());
        statement.setString(2, pregunta.getCategoria());
        statement.setInt(3, pregunta.getId_tematica());
        statement.setInt(4, pregunta.getIdPregunta());
        statement.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}


public void eliminarPregunta(int id, String tipo){
    if (tipo.equals("Aproximacion")) { //si es pregunta por aproximacion
        String query="DELETE FROM pregunta_aproximacion WHERE id_pregunta= ?";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            
        } catch (SQLException e) {
        e.printStackTrace();
        }
    } else if (tipo.equals("Multiple choice"))  {
        String query="DELETE FROM pregunta_multiple_choise WHERE id_pregunta_mc= ?";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            
        } catch (SQLException e) {
        e.printStackTrace();
        }
        
    }
}
//QUERYS
//preguntar a profe como se va a usar esto con lo q estan haciedno fede y cesar
public void obtenerPreguntasAprox(String tematica){
    String query = "SELECT p.Enunciado \n" + //
                "FROM Pregunta_aproximacion p\n" + //
                "inner join tematica t on p.id_tematica = t.id_tematica\n" + //
                "WHERE t.nombre_tematica =  ?\n" + //
                "ORDER BY ID_Pregunta";
    try (PreparedStatement statement = connection.prepareStatement(query)){
        statement.setString(1, tematica);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
        String enunciado = resultSet.getString("enunciado");
        System.out.println(enunciado);
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void obtenerPreguntasMC(String tematica){
    String query = "select  p.enunciado from pregunta_multiple_choise p inner join tematica t on p.id_tematica = t.id_tematica where t.nombre_tematica=?";
    try(PreparedStatement statement = connection.prepareStatement(query)){
        statement.setString(1, tematica);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            String enunciado = resultSet.getString("enunciado");
            System.out.println(enunciado);
        }
    }catch (SQLException e) {
        e.printStackTrace();
    }
}

public void obtenerOpcionesMC(int id){
    String query ="SELECT r.texto from respuesta r inner join pregunta_multiple_choise p on r.id_pregunta = p.id_pregunta_mc\n" + //
                "where p.id_pregunta_mc = ?";
                try(PreparedStatement statement = connection.prepareStatement(query)){
                    statement.setInt(1, id);
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()){
                        String enunciado = resultSet.getString("texto");
                        System.out.println(enunciado);
                    }
                }catch (SQLException e) {
                    e.printStackTrace();
                }
    
}

public int obtenerRtaCorrecta(int id){
    String query = "select  id_respuesta, texto from respuesta inner join pregunta_multiple_choise p on p.id_pregunta_mc = respuesta.id_pregunta\n" + //
                "where  p.id_pregunta_mc=? and respuesta.correcta = 'True'";
                try(PreparedStatement statement = connection.prepareStatement(query)){
                    statement.setInt(1, id);
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()){
                        int id_respuesta = resultSet.getInt("id_respuesta");
                        String enunciado = resultSet.getString("texto");
                        System.out.println(enunciado);
                        return id_respuesta;
                    }
                }catch (SQLException e) {
                    e.printStackTrace();
                }

                return -1; //si no la encuentra
    

}

public ArrayList<Object[]> obtenerPreguntasMCPorTematica(String tematica) {
        ArrayList<Object[]> preguntas = new ArrayList<>();
        String query = "select p.id_pregunta_mc,  p.enunciado, t.nombre_tematica from pregunta_multiple_choise p inner join tematica t on p.id_tematica = t.id_tematica where t.nombre_tematica=?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, tematica);
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y agregar las preguntas al ArrayList
            while (resultSet.next()) {
                Object[] row = {
                    resultSet.getInt("id_pregunta_mc"),   
                    resultSet.getString("enunciado"),  
                    resultSet.getString("nombre_tematica")   
                };
                preguntas.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preguntas;
    }
}










/*
 * private int obtenerIdPregunta(String enunciado, int id_tematica) {
    String query = "SELECT id_pregunta FROM pregunta_aproximacion WHERE enunciado = ? and id_tematica= ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, enunciado);
        statement.setInt(2, id_tematica);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) { //herramienta para trabajar con los resultados de las consultas SQL https://www.arquitecturajava.com/java-resultset-un-ejemplo-sencillo-con-persona/
            return resultSet.getInt("id_pregunta");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return -1;  //va a retornar -1 cuadno no encuentre el id

}


    public void actualizarPreguntaAprox(PreguntaAproximacion pregunta){
        int idPregunta = obtenerIdPregunta(pregunta.getEnunciado(), pregunta.getId_tematica());
        if (idPregunta != -1) {
        String query = "UPDATE pregunta_aproximacion SET enunciado = ?, categoria = ?, valor_aproximado = ?, id_tematica = ? WHERE id_pregunta = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, pregunta.getEnunciado());
            statement.setString(2, pregunta.getCategoria());
            statement.setFloat(3, ((PreguntaAproximacion) pregunta).getValorAproximado());
            statement.setInt(4, pregunta.getId_tematica());
            statement.setInt(5, idPregunta);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }else{
            System.out.println("no se encontro la pregunta: " + pregunta.getEnunciado());

        }
    }
 */