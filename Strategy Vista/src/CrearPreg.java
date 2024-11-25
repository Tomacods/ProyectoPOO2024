/* import vista.ABMTematicas;
 */

// creo q deberíamos traer el controlador de temáticas para tratarlas.

public class CrearPreg {
    
    public CrearPreg(){
        
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

    public void crearPregunta(){

    }
}
