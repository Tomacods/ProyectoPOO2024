package controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import Vista.ABMTematicas;
import Modelos.Tematica;


public class ControladorABMTematica {


private ABMTematicas vistaABMTematicas;

public ControladorABMTematica(){
    super();
    this.vistaABMTematicas= new ABMTematicas(this);
    vistaABMTematicas.setVisible(true);
    traerTematicasCB();
    listenerAgregarTematica();
    listenerComboBoxTematica();
    listenerEliminarTematica();
    listenerModificarTematica();

}

private void listenerComboBoxTematica() {
    this.vistaABMTematicas.getComboBoxTematica().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedTematica = (String) vistaABMTematicas.getComboBoxTematica().getSelectedItem();
            seleccionarTematica(selectedTematica); 
        }
    });
}

private void listenerAgregarTematica() {
    this.vistaABMTematicas.agregarListenerAgregarTematica(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            insertarTematica();
        }
    });
}

private void listenerEliminarTematica() {
    this.vistaABMTematicas.agregarListenerEliminarTematica(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            eliminarTematica(); 
        }
    });
}

private void listenerModificarTematica() {
    this.vistaABMTematicas.listenerBotonTematica(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        modificarTematica();
        }
    });
}

private void modificarTematica(){
    String selectedTematica = (String) vistaABMTematicas.getComboBoxTematica().getSelectedItem();
    Tematica tematica = obtenerTematicaPorNombre(selectedTematica);
    Tematica.actualizarTematica(tematica);
    /* if (selectedTematica != null) {
        Tematica tematica = obtenerTematicaPorNombre(selectedTematica);
        if (tematica != null) {
            int idTematica = tematica.getId();
            System.out.println("Temática seleccionada para eliminar: " + selectedTematica + ", ID: " + idTematica);

            Tematica.eliminarTematica(idTematica);
            System.out.println("Temática eliminada: " + selectedTematica + ", ID: " + idTematica);

            traerTematicasCB();
        } */
    }



private void traerTematicasCB(){ 
    ArrayList<Tematica> tematicas = Tematica.obtenerTematicas(); 
        for (Tematica tematica : tematicas) {
            vistaABMTematicas.getComboBoxTematica().addItem(tematica.getNombre());
        }


}
public void seleccionarTematica(String tematicaSeleccionada) {
    Tematica tematica = obtenerTematicaPorNombre(tematicaSeleccionada);

    if (tematica != null) {
        int idTematica = tematica.getId();
        System.out.println("Temática seleccionada: " + tematicaSeleccionada + ", ID: " + idTematica);
        
    }
}

private Tematica obtenerTematicaPorNombre(String nombre) {
    ArrayList<Tematica> tematicas = Tematica.obtenerTematicas();
    for (Tematica tematica : tematicas) {
        if (tematica.getNombre().equals(nombre)) {
            return tematica;
        }
    }
    return null;  
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

private void eliminarTematica(){

            String selectedTematica = (String) vistaABMTematicas.getComboBoxTematica().getSelectedItem();
            if (selectedTematica != null) {
                Tematica tematica = obtenerTematicaPorNombre(selectedTematica);
                if (tematica != null) {
                    int idTematica = tematica.getId();
                    System.out.println("Temática seleccionada para eliminar: " + selectedTematica + ", ID: " + idTematica);

                    Tematica.eliminarTematica(idTematica);
                    System.out.println("Temática eliminada: " + selectedTematica + ", ID: " + idTematica);

                    traerTematicasCB();
                }
            }


}
}


