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

    public SeleccionarAccion(String accion) {
        this.accion = accion;
    }

    public void seleccionar(String accion) {
        switch (accion) {
            case "editar": {
                EditarPreg preg = new EditarPreg();
                break;
            }
            case "crear": {
                CrearPreg preg = new CrearPreg();
                break;
            }
            case "borrar": {
                BorrarPreg preg = new BorrarPreg();
                break;
            }
            default: System.out.println("Invalid day");
        }
    }
}
