//(PRODUCTO1), OBJETO FINAL QUE SE VA A CONSTRUIR
//PODRIA HABER UN PRODUCTO(2) PERO DEBERIA CREAR UNA NUEVA CLASE
public class Producto {
    private final String nombre;
    private String cimientos;
    private String estructura;
    private String techo;
    private boolean tieneGarage;
    private boolean tienePiscina;
    private boolean tieneJardin;

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public void setFoundation(String cimientos) {
        this.cimientos = cimientos;
    }

    public void setEstructura(String estructura) {
        this.estructura = estructura;
    }

    public void setTecho(String techo) {
        this.techo = techo;
    }

    public void setGarage(boolean tieneGarage) {
        this.tieneGarage = tieneGarage;
    }

    public void setPiscina(boolean tienePiscina) {
        this.tienePiscina = tienePiscina;
    }

    public void setJardin(boolean tieneJardin) {
        this.tieneJardin = tieneJardin;
    }

    @Override
    public String toString() {
        return "Producto " + nombre + "\n[\nCimientos: " + cimientos +
               "\nEstructura: " + estructura +
               "\nTecho: " + techo +
               (tieneGarage ? "\ntiene Garage" : "") +
               (tienePiscina ? "\ntiene Piscina" : "") +
               (tieneJardin ? "\ntiene Jardin" : "") + "\n]";
    }
}
