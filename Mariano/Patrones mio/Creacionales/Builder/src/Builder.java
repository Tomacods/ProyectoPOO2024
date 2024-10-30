//INTERFAZ CONSTRUCTOR O BUILDER
//DECLARA LOS PASOS COMUNES A TODOS LOS BUILDER
public interface Builder {
    public void crearNuevoProducto(String nombre);
    public Producto getProducto();
    public void construirCimientos();
    public void construirEstructura();
    public void construirTecho();
    public void construirGarage();
    public void construirPiscina();
    public void construirJardin();
}
