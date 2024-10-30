//SOOBRESCRIBE EL FACTORY METHOD PARA DEVOLVER UNA INSTANCIA DE UN PRODUCTO CONCRETO (A)
public class CreadorConcretoA extends Creador{
    @Override
    protected Producto crearProducto(){
        return new ProductoConcretoA();//DEVUELVE UN PRODUCTO CONCRETO A
    }
}
