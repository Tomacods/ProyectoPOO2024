//AÑADE LAS RESPONSABILIDADES AL DECORADOR CONCRETO (B)
public class DecoradorConcretoB extends DecoradorBase{
    public DecoradorConcretoB(Componente bebida) {
        super(bebida); //siempre llama al super
    }

    @Override
    public String getDescripcion() {
        return bebidaDecorada.getDescripcion() + ", con Azúcar"; //DECORADOR AZÚCAR EN ESTE CASO
    }

    @Override
    public double getCosto() {
        return bebidaDecorada.getCosto() + 5.0;
    }
}