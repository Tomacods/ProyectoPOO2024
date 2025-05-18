package controlador;
import java.util.ArrayList;
import Modelos.MultipleChoicePregunta;
import Vista.ABMPreguntas;
/**
 * EstrategiaPreguntaMC implements the EstrategiaPregunta interface to handle
 * the retrieval and display of multiple choice questions in the ABMPreguntas view.
 * <p>
 * This strategy fetches all multiple choice questions associated with a given
 * thematic ID and populates the corresponding JComboBox in the view with the
 * question statements.
 * </p>
 *
 * @author tomas
 */
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
