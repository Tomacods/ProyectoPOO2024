//DIRECTOR QUE DEFINE EL ORDEN DE LLAMADA DE LOS PASOS PARA LA CREACION DEL OBJETO COMPLEJO
public class Director {
    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construirCasaSimple() {
        this.construccionBasica("Simple");
        builder.construirGarage();
    }

    public void construirCasaCompleta() {
        this.construccionBasica("Completa");
        builder.construirGarage();
        builder.construirPiscina();
        builder.construirJardin();
    }

    private void construccionBasica(String nombre)
    {
        builder.crearNuevoProducto(nombre);
        builder.construirCimientos();
        builder.construirEstructura();
        builder.construirTecho();
    }

    public Producto getProducto(){
        return builder.getProducto(); //preguntar si va aca
    }
    
}
