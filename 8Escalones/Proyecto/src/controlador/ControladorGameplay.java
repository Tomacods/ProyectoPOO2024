package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import Modelos.MultipleChoicePregunta;
import Modelos.Respuesta;
import Vista.Gameplay;

public class ControladorGameplay {
    private Gameplay vista;

    public ControladorGameplay() throws SQLException {
        this.vista = new Gameplay();
        vista.setVisible(true);
        traerPregunta();
        // traerRespuestas();

    }

    private void traerTematica() {

        // puedo sacar la tematica del modelo escalon
    }

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

    private void traerPregunta() throws SQLException {
        String pregunta = MultipleChoicePregunta.obtenerPreguntaMC(2).getEnunciado();
        int id_pregunta = MultipleChoicePregunta.obtenerPreguntaMC(2).getIdPregunta();
        vista.getjTextFieldPregunta().setText(pregunta);
        traerRespuestas(id_pregunta);

    }

    private void getIdPregunta() {

    }

    private void traerRespuestas(int id_pregunta) throws SQLException {
        ArrayList<Respuesta> respuestas = Respuesta.obtenerRespuestasPorPregunta(id_pregunta);
        vista.getjButtonRtaA().setText(respuestas.get(0).getTexto());
        vista.getjButtonRtaB().setText(respuestas.get(1).getTexto());
        vista.getjButtonRtaC().setText(respuestas.get(2).getTexto());
        vista.getjButtonRtaD().setText(respuestas.get(3).getTexto());
    }

}
