package controlador;

import Modelos.MultipleChoicePregunta;
import Modelos.Respuesta;
import Vista.ABMRespuestaMC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * ControladorABMRespuestaMC es el controlador encargado de gestionar la vista y la lógica
 * asociada al alta, baja y modificación de respuestas de preguntas de tipo Multiple Choice.
 * 
 * Este controlador interactúa con la vista ABMRespuestaMC y la clase de modelo MultipleChoicePregunta,
 * permitiendo crear nuevas preguntas, editar preguntas existentes y gestionar las respuestas asociadas.
 * 
 * Funcionalidades principales:
 * <ul>
 *   <li>Inicializa la vista y la pregunta actual, configurando los campos y respuestas según corresponda.</li>
 *   <li>Permite modificar el enunciado y las respuestas de la pregunta.</li>
 *   <li>Gestiona la selección de la respuesta correcta.</li>
 *   <li>Guarda los cambios realizados, ya sea actualizando una pregunta existente o insertando una nueva.</li>
 *   <li>Permite cerrar la ventana de edición sin guardar cambios.</li>
 * </ul>
 * 
 * Dependencias:
 * <ul>
 *   <li>ABMRespuestaMC: Vista asociada para la edición de preguntas Multiple Choice.</li>
 *   <li>MultipleChoicePregunta: Modelo de pregunta de opción múltiple.</li>
 *   <li>Respuesta: Modelo de respuesta individual.</li>
 * </ul>
 * 
 * Uso:
 * <pre>
 *     ControladorABMRespuestaMC controlador = new ControladorABMRespuestaMC(pregunta, esNueva);
 * </pre>
 * 
 * @author tomas
 */
public class ControladorABMRespuestaMC {
    private ABMRespuestaMC vista;
    private MultipleChoicePregunta pregunta_actual;
    private boolean esNueva;

    public ControladorABMRespuestaMC(MultipleChoicePregunta pregunta, boolean esNueva) throws SQLException {
        this.vista = new ABMRespuestaMC();
        this.pregunta_actual = pregunta;
        this.esNueva = esNueva;
        iniciarVista();

    }

    private void iniciarVista() throws SQLException {
        if (esNueva == true) {
            this.pregunta_actual.setEnunciado("Ingrese el enunciado de la pregunta");
            for (int i = 1; i < 5; i++) {
                Respuesta rta = new Respuesta(0,0,"",false);
                this.pregunta_actual.agregarRespuesta(rta);
            }
        }
        this.vista.jTextFieldPreguntaMC.setText(this.pregunta_actual.getEnunciado());
        List<Respuesta> respuestas = this.pregunta_actual.getOpciones();
        this.vista.jTextFieldRtaA.setText(respuestas.get(0).getTexto());
        this.vista.jTextFieldRtaB.setText(respuestas.get(1).getTexto());
        this.vista.jTextFieldRtaC.setText(respuestas.get(2).getTexto());
        this.vista.jTextFieldRtaD.setText(respuestas.get(3).getTexto());
        this.vista.jRadioButtonRtaA.setSelected(true);

        this.vista.jButtonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    volver();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        this.vista.jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                salir();
            }
        });

        this.vista.setVisible(true);
    }

    private void volver() throws SQLException {

        cambiar_correcta();
        this.pregunta_actual.setEnunciado(this.vista.jTextFieldPreguntaMC1.getText());
        modificar_respuesta(0, vista.jTextFieldRtaA.getText());
        modificar_respuesta(1, vista.jTextFieldRtaB.getText());
        modificar_respuesta(2, vista.jTextFieldRtaC.getText());
        modificar_respuesta(3, vista.jTextFieldRtaD.getText());

        if (esNueva == false) {
            System.out.println("actualizando pregunta...");
            MultipleChoicePregunta.actualizarPregunta(pregunta_actual);
        }
        else {
            System.out.println("insertando nueva pregunta...");
            MultipleChoicePregunta.insertarPregunta(pregunta_actual, this.pregunta_actual.getOpciones());
        }
        this.vista.dispose();
        ControladorABMPreguntas controladorPreguntas = new ControladorABMPreguntas();
    }

    private void salir() {
        this.vista.dispose();
    }

    private void modificar_respuesta(int indice, String texto) {
        this.pregunta_actual.getOpciones().get(indice).setTexto(texto);
    }

    private void cambiar_correcta() {
        if (this.vista.jRadioButtonRtaA.isSelected())
            this.pregunta_actual.setRespuestaCorrecta(this.vista.jTextFieldRtaA.getText());
        else if (this.vista.jRadioButtonRtaB.isSelected())
            this.pregunta_actual.setRespuestaCorrecta(this.vista.jTextFieldRtaB.getText());
        else if (this.vista.jRadioButtonRtaC.isSelected())
            this.pregunta_actual.setRespuestaCorrecta(this.vista.jTextFieldRtaC.getText());
        else if (this.vista.jRadioButtonRtaD.isSelected())
            this.pregunta_actual.setRespuestaCorrecta(this.vista.jTextFieldRtaD.getText());
    }

}
