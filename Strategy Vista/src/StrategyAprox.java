import vista.ABMRespuestaAprox;
public class StrategyAprox implements  MostrarQA {
    private ABMRespuestaAprox abmRespuestaAprox;
    @Override
    public void mostrarVista() {
        abmRespuestaAprox.setVisible(true);
    }
}
