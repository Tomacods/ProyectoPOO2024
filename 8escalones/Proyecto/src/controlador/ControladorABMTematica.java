import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

public class ControladorABMTematica {


private ABMTematicas vistaABMTematicas;

public ControladorABMTematica(){
    super();
    this.vistaABMTematicas= new ABMTematicas(this);
    vistaABMTematicas.setVisible(true);
    this.vistaABMTematicas.agregarListenerAgregarTematica(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            insertarTematica();
        }
    });

}

private void traerTematicasCB(){
    ArrayList<Tematica> tematicas = Tematica.obtenerTematicas(); 
        for (Tematica tematica : tematicas) {
            vistaABMTematicas.getComboBoxTematica().addItem(tematica.getNombre());
        }


}

private void insertarTematica() {
    String nuevaTematica = vistaABMTematicas.getTextFieldNuevaTematica().getText();
    if (!nuevaTematica.isEmpty()) { 
        Tematica tematicaIns = new Tematica(0, nuevaTematica);
        Tematica.insertarTematica(tematicaIns); 
        traerTematicasCB();
    } else {
        System.out.println("El campo de la nueva temática está vacío.");
    }
}



}