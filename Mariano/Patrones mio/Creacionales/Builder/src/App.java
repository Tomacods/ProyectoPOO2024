//EJEMPLO CREACION CASAS
public class App {
    public static void main(String[] args) throws Exception {
        Builder constructorCasaConcreto = new ConcreteBuilder(); //CREO UN CONSTRUCTOR CONCRETO, DE TIPO CONSTRUCTOR

        Director directorCasa = new Director(constructorCasaConcreto); //CREO UN DIRECTOR Y LE PASO EL CONSTRUCTOR CONRETO POR PARAMETRO

        directorCasa.construirCasaCompleta(); //"ENSAMBLO" LA CASA
        Producto casaCompleta = directorCasa.getProducto(); //CREO EL PRODUCTO CONCRETO Y LE ASIGNO EL "ENSAMBLADO" QUE HIZO EL DIRECTOR

        System.out.println("Casa completa");
        System.out.println(casaCompleta);

        //SE USA CUANDO:
        //EL ALGORITMO PARA CREAR EL OBJETO COMPLEJO DEBE SER INDEPENDIENTE DE LAS PARTES QUE HACEN AL OBJETO Y COMO DEBE SER "ENSAMBLADO"
        //EL PROCESO DE CONSTRUCCION DEBE PERMITIR DIFERENTES REPRESENTACIONES PARA EL OBJETO QUE SE ESTA CONSTRUYENDO

        



















    }
}
