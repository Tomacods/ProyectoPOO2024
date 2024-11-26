package Modelos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

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

    public void rondaFinal(){
        inicializarPuntos();
        Random random = new Random();
        ArrayList<MultipleChoicePregunta> pregMult = new ArrayList<>();
        ArrayList<Tematica> tematicas = new ArrayList<>();
        tematicas = Tematica.obtenerTematicas();
        for (int i = 1; i<=5; i++){
            System.out.println("Iniciando ronda " + i + " del juego " + idJuego);
            realizarPreguntas(tematicas.get(random.nextInt(tematicas.size())).getId());
            if (Math.abs(jugadores.get(0).getPuntaje() - jugadores.get(1).getPuntaje()) >= 3) {
                System.out.println("\n¡" + (jugadores.get(0).getPuntaje() > jugadores.get(1).getPuntaje() ? jugadores.get(0).getNombre() : jugadores.get(1).getNombre()) + " ES EL GANADOR DE LOS 8 ESCALONES!");
                break; // Salir del for
            }
        }
        if (jugadores.get(0).getPuntaje() == jugadores.get(1).getPuntaje()) {
            System.out.println("Chemendro empate de "+jugadores.get(0).getNombre()+jugadores.get(1).getNombre()+" causas!!!");
            /* while (jugadores.get(0).getPuntaje() == jugadores.get(1).getPuntaje()) {
                realizarPreguntas(tematicas.get(random.nextInt(tematicas.size())).getId());
            } */
        }
        /* if (jugadores.get(0).getPuntaje() > jugadores.get(1).getPuntaje()) {
            System.out.println("\n¡" + jugadores.get(0).getNombre()  + " ES EL GANADOR DE LOS 8 ESCALONES!");
        } else {
            System.out.println("\n¡" + jugadores.get(1).getNombre()  + " ES EL GANADOR DE LOS 8 ESCALONES!");
        } */
    }


    public void iniciarRonda() throws SQLException {
        inicializarPuntos();
        for(int i = 1; i<=2;i++){
            System.out.println("Iniciando ronda " + i + " del juego " + idJuego);
            realizarPreguntas(this.escalon.getTematica().getId());
        }
        Boolean empate = determinarResultado();
        if (empate == false) {
            this.estado = "finalizado";
        } else {
            desempatar(this.escalon.getTematica().getId(),empate);
        }
    }//APLICAR EN EL CONTROLADOR

    private void realizarPreguntas(int idEscalon) {
        ArrayList<MultipleChoicePregunta> pregMult = new ArrayList<>();
        pregMult = MultipleChoicePregunta.obtenerPreguntasMC(idEscalon);//Trae las preguntas MC de la BD
        for (Jugador jugador : jugadores) {
            MultipleChoicePregunta pregunta = pregMult.get(new Random().nextInt(pregMult.size()));
            System.out.println("Pregunta para " + jugador.getNombre() + ": "+"\n" + pregunta.getEnunciado());
            jugador = preguntarJugador(jugador, pregunta);
            pregMult.remove(pregunta);
        }
    }

    public Jugador preguntarJugador(Jugador jugador, MultipleChoicePregunta pregunta){
        pregunta.imprimirOpciones();
        String respuesta = "Opción A"; // Se conectaria con el controlador para obtener la respuesta
        if (pregunta.getRespuestaCorrecta() == respuesta) {
            System.out.println("Respuesta correcta");
            jugador.incrementarPuntaje();
        } else {
            System.out.println("Respuesta incorrecta");
        }
        return jugador;
    }
    
    //metodoo para realizar preguntas por aproximacion
    //recorro la lista de jugadores y de las respuestas que me dicen compararlas con la respuesta correcta, la que mas se aproxime es la que se toma como correcta y el queda en el escalon


    public boolean determinarResultado() throws SQLException {
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