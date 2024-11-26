package controlador;
import ventanas.*;
import Modelos
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class controladorABMPreguntas implements ActionListener, MouseListener {
    private ABMPreguntas vista;
    private PreguntaAproximacion modeloPreguntaAproximacion;
    private MultipleChoicePregunta modeloPreguntaMultiple;

    public controladorABMPreguntas(){
        super();
        this.vista = new ABMPreguntas(this);
        vista.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tipoPregunta;
        String tematicaPregunta
        if (e.getSource().equals(getVista().getjButtonAgregarPregunta())){
            String nuevaPregunta = getVista().getjjTextFieldNuevaPregunta().getText();
            //if ()
            //System.out.println("Pregunta subida a BD"); //PRUEBA
        }
        if(e.getSource().equals(getVista().getjButtonEliminarPregunta())){
            //Codigo para eliminar pregunta a BD?
            System.out.println("Elimina pregunta a BD");
        }
        if(e.getSource().equals(getVista().getjButtonModificarPregunta())){
            //Codigo para modificar pregunta a BD?
            System.out.println("Modifica pregunta a BD");
        }
        if(e.getSource().equals(getVista().getjButtonBack())){
            New ControladorModoAdmin();
            System.out.println("Vuelve a Modo ADMIN");
            getVista().dispose();
        }
        if(e.getSource().equals(getVista().getjButtonExit())){
            New ControladorMenuPrincipal();
            System.out.println("Vuelve a Menu Principal");
            getVista().dispose();
        }
        if(e.getSource().equals(getVista().getjComboBoxTipo())){
            tipoPregunta = (String) getVista().getjComboBoxTipo().getSelectedItem(); //Se guarda tipo pregunta para luego en agregar pregunta decida la clase a instanciar
        }
        if(e.getSource().equals(getVista().getjComboBoxTematica())){
            tematicaPregunta = (String) getVista().getjComboBoxTipo().getSelectedItem();
        }
    }

    public ABMPreguntas getVista() {
        return vista;
    }

    
}
