//EJEMPLO MAQUINA EXPENDEDORA, TIENE DISTINTOS ESTADOS DEPENDIENDO DEL DINERO Y LOS PRODUCTOS
public class App {
    public static void main(String[] args) throws Exception {
        Contexto maquina = new Contexto(); //CREO EL CONTEXTO (MAQUINA)
        
        //REALIZO MOVIMIENTOS EN LA MAQUINA, MOVIMIENTOS EN LOS CUALES EL ESTADO DE LA MAQUINA CAMBIA

        // Intentando seleccionar un producto sin insertar dinero
        System.out.println("Seleccionar un producto...");
        maquina.seleccionarProducto();

        // Insertar dinero y seleccionar producto
        System.out.println();
        maquina.insertarDinero();
        System.out.println("Seleccionar un producto...");
        maquina.seleccionarProducto();

        // Dispensar el producto
        System.out.println();
        maquina.dispensar();

        // Intentar dispensar nuevamente sin dinero
        System.out.println();
        System.out.println("Dispensar otro producto...");
        maquina.dispensar();

        //USAR CUANDO:
        //EL COMPORTAMIENTO DE UN OBJETO DEPENDE DE SU ESTADO Y DEBE CAMBIAR SU COMPORTAMIENTO EN TIEMPO DE EJECUCIÓN.
        
        //UNA OPERACIÓN TIENE MUCHAS SENTENCIAS CONDICIONALES QUE DEPENDEN DEL ESTADO DEL OBJETO.
        //EL ESTADO SUELE ESTAR REPRESENTADO POR UNA O VARIAS CONSTANTES









    }
}
