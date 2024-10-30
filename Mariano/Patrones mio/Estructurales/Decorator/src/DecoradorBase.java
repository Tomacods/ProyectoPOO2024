//DEFINE QUE HACEN LOS DECORADORES
public abstract class DecoradorBase implements Componente{
    protected Componente bebidaDecorada; //puede ser protected o private

    public DecoradorBase(Componente bebida) {
        this.bebidaDecorada = bebida;
    }

    @Override
    public String getDescripcion() {
        return bebidaDecorada.getDescripcion();
    }

    @Override
    public double getCosto() {
        return bebidaDecorada.getCosto();
    }
}
