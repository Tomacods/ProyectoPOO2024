//AÑADE LAS RESPONSABILIDADES AL DECORADOR CONCRETO (A)
public class DecoradorConcretoA extends DecoradorBase{
    public DecoradorConcretoA(Componente bebida) {
        super(bebida); //siempre llama al super
    }

    @Override
    public String getDescripcion() {
        return bebidaDecorada.getDescripcion() + ", con Leche"; //DECORADOR LECHE EN ESTE CASO
    }

    @Override
    public double getCosto() {
        return bebidaDecorada.getCosto() + 10.0;
    }
}
