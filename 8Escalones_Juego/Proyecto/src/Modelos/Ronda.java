package Modelos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * La clase Ronda representa una ronda dentro del juego "8 Escalones".
 * Gestiona el flujo de preguntas, el puntaje de los jugadores, el desempate y la eliminación de jugadores.
 * 
 * <p>Responsabilidades principales:</p>
 * <ul>
 *   <li>Inicializar y gestionar el estado de una ronda.</li>
 *   <li>Realizar preguntas de opción múltiple a los jugadores.</li>
 *   <li>Determinar el resultado de la ronda y gestionar empates.</li>
 *   <li>Realizar preguntas de aproximación en caso de empate.</li>
 *   <li>Eliminar jugadores según el puntaje obtenido.</li>
 * </ul>
 * 
 * <p>Atributos principales:</p>
 * <ul>
 *   <li>idJuego: Identificador del juego al que pertenece la ronda.</li>
 *   <li>jugadores: Lista de jugadores participantes en la ronda.</li>
 *   <li>escalon: Escalón actual de la ronda.</li>
 *   <li>resultado: Resultado de la ronda.</li>
 *   <li>fecha: Fecha de realización de la ronda.</li>
 *   <li>estado: Estado actual de la ronda (por ejemplo, "en curso", "finalizado").</li>
 *   <li>empatados: Lista de jugadores empatados en la ronda.</li>
 * </ul>
 * 
 * <p>Métodos principales:</p>
 * <ul>
 *   <li>iniciarRonda(): Inicia la ronda y gestiona el flujo de preguntas y desempates.</li>
 *   <li>rondaFinal(): Ejecuta la ronda final entre dos jugadores y determina el ganador.</li>
 *   <li>realizarPreguntas(): Realiza preguntas de opción múltiple a los jugadores.</li>
 *   <li>preguntarJugador(): Gestiona la interacción de un jugador con una pregunta de opción múltiple.</li>
 *   <li>determinarResultado(): Determina el resultado de la ronda y si hay empate.</li>
 *   <li>desempatar(): Gestiona el desempate mediante preguntas de aproximación.</li>
 *   <li>eliminarJugador(): Elimina a un jugador de la ronda.</li>
 * </ul>
 * 
 * <p>Nota: Esta clase depende de otras clases como Jugador, Escalon, Tematica, MultipleChoicePregunta, PreguntaAproximacion y Respuesta.</p>
 * 
 * @author tomas
 */
public class Ronda {
    private int idJuego;
    private ArrayList<Jugador> jugadores;
    private Escalon escalon;
    private String resultado;
    private Date fecha;
    private String estado;
    private ArrayList<Jugador> empatados = new ArrayList<>();


    public Ronda(int idJuego, ArrayList<Jugador> jugadores ,Escalon escalon) {
        this.idJuego = idJuego;
        this.jugadores = jugadores;
        this.escalon = escalon;
        this.fecha = new Date();
        this.estado = "en curso";
    }

    public Jugador rondaFinal(ArrayList<Tematica> tematicas, ArrayList<Jugador> jugadores) throws SQLException{
        inicializarPuntos();
        int pos = 0;
        for (int i = 1; i<=5; i++){
            Tematica tematica = tematicas.get(pos);
            realizarPreguntas(tematica.getId(), jugadores);
            if (Math.abs(jugadores.get(0).getPuntaje() - jugadores.get(1).getPuntaje()) >= 3) {
                System.out.println("\n¡" + (jugadores.get(0).getPuntaje() > jugadores.get(1).getPuntaje() ? jugadores.get(0).getNombre() : jugadores.get(1).getNombre()) + " ES EL GANADOR DE LOS 8 ESCALONES!");
                break; // Salir del for
            }
            pos++;
        }
        if (jugadores.get(0).getPuntaje() == jugadores.get(1).getPuntaje()) {
            while (jugadores.get(0).getPuntaje() == jugadores.get(1).getPuntaje()) {
                Tematica tematica = tematicas.get(pos);
                realizarPreguntas(tematica.getId(), jugadores);
                pos++;
                if (pos > tematicas.size()) {
                    pos = 0;
                }
            }
        }
        if (jugadores.get(0).getPuntaje() > jugadores.get(1).getPuntaje()) {
            return jugadores.get(0);//DEVUELVE SI GANO EL JUGADOR 0
        } else {
            return jugadores.get(1);//DEVUELVE SI GANO EL JUGADOR 1
        }
    }

    public void iniciarRonda() throws SQLException {
        inicializarPuntos();
        for(int i = 1; i<=2;i++){
            System.out.println("Iniciando ronda " + i + " del juego " + idJuego);
            realizarPreguntas(this.escalon.getTematica().getId(), jugadores);
        }
        Boolean empate = determinarResultado();
        if (empate == false) {
            this.estado = "finalizado";
        } else {
            desempatar(this.escalon.getTematica().getId(),empate);
        }
    }//APLICAR EN EL CONTROLADOR

