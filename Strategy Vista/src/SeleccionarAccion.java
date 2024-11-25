/* import vista.ABMPreguntas;
import vista.ABMRespuestaAprox;
import vista.ABMRespuestaMC;
import javax.swing.*; */

public class SeleccionarAccion {
    
    //metodo para obtener tematica
    //metodo para obtener tipo pregunta ==> settear estrategia
    //metodo para obtener preguntas por temática y tipo de pregunta
    //llamar vista

    public String accion;
    public String tematica;
    public String tipoPreg;

    public SeleccionarAccion(String accion) {
        this.accion = accion;
    }

    public void seleccionar(String accion) {
        switch (accion) {
            case "editar": {
                EditarPreg editar = new EditarPreg();
                editar.selectTipo(tipoPreg);
                editar.selectTematica(tematica);
                editar.editarPregunta();
                break;
            }
            case "crear": {
                CrearPreg crear = new CrearPreg();
                crear.selectTipo(tipoPreg);
                crear.selectTematica(tematica);
                crear.crearPregunta();
                break;
            }
            case "borrar": {
                BorrarPreg borrar = new BorrarPreg();
                borrar.selectTipo(tipoPreg);
                borrar.selectTematica(tematica);
                borrar.borrarPregunta();
                break;
            }
            default: throw new IllegalArgumentException("Acción ingresada erroneamente.");
        }
    }
}
