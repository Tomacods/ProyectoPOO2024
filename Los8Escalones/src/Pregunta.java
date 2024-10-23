public class Pregunta { 
    private int id;
    private String enunciado;
    private String tipoPregunta;
    private String categoria;
    private String dificultad; // todavia no se si se va a usar, por el momento se queda
    private String respuestaCorrecta;
    private double valorAproximado;
// esta clase puede ser una clase padre y tener 2 hijas que sean pregunta aproximacion o pregunta multiple opcion
//y de ahi manejar la pregunta de acuerdo a su tipo

}
//la clase abstracta puede ser algo asi
/*public abstract class Pregunta { 
    protected int id;
    protected String enunciado;
    protected String categoria;
    protected String dificultad;

    public Pregunta(int id, String enunciado, String categoria, String dificultad) {
        this.id = id;
        this.enunciado = enunciado;
        this.categoria = categoria;
        this.dificultad = dificultad;
    }

    public abstract boolean esCorrecta(String respuesta);
} 
    con sus hijas 
    
    public class PreguntaMultipleChoice extends Pregunta {
    private String respuestaCorrecta;

    public PreguntaMultipleChoice(int id, String enunciado, String categoria, String dificultad, String respuestaCorrecta) {
        super(id, enunciado, categoria, dificultad);
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    public class PreguntaAproximacion extends Pregunta {
    private double valorAproximado;

    public PreguntaAproximacion(int id, String enunciado, String categoria, String dificultad, double valorAproximado) {
        super(id, enunciado, categoria, dificultad);
        this.valorAproximado = valorAproximado;
    } etc etc etc
    */

