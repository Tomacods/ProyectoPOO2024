//import vista.ABMPreguntas;
//import javax.swing.*;
public class MostrarVistaQA {
    
    //private ABMPreguntas abmPreguntas;
    private MostrarQA mostrar;

    public void setStrategy(MostrarQA mostrar) {
        this.mostrar = mostrar;
    }

    public void ejecutar(/* String tipo */) {
        /* if(tipo == "Multiple choice") {
            mostrar = new StrategyMC();
        } else {
            if (tipo == "Aproximacion") {
                mostrar = new StrategyAprox();
            } else {
                throw new IllegalArgumentException("Tipo ingresado erroneamente.");
            }
        } */
        mostrar.mostrarVista();
    }
}