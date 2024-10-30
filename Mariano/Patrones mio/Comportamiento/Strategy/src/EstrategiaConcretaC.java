//ESTRATEGIA CONCRETA (C), LE DA CUERPO ESPECIFICO AL METODO 
public class EstrategiaConcretaC implements Estrategia {
    private String direccionWallet;

    public EstrategiaConcretaC(String direccionWallet) {
        this.direccionWallet = direccionWallet;
    }

    @Override
    public void pagar(double monto) {
        System.out.println("Pagando " + monto + " usando Bitcoin. Wallet: " + direccionWallet);
    }
}
