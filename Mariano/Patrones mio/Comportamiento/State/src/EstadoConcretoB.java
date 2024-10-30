//IMPLEMENTAN LOS MÉTODOS ESPECIFICOS, SE PUEDE USAR HERENCIA
//PUEDE SETEAR EL ESTADO PARA TRANSICIONAR A OTRO
public class EstadoConcretoB implements Estado { //ESTADO: CON DINERO
    @Override
    public void insertarDinero(Contexto maquina) {
        System.out.println("Ya has insertado dinero. Selecciona un producto.");
    }

    @Override
    public void seleccionarProducto(Contexto maquina) {
        System.out.println("Producto seleccionado.");
        maquina.setEstado(new EstadoConcretoC()); //producto seleccionado
    }

    @Override
    public void dispensar(Contexto maquina) {
        System.out.println("Primero selecciona un producto.");
    }
}
