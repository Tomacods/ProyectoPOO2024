import java.math.BigDecimal;

public class JuegoTest {
    // Método para determinar el ganador en una pregunta de aproximación
    public Jugador determinarGanadorAproximacion(PreguntaAproximacion pregunta, Jugador jugador1, String respuesta1, Jugador jugador2, String respuesta2) {
        BigDecimal valorCorrecto = pregunta.getValorAproximado();
        BigDecimal respuestaJugador1 = new BigDecimal(respuesta1);
        BigDecimal respuestaJugador2 = new BigDecimal(respuesta2);

        BigDecimal diferenciaJugador1 = respuestaJugador1.subtract(valorCorrecto).abs();
        BigDecimal diferenciaJugador2 = respuestaJugador2.subtract(valorCorrecto).abs();

        if (diferenciaJugador1.compareTo(diferenciaJugador2) < 0) {
            return jugador1;
        } else {
            return jugador2;
        }
    }
}
