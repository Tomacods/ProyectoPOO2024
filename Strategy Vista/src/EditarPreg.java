public class EditarPreg {
    
    /* private String tematica;
    private String tipoPreg; */
    private MostrarVistaQA mostrarVista;

    public EditarPreg() {
        this.tematica = "null";
        this.tipoPreg = "null";
        this.mostrar = new MostrarVistaQA();
    }

    public selecTipo(String tipoPreg) {
        if(tipoPreg == "Multiple choice") {
            mostrarVista = new StrategyMC();
        } else {
            if (tipoPreg == "Aproximacion") {
                mostrarVista = new StrategyAprox();
            } else {
                throw new IllegalArgumentException("Tipo ingresado erroneamente.");
            }
        }
        mostrar.mostrarVista();
    }
}
