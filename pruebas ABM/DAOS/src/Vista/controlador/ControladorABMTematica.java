package controlador;
import java.util.ArrayList;

import Modelos.Tematica;
import ventanas.ABMPreguntas;
import ventanas.ABMTematicas;

public class ControladorABMTematica {


private ABMTematicas vistaABMTematicas;

public ControladorABMTematica(Tematica tematica, ABMTematicas vistAbmTematicas){

    this.vistaABMTematicas= vistAbmTematicas;
    this.vistaABMTematicas.
}
/* traer la lista del modelo al comobox

    private agregar
    agregar mariano
    agregar nuestro */

    private void CargarTematicasCB (){
        ArrayList<Tematica> tematicas = Tematica.obtenerTematicas();
        for (Tematica tematica : tematicas) {
            
        }

    }

    private void insertarTematica(Tematica tematica){
        String nuevaTematica =  //lo que ingrese en el textfield
        if (!nuevaTematica.isEmpty()){ //validacion
            Tematica tematicaIns = new Tematica(0, nuevaTematica);
        Tematica.insertarTematica(tematicaIns);
        CargarTematicasCB(); //actualiza el combobox
        
        }

    }
}
