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
        traerRespuestas();
        
    }

    private void traerTematica(){

    }

    private void traerPregunta() throws SQLException{
        String pregunta = MultipleChoicePregunta.obtenerPreguntaMC(2).getEnunciado();
        vista.getjTextFieldPregunta().setText(pregunta);

    }
    private void getIdPregunta(){
        

    }

    private void traerRespuestas() throws SQLException{
        ArrayList<Respuesta> respuestas = Respuesta.obtenerRespuestasPorPregunta(2);
        vista.getjButtonRtaA().setText(respuestas.get(0).getTexto());
        vista.getjButtonRtaB().setText(respuestas.get(1).getTexto());
        vista.getjButtonRtaC().setText(respuestas.get(2).getTexto());
        vista.getjButtonRtaD().setText(respuestas.get(3).getTexto());
    }

}
