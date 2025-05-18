package controlador;

import Modelos.PreguntaAproximacion;
import Vista.ABMRespuestaAprox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * ControladorABMRespuestaAprox es el controlador encargado de gestionar la lógica de la vista
 * ABMRespuestaAprox para la creación y edición de preguntas de aproximación en el sistema.
 * 
 * Este controlador permite:
 * <ul>
 *   <li>Inicializar la vista para crear una nueva pregunta o editar una existente.</li>
 *   <li>Guardar los cambios realizados en la pregunta de aproximación.</li>
 *   <li>Insertar una nueva pregunta o actualizar una existente en la base de datos.</li>
 *   <li>Gestionar la navegación de la interfaz de usuario.</li>
 * </ul>
 * 
 * Atributos:
 * <ul>
 *   <li><b>vista</b>: Instancia de la vista ABMRespuestaAprox.</li>
 *   <li><b>preguntaActual</b>: PreguntaAproximacion que se está creando o editando.</li>
 *   <li><b>esNueva</b>: Indica si la pregunta es nueva o se está editando una existente.</li>
 * </ul>
 * 
 * Métodos principales:
 * <ul>
 *   <li><b>iniciarVista()</b>: Inicializa la vista y configura los valores iniciales de los campos.</li>
 *   <li><b>volver()</b>: Guarda los cambios y realiza la inserción o actualización de la pregunta.</li>
 *   <li><b>guardarCambios()</b>: Actualiza los atributos de la pregunta con los valores ingresados en la vista.</li>
 * </ul>
 * 
 * Excepciones:
 * <ul>
 *   <li>Puede lanzar SQLException al interactuar con la base de datos.</li>
 * </ul>
 * 
 * Uso típico:
 * <pre>
 *     ControladorABMRespuestaAprox controlador = new ControladorABMRespuestaAprox(pregunta, true);
 * </pre>
 */
public class ControladorABMRespuestaAprox {
    private ABMRespuestaAprox vista;
    private PreguntaAproximacion preguntaActual;
    private boolean esNueva;
    
    public ControladorABMRespuestaAprox(PreguntaAproximacion pregunta, boolean esNueva) {
        this.vista = new ABMRespuestaAprox();
        this.preguntaActual = pregunta;
        this.esNueva = esNueva;
        iniciarVista();
    }

    private void iniciarVista() {
        if (esNueva == true) {
            this.preguntaActual.setEnunciado("Ingresar enunciado de la pregunta");
            this.vista.jTextFieldRespuesta.setText("Ingresar la respuesta correcta ->");
        } else{
            this.vista.jTextFieldRespuesta.setText(String.valueOf(this.preguntaActual.getValorAproximado()));
        }
        this.vista.jTextFieldPreguntaAprox.setText(this.preguntaActual.getEnunciado());

        this.vista.jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    volver();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        this.vista.setVisible(true);
    }

    private void volver() throws SQLException {

        guardarCambios();

        if (esNueva == false) {
            System.out.println("actualizando pregunta...");
            PreguntaAproximacion.actualizarPreguntaAprox(this.preguntaActual);
        }
        else {
            System.out.println("insertando nueva pregunta...");
            PreguntaAproximacion.insertarPreguntaAproximacion(this.preguntaActual);
        }

        this.vista.dispose();
        ControladorABMPreguntas controladorPreguntas = new ControladorABMPreguntas();
    }

    private void guardarCambios() {

        preguntaActual.setEnunciado(vista.jTextFieldEditarPregunta.getText());
        System.out.println("nuevo enunciado: " + preguntaActual.getEnunciado());

        try{
            preguntaActual.setValorAproximado(Integer.parseInt(vista.jTextFieldEditarRespuesta.getText()));
            System.out.println("nuevo valor aproximado: " + preguntaActual.getValorAproximado());
            } catch(NumberFormatException e){
                System.out.println("Este valor no es valido");
            }
    }

}
