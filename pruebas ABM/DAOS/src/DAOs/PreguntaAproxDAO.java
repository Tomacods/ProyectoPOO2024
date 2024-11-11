package DAOs;
import Modelos.PreguntaAproximacion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreguntaAproxDAO {
    
    private Connection connection;
    public PreguntaAproxDAO(Connection connection){
        this.connection = connection;
    }

    public void insertarPreguntaAprox(PreguntaAproximacion pregunta){
        String query = "INSERT INTO pregunta_aproximacion(enunciado, categoria, valor_aproximado, id_tematica) VALUES (?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1, pregunta.getEnunciado());
            statement.setString(2, pregunta.getCategoria());
            statement.setFloat(3, ((PreguntaAproximacion) pregunta).getValorAproximado());
            statement.setInt(4, pregunta.getId_tematica());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace(); 
        }
    }

    //para obtener el idñ, porque si despues en el main quiero
    //actualizar algo debo poner el id de la pregunta exacto
    //y puede q no lo sepa pq es tipo IDENTITY
    private int obtenerIdPregunta(String enunciado, int id_tematica) {
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

    

    public void eliminarPreguntaAprox(int id){
        String query="DELETE FROM pregunta_aproximacion WHERE id_pregunta= ?";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }






    
    public void obtenerPreguntasAproxHistoria(){
        String query = "SELECT ID_Pregunta, Enunciado, Categoria, Valor_Aproximado " +
        "FROM Pregunta_aproximacion " +
        "WHERE ID_Tematica = (SELECT ID_Tematica FROM Tematica WHERE Nombre_Tematica = 'historia') " +
        "ORDER BY ID_Pregunta;";




    try(PreparedStatement statement = connection.prepareStatement(query);
    ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()){
            int idPregunta = resultSet.getInt("ID_Pregunta");
                String enunciado = resultSet.getString("Enunciado");
                String categoria = resultSet.getString("Categoria");
                float valor_aprox = resultSet.getFloat("Valor_Aproximado");
                System.out.println("ID pregunta: " + idPregunta + ", Enunciado: " + enunciado + ", Categoria: " + categoria + ", Valor aproximado: " + valor_aprox);


        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        
    }

    }
    
}
