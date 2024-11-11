// CREATE TABLE Respuesta (
//     ID_Respuesta INT PRIMARY KEY,  -- ID de la respuesta
//     ID_Pregunta INT,
//     Texto TEXT,
//     Correcta BOOLEAN,
//     FOREIGN KEY (ID_Pregunta) REFERENCES Pregunta(ID_Pregunta) -- ID de la pregunta a la que pertenece la respuesta
// );


public class Respuesta {
    private int idPregunta;
    private int id_pregunta;
    private String texto;
    private boolean correcta;


}