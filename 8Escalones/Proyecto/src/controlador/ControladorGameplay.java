package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import Modelos.MultipleChoicePregunta;
import Modelos.Respuesta;
import Vista.Gameplay;

public class ControladorGameplay {
    private Gameplay vista;
    public ControladorGameplay() throws SQLException{
        this.vista= new Gameplay(this);
        vista.setVisible(true);
        traerPregunta();
       // traerRespuestas();
        
    }

    private void traerTematica(){

    }

    private void traerPregunta() throws SQLException{
        String pregunta = MultipleChoicePregunta.obtenerPreguntaMC(2).getEnunciado();
        int id_pregunta= MultipleChoicePregunta.obtenerPreguntaMC(2).getIdPregunta();
        vista.getjTextFieldPregunta().setText(pregunta);
        traerRespuestas(id_pregunta);

    }
    private void getIdPregunta(){


    }

    private void traerRespuestas(int id_pregunta) throws SQLException{
        ArrayList<Respuesta> respuestas = Respuesta.obtenerRespuestasPorPregunta(id_pregunta);
        vista.getjButtonRtaA().setText(respuestas.get(0).getTexto());
        vista.getjButtonRtaB().setText(respuestas.get(1).getTexto());
        vista.getjButtonRtaC().setText(respuestas.get(2).getTexto());
        vista.getjButtonRtaD().setText(respuestas.get(3).getTexto());
    }

}
