//IMPLEMENTAN LOS MÉTODOS ESPECIFICOS, SE PUEDE USAR HERENCIA
//PUEDE SETEAR EL ESTADO PARA TRANSICIONAR A OTRO
public class EstadoConcretoC implements Estado { //ESTADO: PRODUCTO SELECCIONADO
    @Override
    public void insertarDinero(Contexto maquina) {
        System.out.println("Ya has seleccionado un producto. Espera la dispensación.");
    }

    @Override
    public void seleccionarProducto(Contexto maquina) {
        System.out.println("Ya seleccionaste un producto. Espera la dispensación.");
    }

    @Override
    public void dispensar(Contexto maquina) {
        System.out.println("Dispensando el producto...");
        maquina.setEstado(new EstadoConcretoA()); //sin dinero
    }
}
