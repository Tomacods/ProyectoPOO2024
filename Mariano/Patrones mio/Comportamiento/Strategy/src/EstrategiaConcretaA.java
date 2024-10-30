//ESTRATEGIA CONCRETA (A), LE DA CUERPO ESPECIFICO AL METODO 
public class EstrategiaConcretaA implements Estrategia {
    private String email;

    public EstrategiaConcretaA(String email) {
        this.email = email;
    }

    @Override
    public void pagar(double monto) {
        System.out.println("Pagando " + monto + " usando Debito. Email: " + email);
    }
}
