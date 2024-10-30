//SOOBRESCRIBE EL FACTORY METHOD PARA DEVOLVER UNA INSTANCIA DE UN PRODUCTO CONCRETO (B)
public class CreadorConcretoB extends Creador{
    @Override
    protected Producto crearProducto(){
        return new ProductoConcretoB();//DEVUELVE UN PRODUCTO CONCRETO B
    }
}
