//IMPLEMENTACION CONCRETA (B) DE LA INTERFAZ PRODUCTOS
public class ProductoConcretoB implements Producto{
    @Override
    public void entregar() {
        System.out.println("La entrega será por carretera en un camión.");
    }    
}