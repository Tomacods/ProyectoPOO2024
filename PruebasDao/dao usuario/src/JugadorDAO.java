public interface JugadorDAO {
  //  Jugador obtenerJugadorPorId(int id);
    void insertarJugador(Jugador jugador);
    void actualizarJugador(Jugador jugador);
    void eliminarJugador(int id);
}
