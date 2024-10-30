//FACHADA HACIA UN SUBSISTEMA COMPLEJO, EN ESTE CASO UN CINE
public class Facade{
    //ENLACES AL SUBSISTEMA(ATRIBUTOS DE OTRAS CLASES)
    private Proyector proyector;
    private SistemaDeSonido sistemaDeSonido;
    private Boleto boleto;

    public Facade() {
        proyector = new Proyector();
        sistemaDeSonido = new SistemaDeSonido();
        boleto = new Boleto();
    }

    // Método que combina todas las operaciones complejas en una sola llamada
    public void iniciarCine(String asiento, int volumen) {
        // Reservar boleto
        boleto.reservarAsiento(asiento);
        
        // Encender el proyector
        proyector.encender();
        proyector.configurarEntrada();

        // Encender y configurar el sistema de sonido
        sistemaDeSonido.encender();
        sistemaDeSonido.ajustarVolumen(volumen);
    }

    public void apagarCine() {
        proyector.apagar();
        sistemaDeSonido.apagar();
    }
}