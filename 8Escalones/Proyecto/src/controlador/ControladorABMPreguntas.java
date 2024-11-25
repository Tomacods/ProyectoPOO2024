package controlador;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import Modelos.MultipleChoicePregunta;
import Modelos.PreguntaAproximacion;
import Modelos.Tematica;
import Vista.ABMPreguntas;

public class ControladorABMPreguntas {
    private ABMPreguntas vista;

    public ControladorABMPreguntas(){
        this.vista= new ABMPreguntas();
        vista.setVisible(true);
        traerTematicasCB();
        listeners();
    }

private void traerTematicasCB(){ 
    ArrayList<Tematica> tematicas = Tematica.obtenerTematicas(); 
        for (Tematica tematica : tematicas) {
            vista.getjComboBoxTematica().addItem(tematica.getNombre());
           // traerPreguntasMC(tematica.getId());
        }
}

private void listeners(){
    
    vista.listenerTematica(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tematicaSeleccionada = (String) vista.getjComboBoxTematica().getSelectedItem();
            if (tematicaSeleccionada != null) {
                int idTematica = obtenerIdPorNombre(tematicaSeleccionada);
                actualizarPreguntas(idTematica);
            }
        }
    });

    // Listener para el tipo de pregunta seleccionada
    vista.listenerTipo(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tematicaSeleccionada = (String) vista.getjComboBoxTematica().getSelectedItem();
            if (tematicaSeleccionada != null) {
                int idTematica = obtenerIdPorNombre(tematicaSeleccionada);
                actualizarPreguntas(idTematica);
            }
        }
    });
}
public static int obtenerIdPorNombre(String nombre) {
    for (Tematica tematica : Tematica.obtenerTematicas()) {
        if (tematica.getNombre().equals(nombre)) {
            return tematica.getId();
        }
    }
    throw new IllegalArgumentException("Temática no encontrada: " + nombre);
    
}
private void actualizarPreguntas(int idTematica) {
    String tipoSeleccionado = (String) vista.getjComboBoxTipo().getSelectedItem();
    if (tipoSeleccionado != null) {
        vista.getjComboBoxPregunta().removeAllItems(); 
        try {
            if (tipoSeleccionado.equals("Multiple choice")) {
                traerPreguntasMC(idTematica);
            } else if (tipoSeleccionado.equals("Aproximacion")) {
                traerPreguntasAprox(idTematica);
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener preguntas: " + ex.getMessage());
        }
    }
}
private void traerPreguntasMC(int id_tem){
    vista.getjComboBoxPregunta().removeAllItems(); 
    ArrayList<MultipleChoicePregunta> preguntas = MultipleChoicePregunta.obtenerPreguntasMC(id_tem);
    for (MultipleChoicePregunta pregunta : preguntas) {
        vista.getjComboBoxPregunta().addItem(pregunta.getEnunciado());
    }
}
private void traerPreguntasAprox(int id_tem) throws SQLException{
    vista.getjComboBoxPregunta().removeAllItems(); 
    ArrayList<PreguntaAproximacion> preguntas = PreguntaAproximacion.obtenerPreguntasAproximacionTematica(id_tem);
    for (PreguntaAproximacion pregunta : preguntas) {
        vista.getjComboBoxPregunta().addItem(pregunta.getEnunciado());
    }

}


}





