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
        this.esNueva = esNueva;
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
