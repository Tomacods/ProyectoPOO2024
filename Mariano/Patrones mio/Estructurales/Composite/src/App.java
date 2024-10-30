//EJEMPLO JERARQUIA TRABAJADORES
public class App {
    public static void main(String[] args) throws Exception {
        Hoja trabajador1 = new Hoja("Trabajador 1", "Puesto 1"); //CREA HIJOS
        Hoja trabajador2 = new Hoja("Trabajador 2", "Puesto 2"); //CREA HIJOS
        Hoja trabajador3 = new Hoja("Trabajador 3", "Puesto 3"); //CREA HIJOS

        Composite supervisor1 = new Composite("Supervisor 1", "Puesto 1"); //COMPOSITE (SUPERVISOR) QUE CONTENDRA HIJOS (TRABAJADROES Y SUPERVISORES)
        supervisor1.agregarSubordinado(trabajador1);
        supervisor1.agregarSubordinado(trabajador2);
        supervisor1.agregarSubordinado(trabajador3);
        supervisor1.mostrarDetalles();
    }

    //USAR CUANDO:
    //CUANDO SE REQUIERE PRESENTAR PARTE O TODA UNA JERARQUIA DE OBJETOS.
    //SE QUIERE QUE LOS CLIENTES PUEDAN IGNORAR LAS DIFERENCIAS ENTRE LA COMPOSICIÓN DE OBJETOS O DE LOS OBJETOS INDIVIDUALES.
    //EL CLIENTE VA A TRATAR A TODOS LOS OBJETOS COMO UNA ESTRUCTURA COMPUESTA UNIFORME.

    //CUANDO EL MODELO CENTRAL DE LA APLICACIÓN PUEDE SER REPRESENTADO COMO UN ARBOL.
}
