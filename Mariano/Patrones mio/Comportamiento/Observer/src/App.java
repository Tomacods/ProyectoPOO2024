//EJEMPLO TIENDA QUE INFORMA SOBRE UNA COMPUTADORA
public class App {
    public static void main(String[] args) throws Exception {

    // El producto es el sujeto, es el objeto OBSERVADO
    Notificador producto = new Notificador("Netbook", 1500.00); //CREO EL PRODUCTO OBSERVADO (COMPUTADORA)
        
    // Los clientes son los OBSERVADORES, son quienes necesitan enterarse de los cambios del producto
    SubscriptorConcreto cliente1 = new SubscriptorConcreto("Mariano"); //CREO EL PRODUCTO OBSERVADOR (CLIENTES)
    
    // Los clientes se suscriben el producto
    producto.suscribir(cliente1);

    // Al cambiar el precio del producto, este deberá notificar a sus suscriptores que hubo un cambio
    producto.setPrecio(10000); //METODO QUE ENVIA UNA NOTIFICACION
    System.out.println();
    }

    //USAR CUANDO:
    //UNA ABSTRACCIÓN TIENE DOS ASPECTOS, UNO DEPENDIENTE DE OTRO. ENCAPSULAR ESTOS OBJETOS DE FORMA SEPARADA PERMITE VARIAR Y
    //REUSARLOS DE MANERA INDEPENDIENTE.

    //UN CAMBIO EN UN OBJETO REQUIERE CAMBIOS EN OTROS Y NO SE SABEN CUANTOS OBJETOS DEBEN SER CAMBIADOS.
    //UN OBJETO DEBE NOTIFICAR A OTROS SIN HACER SUPOSICIONES SOBRE QUÉ OBJETOS SE ESTÁ TRATANDO. 
}
