import java.util.ArrayList;
import java.util.List;

//TIENE SUBELEMENTOS QUE FUNCIONAN A TRAVES DE LA INTERFAZ COMPONENTE
//CUANDO RECIBE UN PEDIDO LO DELEGA A LOS SUBELEMENTOS
public class Composite implements Componente{
    private final String nombre;
    private final String puesto;
    private final List<Componente> subordinados;//ARRAY DE LA INTERFAZ COMPONENTE (HIJOS)

    public Composite(String nombre, String puesto) {
        this.nombre = nombre;
        this.puesto = puesto;
        subordinados = new ArrayList<>();
    }

    //ADD
    public void agregarSubordinado(Componente empleado) {
        subordinados.add(empleado);
    }

    //REMOVE
    public void removerSubordinado(Componente empleado) {
        subordinados.remove(empleado);
    }

    //GET HIJO
    @Override
    public void mostrarDetalles() {
        System.out.println("Supervisor: " + nombre + ", Puesto: " + puesto);
        System.out.println("Subordinados:");
        for (Componente subordinado : subordinados) {
            subordinado.mostrarDetalles();  // Recursivamente muestra los detalles de subordinados
        }
    }
}
