//UTILIZA ESTRATEGIAS
public class Contexto {
    private Estrategia estrategiaDePago;

    // Permitir al usuario elegir el método de pago
    public void setEstrategiaDePago(Estrategia estrategiaDePago) {
        this.estrategiaDePago = estrategiaDePago;
    }

    // Realizar el pago usando la estrategia seleccionada
    public void pagar(double monto) {
        estrategiaDePago.pagar(monto);
    }
}
