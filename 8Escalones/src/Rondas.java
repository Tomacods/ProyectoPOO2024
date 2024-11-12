import java.util.Date;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Rondas {
    private int idRonda;
    private int idJuego;
    private ArrayList<Jugador> jugadores;
    private Escalon escalon;
    private String resultado;
    private Date fecha;
    private String estado;
    private ArrayList<Jugador> empatados;


    public Rondas(int idRonda, int idJuego, ArrayList<Jugador> jugadores ,Escalon escalon) {
        this.idRonda = idRonda;
        this.idJuego = idJuego;
        this.jugadores = jugadores;
        this.escalon = escalon;
        this.fecha = new Date();
        this.estado = "en curso";
    }


    public void iniciarRonda() {
        inicializarPuntos();
        for(int i = 1; i<3;i++){
            System.out.println("Iniciando ronda " + i + " del juego " + idJuego);
            realizarPreguntas();
        }
        determinarResultado();
        this.estado = "finalizado";
    }

    private void realizarPreguntas() {
        ArrayList<MultipleChoicePregunta> pregMult = new ArrayList<>();
        //metodo para llenar
        for (Jugador jugador : jugadores) {
            MultipleChoicePregunta pregunta = pregMult.get(new Random().nextInt(pregMult.size()));
            System.out.println("Pregunta para " + jugador.getNombre() + ": "+"\n" + pregunta.getEnunciado());
            pregunta.imprimirOpciones();
            // La respuesta se obtiene de un botón. 
            // Simular respuesta del jugador
            String respuesta = "Opción A"; // Ejemplo de respuesta
            if (pregunta.getRespuestaCorrecta() == respuesta) {
                System.out.println("Respuesta correcta");
                jugador.incrementarPuntaje();
            } else {
                System.out.println("Respuesta incorrecta");
            }
            pregMult.remove(pregunta);
        }
    }
    
    //metodoo para realizar preguntas por aproximacion
    //recorro la lista de jugadores y de las respuestas que me dicen compararlas con la respuesta correcta, la que mas se aproxime es la que se toma como correcta y el queda en el escalon


    private void determinarResultado() {
        // Lógica para determinar el resultado de la ronda
        // Por ejemplo, eliminar al jugador con menos puntaje
        Jugador jugadorMenorPuntaje = jugadores.get(1);
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
            eliminarJugador(empatados.get(1));
        }else{
            desempatar();
        }
    }

    private void desempatar() {
        ArrayList<PreguntaAproximacion> pregAprox = new ArrayList<>();
        System.out.println("A continuación, ¡Evaluaremos el desempate!");
        Boolean eliminado = true;
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> rtas = new ArrayList<>(empatados.size());
        while (eliminado) {
            PreguntaAproximacion pregunta = pregAprox.get(new Random().nextInt(pregAprox.size()));
            System.out.println("Pregunta desempate " + ": "+"\n" + pregunta.getEnunciado());
            int i = 0;
            for (Jugador jugador : empatados){
                System.out.println("Responde el jugador " + jugador.getNombre());
                i = i + 1;
                rtas.set(i, sc.nextInt());
            }
            int peorRta = 0;
            Integer pos = 0;
            for(int j = 1; j< (rtas.size() + 1); j++){
                if ((pregunta.getValorAproximado() - rtas.get(j)) < peorRta) {
                    peorRta = rtas.get(j);
                    pos= j;
                }
            }
            eliminarJugador(empatados.get(pos));
            pregAprox.remove(pregunta);
        }
        sc.close();
    }

    private void eliminarJugador(Jugador jugador){
        jugadores.remove(jugador);
        System.out.println("Jugador eliminado: " + jugador.getNombre());
    }

    private void inicializarPuntos() {
        for (Jugador jug: empatados) {
            jug.setPuntaje(0);
        }
    }

    // Getters y Setters

    public int getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

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
}