//IMPLEMENTAN LOS MÉTODOS ESPECIFICOS, SE PUEDE USAR HERENCIA
//PUEDE SETEAR EL ESTADO PARA TRANSICIONAR A OTRO
public class EstadoConcretoA implements Estado { //ESTADO: SIN DINERO
    @Override
    public void insertarDinero(Contexto maquina) {
        System.out.println("Dinero insertado correctamente.");
        maquina.setEstado(new EstadoConcretoB()); //con dinero
    }

    @Override
    public void seleccionarProducto(Contexto maquina) {
        System.out.println("No puedes seleccionar un producto | insertar dinero.");
    }

    @Override
    public void dispensar(Contexto maquina) {
        System.out.println("Primero debes insertar dinero.");
    }
}
