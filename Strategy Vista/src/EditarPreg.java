/* import vista.ABMTematicas;
 */
public class EditarPreg {
    
    public EditarPreg(){
        
    }

    public void selectTipo(String tipoPreg) {
        MostrarVistaQA mostrar = new MostrarVistaQA();
        if(tipoPreg == "Multiple choice") {
            mostrar.setStrategy(new StrategyMC());
        } else {
            if (tipoPreg == "Aproximacion") {
                mostrar.setStrategy(new StrategyAprox());
            } else {
                throw new IllegalArgumentException("Tipo ingresado erroneamente.");
            }
        }
        mostrar.ejecutar();
    }

    public void selectTematica(String tematica){

    }

    public void editarPregunta(){

    }
}
