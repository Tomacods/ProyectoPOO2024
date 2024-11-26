# ProyectoPOO2024


nos separamos en 2 grupos

grupo 1: alanis, reyes, gonazales, Montoya: IGU

(subdividimos el grupo 2 en 2 partes, una para la base de datos y la otra para la parte de la logica con las clases)
grupo2.a: millavanque, roldan
grupo2.b: Da Silva, Molina

aunque el grupo 2 tenga una subdivision siguen comunicandose como un solo grupo


aclaracion nosotros estamos usando como base de datos posgres17, restaurar la base de datos que esta en la carpeta del proyecto base de datos, una vez armada la base de datos y restaurada respectivamente cambiar los parametros en la clase base de datos "8escalones/Proyecto/src/DAOs/BaseDeDatos.java"
public class BaseDeDatos {
    private static Connection connection;
    private static BaseDeDatos bd;
    private String url = "jdbc:postgresql://localhost/"; //SI LO VAN A USAR TIENEN Q CAMBIAR LOS DATOS CON SU COMPU
    private String nombre="8Escalones"; --nombre de la base de datos que se creo
    private String usuario="postgres"; --cambiar el usuario si es que tiene otro nombre
    private String clave="   "; -- contraseña del usuario de pgadmin

    por los respectivos valores
