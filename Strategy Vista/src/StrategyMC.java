import vista.ABMRespuestaMC;

public class StrategyMC implements MostrarQA {
    private ABMRespuestaMC abmRespuestaMC;
    @Override
    public void mostrarVista() {
        abmRespuestaMC.setVisible(true);
    }
}