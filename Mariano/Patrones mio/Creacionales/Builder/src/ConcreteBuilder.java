//CONSTRUCTOR CONCRETO(1) QUE PROVEE IMPLEMENTACIONES DE LA INTERFAZ BUILDER
//PODRIA HABER UN CONSTRUCTOR CONCRETO(2) PERO DEBERIA CREAR UNA NUEVA CLASE
public class ConcreteBuilder implements Builder{
    private Producto Producto;

    @Override
    public Producto getProducto() {
        return Producto;
    }

    @Override
    public void crearNuevoProducto(String nombre) {
        Producto = new Producto(nombre);
    }

    @Override
    public void construirCimientos() {
        Producto.setFoundation("Cimientos de concreto");
    }

    @Override
    public void construirEstructura() {
        Producto.setEstructura("Estructura de madera");
    }

    @Override
    public void construirTecho() {
        Producto.setTecho("Techo de tejas");
    }

    @Override
    public void construirGarage() {
        Producto.setGarage(true);  // Optional
    }

    @Override
    public void construirPiscina() {
        Producto.setPiscina(false);  // Optional
    }

    @Override
    public void construirJardin() {
        Producto.setJardin(true);  // Optional
    }

}
