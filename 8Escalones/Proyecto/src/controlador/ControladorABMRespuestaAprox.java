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

    /**
     * @return ABMRespuestaAprox return the vista
     */
    public ABMRespuestaAprox getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(ABMRespuestaAprox vista) {
        this.vista = vista;
    }

    /**
     * @return PreguntaAproximacion return the preguntaActual
     */
    public PreguntaAproximacion getPreguntaActual() {
        return preguntaActual;
    }

    /**
     * @param preguntaActual the preguntaActual to set
     */
    public void setPreguntaActual(PreguntaAproximacion preguntaActual) {
        this.preguntaActual = preguntaActual;
    }

    /**
     * @return boolean return the esNueva
     */
    public boolean isEsNueva() {
        return esNueva;
    }

    /**
     * @param esNueva the esNueva to set
     */
    public void setEsNueva(boolean esNueva) {
        this.esNueva = esNueva;
    }

}
