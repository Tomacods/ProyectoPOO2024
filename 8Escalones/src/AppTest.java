import java.math.BigDecimal;

public class AppTest {
    
    public static void main(String[] args) throws Exception {

            PreguntaAproximacion pregunta = new PreguntaAproximacion(1, "¿En qué año fue el mundial en Argentina?", "Deportes", new BigDecimal("1978"));
        Jugador jugador1 = new Jugador(1, "Juan Perez", 0, "activo");
        Jugador jugador2 = new Jugador(2, "Maria Gomez", 0, "activo");
        
        JuegoTest juego = new JuegoTest();
        Jugador ganador = juego.determinarGanadorAproximacion(pregunta, jugador1, "1970", jugador2, "1982");
        
        System.out.println("El ganador es: " + ganador.getNombre());
    }
}