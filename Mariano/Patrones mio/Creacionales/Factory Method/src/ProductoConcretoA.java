//IMPLEMENTACION CONCRETA (A) DE LA INTERFAZ PRODUCTOS 
public class ProductoConcretoA implements Producto{
    @Override
    public void entregar() {
        System.out.println("La entrega será por mar en un barco.");
    }    
}
