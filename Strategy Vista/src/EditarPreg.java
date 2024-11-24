public class EditarPreg {
    
    public EditarPreg(){
        
    }

    public void selecTipo(String tipoPreg) {
        MostrarVistaQA mostrar = new MostrarVistaQA();
        if(tipoPreg == "Multiple choice") {
            mostrar = new StrategyMC();
        } else {
            if (tipoPreg == "Aproximacion") {
                mostrar = new StrategyAprox();
            } else {
                throw new IllegalArgumentException("Tipo ingresado erroneamente.");
            }
        }
        mostrar.mostrarVista();
    }

    public void selectTemarica(String tematica){

    }

    public void editarPregunta(){

    }
}
