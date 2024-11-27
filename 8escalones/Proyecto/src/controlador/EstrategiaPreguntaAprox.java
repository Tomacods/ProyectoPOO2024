package controlador;
import java.sql.SQLException;
import java.util.ArrayList;
import Modelos.PreguntaAproximacion;
import Vista.ABMPreguntas;


public class EstrategiaPreguntaAprox implements EstrategiaPregunta {
    private ABMPreguntas vista;

    public EstrategiaPreguntaAprox(ABMPreguntas vista) {
        this.vista = vista;
    }

    @Override
    public void traerPreguntas(int idTematica) throws SQLException {
        vista.getjComboBoxPregunta().removeAllItems();
        ArrayList<PreguntaAproximacion> preguntas = PreguntaAproximacion.obtenerPreguntasAproximacionTematica(idTematica);
        for (PreguntaAproximacion pregunta : preguntas) {
            vista.getjComboBoxPregunta().addItem(pregunta.getEnunciado());
        }
    }
}