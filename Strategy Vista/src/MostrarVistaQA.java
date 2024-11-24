//import vista.ABMPreguntas;
//import javax.swing.*;
public class MostrarVistaQA {
    
    //private ABMPreguntas abmPreguntas;
    private MostrarQA mostrar;

    public void setStrategy(MostrarQA mostrar) {
        this.mostrar = mostrar;
    }

    public void ejecutar() {
        mostrar.mostrarVista();
    }
}