//ESTRATEGIA CONCRETA (B), LE DA CUERPO ESPECIFICO AL METODO 
public class EstrategiaConcretaB implements Estrategia{
    private String numeroTarjeta;
    private String titular;

    public EstrategiaConcretaB(String numeroTarjeta, String titular) {
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
    }

    @Override
    public void pagar(double pago) {
        System.out.println("Pagando " + pago + " usando tarjeta de crédito. Detalles: " + 
                            "Número de tarjeta: " + numeroTarjeta + ", Titular: " + titular);
    }
}
