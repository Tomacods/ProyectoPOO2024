package controlador;

import Modelos.MultipleChoicePregunta;
import Modelos.Respuesta;
import Vista.ABMRespuestaMC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

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
        this.vista.jTextFieldPreguntaMC.setText(this.pregunta_actual.getEnunciado());
        ArrayList<Respuesta> respuestas = Respuesta.obtenerRespuestasPorPregunta(this.pregunta_actual.getIdPregunta());
        this.vista.jTextFieldRtaA.setText(respuestas.get(0).getTexto());
        this.vista.jTextFieldRtaB.setText(respuestas.get(1).getTexto());
        this.vista.jTextFieldRtaC.setText(respuestas.get(2).getTexto());
        this.vista.jTextFieldRtaD.setText(respuestas.get(3).getTexto());

        respuestas.clear();

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

        this.vista.jTextFieldRtaA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                modificar_respuesta(0, vista.jTextFieldRtaA.getText());
            }
        });

        this.vista.jTextFieldRtaB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                modificar_respuesta(1, vista.jTextFieldRtaB.getText());
            }
        });

        this.vista.jTextFieldRtaC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                modificar_respuesta(2, vista.jTextFieldRtaC.getText());
            }
        });

        this.vista.jTextFieldRtaD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                modificar_respuesta(3, vista.jTextFieldRtaD.getText());
            }
        });

        this.vista.setVisible(true);
    }

    private void volver() throws SQLException {
        cambiar_correcta();
        if (esNueva == false) {
            MultipleChoicePregunta.actualizarPregunta(pregunta_actual);
        } else {
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
