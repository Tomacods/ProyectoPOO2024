package controlador;
import java.util.ArrayList;
import Modelos.MultipleChoicePregunta;
import Vista.ABMPreguntas;
public class EstrategiaPreguntaMC implements EstrategiaPregunta {
    private ABMPreguntas vista;

    public EstrategiaPreguntaMC(ABMPreguntas vista) {
        this.vista = vista;
    }

    @Override
    public void traerPreguntas(int idTematica) {
        vista.getjComboBoxPregunta().removeAllItems();
        ArrayList<MultipleChoicePregunta> preguntas = MultipleChoicePregunta.obtenerPreguntasMC(idTematica);
        for (MultipleChoicePregunta pregunta : preguntas) {
            vista.getjComboBoxPregunta().addItem(pregunta.getEnunciado());
        }
    }
}
