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
                EditarPreg preg = new EditarPreg();
                preg.selecTipo(tipoPreg);
                preg.selectTematica(tematica);
                preg.editarPregunta();
                break;
            }
            case "crear": {
                CrearPreg preg = new CrearPreg();
                /* preg.selecTipo(tipoPreg);
                preg.selectTematica(tematica);
                preg.crearPregunta(); */
                break;
            }
            case "borrar": {
                BorrarPreg preg = new BorrarPreg();
                preg.selecTipo(tipoPreg);
                preg.selectTematica(tematica);
                preg.borrarPregunta();
                break;
            }
            default: throw new IllegalArgumentException("Acción ingresada erroneamente.");
        }
    }
}
