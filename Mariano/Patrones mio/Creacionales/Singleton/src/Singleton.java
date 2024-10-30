public class Singleton{
        // Variable estática que almacena la única instancia de la clase
        private static Singleton instancia;

        private String name;
    
        // Constructor privado para evitar que se creen instancias desde fuera de la clase
        private Singleton() {
            this.name = "Ejemplo singleton";
        }
    
        // Método público estático para obtener la única instancia de la clase
        public static Singleton obtenerInstancia() {
            if (instancia == null) {
                instancia = new Singleton();
            }
            return instancia;
        }
}