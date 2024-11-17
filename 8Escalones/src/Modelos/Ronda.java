package Modelos;
import java.util.Date;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Ronda {
    //private int idRonda;
    private int idJuego;
    private ArrayList<Jugador> jugadores;
    private Escalon escalon;
    private String resultado;
    private Date fecha;
    private String estado;
    private ArrayList<Jugador> empatados;


    public Ronda(/* int idRonda,  */int idJuego, ArrayList<Jugador> jugadores ,Escalon escalon) {
        //this.idRonda = idRonda;
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
            eliminarJugador(empatados.get(0));
        }else{
            desempatar();
        }
    }

    private void desempatar() {
        ArrayList<PreguntaAproximacion> pregAprox = new ArrayList<>();
        System.out.println("A continuación, ¡Evaluaremos el desempate!");
        Boolean eliminado = true;
        Scanner sc = new Scanner(System.in);
        Map<Jugador, Integer> respuestas= new HashMap<>();
        while (eliminado) {
            PreguntaAproximacion pregunta = pregAprox.get(new Random().nextInt(pregAprox.size()));
            System.out.println("Pregunta desempate " + ": "+"\n" + pregunta.getEnunciado());
            for (Jugador jugador : empatados){
                System.out.println("Responde el jugador " + jugador.getNombre());
                respuestas.put(jugador, sc.nextInt());
            }
            int peorRta = 0;
            for(Map.Entry<Jugador, Integer> entry : respuestas.entrySet()){
                if (valorAbsoluto((pregunta.getValorAproximado() - entry.getValue())) > peorRta) {
                    /* removeEmpatado(empatados.get(j)); */
                    peorRta = entry.getValue();
                }
            }
            for(Map.Entry<Jugador, Integer> entry : respuestas.entrySet()){
                if (valorAbsoluto((pregunta.getValorAproximado() - entry.getValue())) != peorRta) {
                    removeEmpatado(entry.getKey());
                }
            }
            if(empatados.size() == 1){
                eliminarJugador(empatados.get(0));
                eliminado= false;
            }

            pregAprox.remove(pregunta);
        }
        sc.close();
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
        System.out.println("Jugador eliminado: " + jugador.getNombre());
    }

    private void inicializarPuntos() {
        for (Jugador jug: empatados) {
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