import java.util.Date;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ronda {
    private int idRonda;
    private int idJuego;
    private ArrayList<Jugador> jugadores;
    //private ArrayList<Pregunta> preguntas;
    private ArrayList<Respuesta> repuestas;
    private Escalon escalon; // pq
    private String resultado; // para q (no creo que haga falta usarlo, nota)
    private Date fecha;
    private String estado;
    private ArrayList<Jugador> empatados;


    public Ronda(int idRonda, int idJuego, ArrayList<Jugador> jugadores ,Escalon escalon) {
        this.idRonda = idRonda;
        this.idJuego = idJuego;
        this.jugadores = jugadores;
        //this.preguntas = new ArrayList<>(18);
        this.repuestas = new ArrayList<>(36);
        this.escalon = escalon;
        this.fecha = new Date();
        this.estado = "en curso";
    }


    public void iniciarRonda() {
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
        Boolean desempate = false;
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
            desempate = true;
        }
    }

    private void desempatar() {
        System.out.println("A continuación, ¡Evaluaremos el desempate!");
        inicializarPuntos();
        Boolean eliminado = true;
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> rtas = new ArrayList<>(empatados.size());
        while (eliminado) {
            Pregunta pregunta = preguntas.get(new Random().nextInt(preguntas.size()));
            while (pregunta.getTipoPregunta() != "aproximación"){
                pregunta = preguntas.get(new Random().nextInt(preguntas.size()));
            }
            System.out.println("Pregunta desempate " + ": "+"\n" + pregunta.getEnunciado());
            int i = 0;
            for (Jugador jugador : empatados){
                System.out.println("Responde el jugador " + jugador.getNombre());
                i = i + 1;
                rtas.set(i, sc.nextInt());
            }

            for(Integer rta : rtas){
                Integer 
            }

            preguntas.remove(pregunta);
        }
    }

    private void imprimirOpciones() {
        String[] abc = {"a", "b", "c", "d"};
        int num = 1;
        for (Respuesta op: pregunta.getOpciones()) {
            System.out.println(abc[num] + ". " + op.getTexto());
            num = num + 1;
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

    private void preguntasTematica (ArrayList<Jugador> jugadores)

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

    public void addPreguntas(Pregunta pregunta) {
        preguntas.add(pregunta);
    }

    public void addEmpatados(Jugador jugador) {
        empatados.add(jugador);
    }
}