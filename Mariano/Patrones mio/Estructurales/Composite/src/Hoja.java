//REALIZAN LA MAYORIA DEL TRABAJO
public class Hoja implements Componente{
    private final String nombre;
    private final String puesto;

    public Hoja(String nombre, String puesto) {
        this.nombre = nombre;
        this.puesto = puesto;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Trabajador: " + nombre + ", Puesto: " + puesto);
    }
}
