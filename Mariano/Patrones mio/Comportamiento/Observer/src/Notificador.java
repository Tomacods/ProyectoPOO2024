import java.util.ArrayList;
import java.util.List;

//ESTA ES LA CLASE QUE PUEDE TENER SUBSCRIPTORES
//Y LA QUE DEBERA NOTIFICAR A SUS SUBSCRIPTORES CADA VEZ QUE HAYA ALGUN CAMBIO IMPORTANTE
public class Notificador {
    private String nombre;
    private double precio;
    // Esta es la lista de suscriptores, contiene los objetos a los que se notificara cuando haya algun cambio
    // Todo aquel objeto que implemente la interfaz Subscriptor puede ser agregado a esta lista
    private List<Subscriptor> suscriptores = new ArrayList<>();

    public Notificador(String name, double precio) {
        this.nombre = name;
        this.precio = precio;
    }

    // Este metodo permite agregar suscriptores
    public void suscribir(Subscriptor cliente) {
        suscriptores.add(cliente);
    }

    // Este metodo permite quitar suscriptores
    public void desuscribir(Subscriptor cliente) {
        suscriptores.remove(cliente);
    }

    // Este metodo es el que puede provocar una notificacion
    // Muchos metodos pueden generar una notificacion, no tiene que ser solamente uno
    // Podria tener otro metodo que cambie el nombre y tambien podria generar notificaciones
    // Para ello deben llamar al metodo privado notificar
    public void setPrecio(double precio) {
        String mensaje = String.format("El producto %s cambio su precio a de %.2f a %.2f", this.nombre, this.precio, precio);
        System.out.println(mensaje);
        this.precio = precio;
        notificar();
    }

    //ESTE ES EL METODO QUE NOTIFICARA A LOS SUBSCRIPTORES,
    // aquel metodo que quiera que se notifique a los suscriptores 
    // sobre algun cambio
    private void notificar() {
        for (Subscriptor cliente : suscriptores) {
            // Usamos el metodo actualizar declarado en la interfaz para notificar 
            cliente.actualizar(nombre, precio);
        }
    }
}
