//CLASE QUE DECLARA EL FACTORY METHOD, PUEDE SER CLASE ABSTRACTA
public abstract class Creador {
        // Factory Method que devuelve un tipo Producto(interfaz)
        protected abstract Producto crearProducto(); //puede ser public si no uso clase abstracta

        // Operación que utiliza el Factory Method
        public void planificarEntrega() {
            // Llamada al método factory para obtener el transporte concreto
            Producto transporte = crearProducto();
            transporte.entregar();
        }
}
