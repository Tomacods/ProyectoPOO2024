//EJEMPLO AGREGARLE EXTRAS AL CAFÉ
public class App {
    public static void main(String[] args) throws Exception {
        Componente miCafe = new ComponenteConcreto(); //CREA UN COMPONENTE CONCRETO (CAFÉ), DE TIPO COMPONENTE 
        System.out.println(miCafe.getDescripcion()+"cuesta $" + miCafe.getCosto()); //MUESTRA EL DETALLE BÁSICO

        miCafe = new DecoradorConcretoA(miCafe); //AGREGARLE UN DECORATOR (AGREGARLE LECHE AL CAFÉ)
        System.out.println(miCafe.getDescripcion()+"cuesta $" + miCafe.getCosto()); //MUESTRA EL DETALLE 

        miCafe = new DecoradorConcretoB(miCafe); //AGREGARLE UN DECORATOR MAS (AGREGARLE AZÚCAR AL CAFÉ)
        System.out.println(miCafe.getDescripcion()+"cuesta $" + miCafe.getCosto()); //MUESTRA EL DETALLE 
    }

    //SE USA CUANDO:
    //SE NECESITA AÑADIR RESPONSABILIDADES A OBJETOS INDIVIDUALMENTE DE FORMA DINÁMICA Y TRANSPARENTE (SIN AFECTAR OTROS OBJETOS).
    //PARA RESPONSABILIDADES QUE PUEDEN SER QUITADAS.
    //CUANDO LA EXTENSIÓN CON SUBLCASES ES IMPRÁCTICA.
    
}
