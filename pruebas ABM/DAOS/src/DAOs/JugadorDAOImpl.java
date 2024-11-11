package DAOs;
import Modelos.Jugador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JugadorDAOImpl {
    private Connection conexion;
    public JugadorDAOImpl(Connection conexion){
        this.conexion = conexion;
    }

    public Jugador obtenerJugadorPorId(int id) {
        Jugador jugador = null;
        String query = "SELECT * FROM jugador WHERE id_jugador = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                jugador = new Jugador(rs.getInt("id_jugador"), rs.getString("nombre"), 
                rs.getInt("puntaje"), rs.getString("estado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugador;
    } 

    public void insertarJugador(Jugador jugador){
        String query = "INSERT INTO jugador( nombre, puntaje, estado) VALUES (?,?,?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)){

            statement.setString(1, jugador.getNombre());
            statement.setInt(2, jugador.getPuntaje());
            statement.setString(3, jugador.getEstado());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace(); 
        }
    }


    public void actualizarJugador(Jugador jugador) {
        String query = "UPDATE jugador SET nombre = ?, puntaje=?, estado=? WHERE id_jugador= ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, jugador.getNombre());
            statement.setInt(2, jugador.getPuntaje());
            statement.setString(3, jugador.getEstado());
            statement.setInt(4, jugador.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public void eliminarJugador(int id) {
        String query = "DELETE FROM jugador WHERE id_jugador = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Querys
    public void obtenerJugadores(){
        String query= "select id_jugador, nombre, puntaje, estado from jugador";
        try(PreparedStatement statement = conexion.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int id_jugador= resultSet.getInt("id_jugador");
                String nombre= resultSet.getString("nombre");
                String puntaje= resultSet.getString("puntaje");
                String estado= resultSet.getString("estado");
                System.out.println(nombre);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

