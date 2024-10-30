//PUEDE SETEAR EL ESTADO PARA TRANSICIONAR A OTRO
public class Contexto {
    private Estado estadoActual; //MISMO TIPO DE LA INTERFAZ

    public Contexto() {
        // Estado inicial: Sin Dinero
        this.estadoActual = new EstadoConcretoA();
    }

    // Cambiar el estado actual
    public void setEstado(Estado nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    // Métodos que delegan la operación al estado actual
    public void insertarDinero() {
        estadoActual.insertarDinero(this);
    }

    public void seleccionarProducto() {
        estadoActual.seleccionarProducto(this);
    }

    public void dispensar() {
        estadoActual.dispensar(this);
    }
}
