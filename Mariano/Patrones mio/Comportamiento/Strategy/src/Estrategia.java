//INTERFAZ QUE DECLARA UN MÉTODO QUE LA CLASE CONTEXTO UTILIZA PARA EJECUTAR UNA ESTRATEGIA
public interface Estrategia {
    // Método para realizar el pago
    void pagar(double monto);
}
