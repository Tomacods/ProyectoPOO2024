//DEFINE UN COMPONENTE CONCRETO AL CUAL SE LE PUEDEN AGREGAR NUEVAS RESPONSABIIDADES (CAFÉ EN ESTE CASO)
public class ComponenteConcreto implements Componente{
    @Override
    public String getDescripcion() {
        return "Café";
    }

    @Override
    public double getCosto() {
        return 50.0;
    }
}
