//IMPLEMENTAN LOS MÉTODOS ESPECIFICOS, SE PUEDE USAR HERENCIA
//PUEDE SETEAR EL ESTADO PARA TRANSICIONAR A OTRO
public class EstadoConcretoD implements Estado { //ESTADO: PRODUCTO AGOTADO
    @Override
    public void insertarDinero(Contexto maquina) {
        System.out.println("No puedes insertar dinero. El producto está agotado.");
    }

    @Override
    public void seleccionarProducto(Contexto maquina) {
        System.out.println("Producto agotado. No puedes seleccionarlo.");
    }

    @Override
    public void dispensar(Contexto maquina) {
        System.out.println("Producto agotado. No se puede dispensar.");
    }
}
