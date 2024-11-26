package controlador;

import Modelos.PreguntaAproximacion;
import Vista.ABMRespuestaAprox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ControladorABMRespuestaAprox {
    private ABMRespuestaAprox vista;
    private PreguntaAproximacion preguntaActual;
    private boolean esNueva;
    
    public ControladorABMRespuestaAprox(PreguntaAproximacion pregunta, boolean esNueva) {
        this.vista = new ABMRespuestaAprox();
        this.preguntaActual = pregunta;
        iniciarVista();
    }

    private void iniciarVista() {
        this.vista.jTextFieldPreguntaAprox.setText(this.preguntaActual.getEnunciado());
        this.vista.jTextFieldRespuesta.setText(String.valueOf(this.preguntaActual.getValorAproximado()));

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

        this.vista.jTextFieldEditarRespuesta.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                preguntaActual.setValorAproximado(Integer.parseInt(vista.jTextFieldEditarRespuesta.getText()));
                }
                catch(NumberFormatException e){
                    System.out.println("Este valor no es valido");
                }
            }
        });

        this.vista.jTextFieldEditarPregunta.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                preguntaActual.setEnunciado(vista.jTextFieldEditarPregunta.getText());
            }
        });
    }

    private void volver() throws SQLException {
        if (esNueva == false) {
            PreguntaAproximacion.actualizarPreguntaAprox(this.preguntaActual);
        }
        else {
            PreguntaAproximacion.insertarPreguntaAproximacion(this.preguntaActual);
        }
        this.vista.dispose();
        ControladorABMPreguntas controladorPreguntas = new ControladorABMPreguntas();
    }

}
