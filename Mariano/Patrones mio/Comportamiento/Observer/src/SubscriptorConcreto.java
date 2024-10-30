//HACEN ALGUNA ACCION EN BASE A LO QUE SE NOTIFICA
public class SubscriptorConcreto  implements Subscriptor {
    private String nombre;

    public SubscriptorConcreto(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String producto, double precio) {
        System.out.println("El cliente " + nombre + " es notificado: El precio del producto " + producto + " se actualizo a $"
                + precio);
    }
}
