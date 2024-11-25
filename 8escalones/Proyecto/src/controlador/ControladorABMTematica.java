package controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import Vista.ABMTematicas;
import Modelos.Tematica;
import Vista.ModoAdmin;
public class ControladorABMTematica {
private ABMTematicas vistaABMTematicas;

public ControladorABMTematica(){
    this.vistaABMTematicas= new ABMTematicas();
    vistaABMTematicas.setVisible(true);
    listeners();
    traerTematicasCB();
}

private void listeners(){
    this.vistaABMTematicas.getComboBoxTematica().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedTematica = (String) vistaABMTematicas.getComboBoxTematica().getSelectedItem();
            seleccionarTematica(selectedTematica); 
        }
    });
    this.vistaABMTematicas.agregarListenerAgregarTematica(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            insertarTematica();
        }
    });
    this.vistaABMTematicas.agregarListenerEliminarTematica(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            eliminarTematica(); 
        }
    });
    this.vistaABMTematicas.listenerModificarTematica(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        modificarTematica();
        }
    });

    this.vistaABMTematicas.listenerAtras(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vistaABMTematicas.dispose();
            ModoAdmin admin = new ModoAdmin();
            admin.setVisible(true);
        } });
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

private void traerTematicasCB(){ 
    ArrayList<Tematica> tematicas = Tematica.obtenerTematicas(); 
        for (Tematica tematica : tematicas) {
            vistaABMTematicas.getComboBoxTematica().addItem(tematica.getNombre());
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

private void modificarTematica() {
    String selectedTematica = (String) vistaABMTematicas.getComboBoxTematica().getSelectedItem();
    if (selectedTematica == null) {
        System.out.println("No se ha seleccionado ninguna temática.");
        return;
    }
    Tematica tematica = obtenerTematicaPorNombre(selectedTematica);
    if (tematica == null) {
        System.out.println("No se encontró la temática seleccionada.");
        return;
    }
    String nuevaTematica = vistaABMTematicas.getTextFieldNuevaTematica().getText();
    if (nuevaTematica.isEmpty()) {
        System.out.println("El campo de la nueva temática está vacío.");
        return;
    }
    tematica.setNombre(nuevaTematica);
    Tematica.actualizarTematica(tematica);
    traerTematicasCB();
    System.out.println("Temática modificada exitosamente.");
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
}