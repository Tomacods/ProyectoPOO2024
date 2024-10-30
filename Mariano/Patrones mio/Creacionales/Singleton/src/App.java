public class App {
    public static void main(String[] args) throws Exception {
        Singleton instancia1 = Singleton.obtenerInstancia(); //CREO EL OBJETO (INSTANCIA1) DE TIPO SINGLETON MEDIANTE LA UNICA INSTANCIA DE CLASE
        Singleton instancia2 = Singleton.obtenerInstancia();//CREO EL OBJETO (INSTANCIA2) DE TIPO SINGLETON MEDIANTE LA UNICA INSTANCIA DE CLASE
        
        // Comprobar que ambas instancias son iguales
        if (instancia1 == instancia2) {
            System.out.println("Ambas referencias apuntan a la misma instancia.");
        }
    }

    //USAR CUANDO:
    //DEBE EXISTIR SOLO UNA INSTANCIA DE UNA CLASE Y DEBE SER ACCESIBLE A CLIENTES DESDE UN SOLO PUNTO
}
