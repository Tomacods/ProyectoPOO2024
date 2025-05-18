package controlador;
import java.sql.SQLException;
import java.util.ArrayList;
import Modelos.PreguntaAproximacion;
import Vista.ABMPreguntas;


/**
 * EstrategiaPreguntaAprox implements the EstrategiaPregunta interface to handle
 * the retrieval and display of approximation-type questions in the ABMPreguntas view.
 * <p>
 * This strategy fetches all approximation questions for a given thematic ID and
 * populates the corresponding JComboBox in the view with their statements.
 * </p>
 *
 * @author tomas
 */
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