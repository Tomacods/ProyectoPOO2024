package controlador;

import java.util.ArrayList;

import Modelos.MultipleChoicePregunta;
import Modelos.Tematica;
import Vista.ABMPreguntas;

public class ControladorABMPreguntas {
    private ABMPreguntas vista;

    public ControladorABMPreguntas(){
        this.vista= new ABMPreguntas(this);
        vista.setVisible(true);
        traerTematicasCB();
    }

private void traerTematicasCB(){ 
    ArrayList<Tematica> tematicas = Tematica.obtenerTematicas(); 
        for (Tematica tematica : tematicas) {
            vista.getjComboBoxTematica().addItem(tematica.getNombre());
            traerPreguntasMC(tematica.getId());
        }
}

private void listeners(){
    this.vista.listenerTematica(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            eliminarTematica(); 
        }
    });
}
private void traerPreguntasMC(int id_tem){
    ArrayList<MultipleChoicePregunta> preguntas= MultipleChoicePregunta.obtenerPreguntasMC(id_tem);
    for (MultipleChoicePregunta multipleChoicePregunta : preguntas) {
        vista.getjComboBoxPregunta().addItem(multipleChoicePregunta.getEnunciado());
        
    }

}




}
