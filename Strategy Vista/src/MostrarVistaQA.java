public class MostrarVistaQA {
    
    private MostrarQA mostrar;

    public void setStrategy(MostrarQA mostrar) {
        this.mostrar = mostrar;
    }

    public void ejecutar() {
        mostrar.mostrarVista();
    }
}