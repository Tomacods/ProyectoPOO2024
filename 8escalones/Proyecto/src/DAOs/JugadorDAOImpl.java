package DAOs;

import Modelos.Jugador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JugadorDAOImpl {
    private final BaseDeDatos connection = BaseDeDatos.obtenerInstancia();

    public JugadorDAOImpl() {
    }

    public void insertarJugador(Jugador jugador) {
        String query = "INSERT INTO jugador( nombre, puntaje, estado) VALUES (?,?,?)";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {

            statement.setString(1, jugador.getNombre());
            statement.setInt(2, jugador.getPuntaje());
            statement.setString(3, jugador.getEstado());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarJugador(Jugador jugador) {
        String query = "UPDATE jugador SET nombre = ?, puntaje=?, estado=? WHERE id_jugador= ?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
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
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Querys
    public ArrayList<Object[]> obtenerJugadores() { // DEVUELVE LOS JUGADORES
        ArrayList<Object[]> jugadores = new ArrayList<>();
        String query = "select * from jugador";

        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object[] row = {
                        resultSet.getInt("id_jugador"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("puntaje"),
                        resultSet.getString("estado")
                };
                jugadores.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugadores;
    }

    public Jugador obtenerJugador(int id_jugador) throws SQLException {
        String query = "SELECT * FROM jugador WHERE id_jugador = ?";
        try (PreparedStatement statement = BaseDeDatos.prepareStatement(query)) {
            statement.setInt(1, id_jugador);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Jugador(
                            resultSet.getInt("id_jugador"),
                            resultSet.getString("nombre"),
                            resultSet.getInt("puntaje"),
                            resultSet.getString("estado"));
                }
            }
        } catch (SQLException ex) {
            throw new SQLException("Error al obtener jugador: " + ex.getMessage());
        }
        return null;
    }

}
