package controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import Modelos.MultipleChoicePregunta;
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
    this.vista.listenerTematica(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tematicaSeleccionada = (String) vista.getjComboBoxTematica().getSelectedItem();
            if (tematicaSeleccionada != null) {
                int id_tem = obtenerIdPorNombre(tematicaSeleccionada); // Método para obtener el ID
                traerPreguntasMC(id_tem); // Actualizar preguntas
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
private void traerPreguntasMC(int id_tem){
    vista.getjComboBoxPregunta().removeAllItems(); 
    ArrayList<MultipleChoicePregunta> preguntas = MultipleChoicePregunta.obtenerPreguntasMC(id_tem);
    for (MultipleChoicePregunta pregunta : preguntas) {
        vista.getjComboBoxPregunta().addItem(pregunta.getEnunciado());
    }
}


}





