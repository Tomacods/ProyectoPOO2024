//INTERFAZ QUE DECLARA METODOS ESPECIFICOS, TIENEN QUE TENER SENTIDO PARA TODOS LOS ESTADOS CONCRETOS
public interface Estado {
    void insertarDinero(Contexto maquina);
    void seleccionarProducto(Contexto maquina);
    void dispensar(Contexto maquina);
}