    private void realizarPreguntas(int idTematica, ArrayList<Jugador> jugadores) throws SQLException {
        ArrayList<MultipleChoicePregunta> pregMult = new ArrayList<>();
        pregMult = MultipleChoicePregunta.obtenerPreguntasMC(idTematica);//Trae las preguntas MC de la BD
        for (Jugador jugador : jugadores) {
            MultipleChoicePregunta pregunta = pregMult.get(new Random().nextInt(pregMult.size()));
            System.out.println("Pregunta para " + jugador.getNombre() + ": "+"\n" + pregunta.getEnunciado());
            jugador = preguntarJugador(jugador, pregunta);
            pregMult.remove(pregunta);
        }
    }

    public Jugador preguntarJugador(Jugador jugador, MultipleChoicePregunta pregunta) throws SQLException{
        pregunta.imprimirOpciones();
        String respuesta = "Opción A"; // Se conectaria con el controlador para obtener la respuesta
        ArrayList<Respuesta> respuestas = Respuesta.obtenerRespuestasPorPregunta(pregunta.getIdPregunta());
        Boolean correcta = respuestaCorrecta(respuestas, respuesta);
        if (correcta == true) {
            System.out.println("Respuesta correcta");
            jugador.incrementarPuntaje();
        } else {
            System.out.println("Respuesta incorrecta");
        }
        return jugador;
    }

    private Boolean respuestaCorrecta(ArrayList<Respuesta> respuestas, String resp) {
        Boolean correcta = false;
        for (Respuesta rta : respuestas) {
            if (rta.isEsCorrecta() == true) {
                if (rta.getTexto() == resp) {
                    correcta = true;
                }
            }
        }
        return correcta;
    }
    
    //metodoo para realizar preguntas por aproximacion
    //recorro la lista de jugadores y de las respuestas que me dicen compararlas con la respuesta correcta, la que mas se aproxime es la que se toma como correcta y el queda en el escalon


    public Boolean determinarResultado() throws SQLException {
        // Lógica para determinar el resultado de la ronda
        // Por ejemplo, eliminar al jugador con menos puntaje
        // ESTE CODIGO DEBE UTILIZARSE EN EL CONTROLADOR GAMEPLAY EN CONTROLADOR GAMEPLAY_APROXIMACION
        Jugador jugadorMenorPuntaje = jugadores.get(1);
        Boolean empate;
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntaje() < jugadorMenorPuntaje.getPuntaje()) {
                jugadorMenorPuntaje = jugador;
            }
        }
        for(Jugador jugador : jugadores){
            if(jugadorMenorPuntaje.getPuntaje() == jugador.getPuntaje()){
                addEmpatados(jugador);
            }
        }
        if (empatados.size()== 1){
            eliminarJugador(empatados.get(0));
            return empate = false;//Llevaria al Controlador de Siguiente Escalon
        }else{
            return empate = true;//Llevaria al controlador de Gameplay_Aproximacion
            //desempatar(this.escalon.getTematica().getId());
        }
    }

    public void desempatar(int idEscalon, boolean empate) throws SQLException {
        ArrayList<PreguntaAproximacion> pregAprox = new ArrayList<>();
        pregAprox = PreguntaAproximacion.obtenerPreguntasAproximacionTematica(idEscalon);
        System.out.println("A continuación, ¡Evaluaremos el desempate!");
        Boolean eliminado = true;
        while (eliminado) {
            PreguntaAproximacion pregunta = pregAprox.get(new Random().nextInt(pregAprox.size()));
            System.out.println("Pregunta desempate " + ": "+"\n" + pregunta.getEnunciado());
            for (Jugador jugador : empatados){
                System.out.println("Responde el jugador " + jugador.getNombre());
                jugador = preguntarAproximacion(jugador, pregunta);
            }
            int peorRta = 0;
            for(Jugador jugador : empatados){
                jugador.setPuntaje(valorAbsoluto((pregunta.getValorAproximado() - jugador.getPuntaje())));
                if (jugador.getPuntaje() > peorRta) {
                    /* removeEmpatado(empatados.get(j)); */
                    peorRta = jugador.getPuntaje();
                }
            }
            for(Jugador jugador : empatados){
                if (jugador.getPuntaje() != peorRta) {
                    removeEmpatado(jugador);
                }
            }
            if(empatados.size() == 1){
                eliminarJugador(empatados.get(0));
                eliminado= false;
            }
            pregAprox.remove(pregunta);
        }
    }

public Jugador preguntarAproximacion(Jugador jugador, PreguntaAproximacion pregunta) {
    int rta = 2;
    jugador.setPuntaje(rta); //Obtener de vista la respuesta
    return jugador;
}
    private int valorAbsoluto(int numero){
        if (numero>=0){
            return numero;
        }else{
        return (numero*-1);
        }
    }

    private void eliminarJugador(Jugador jugador){
        jugadores.remove(jugador);
        jugador.setEstado("Eliminado");
        System.out.println("Jugador eliminado: " + jugador.getNombre());
    }

    private void inicializarPuntos() {
        for (Jugador jug: jugadores) {
            jug.setPuntaje(0);
        }
    }

    // Getters y Setters

    /* public int getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }
 */
    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public Escalon getEscalon() {
        return escalon;
    }

    public void setEscalon(Escalon escalon) {
        this.escalon = escalon;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void addEmpatados(Jugador jugador) {
        empatados.add(jugador);
    }
    
    public void removeEmpatado(Jugador jugador) {
        empatados.remove(jugador);
    }
}