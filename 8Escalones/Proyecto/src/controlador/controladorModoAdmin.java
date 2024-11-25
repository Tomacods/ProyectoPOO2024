package controlador;
import Vista.ModoAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorModoAdmin implements ActionListener, MouseListener {
    private ModoAdmin vistaModoAdmin;

    public ControladorModoAdmin(){
        super();
        this.vistaModoAdmin = new ModoAdmin(this);
        vistaModoAdmin.setVisible(true);
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
        if (e.getSource().equals(getVistaModoAdmin().getjButtonABMPreguntas())){
            //new ControladorABMPreguntas();
            System.out.println("Abre ventana ABM PREGUNTAS"); //PRUEBA
            getVistaModoAdmin().dispose(); //Cierra la ventana de Modo Admin

        }
        if(e.getSource().equals(getVistaModoAdmin().getjButtonABMTematicas())){
            //new ControladorABMTematicas();
            System.out.println("Abre ventana ABM TEMATICA");
            getVistaModoAdmin().dispose();
        }
        if(e.getSource().equals(getVistaModoAdmin().getjButtonABMJugadores())){
            //new ControladorABMJugadores();
            System.out.println("Abre ventana ABM JUGADORES");
            getVistaModoAdmin().dispose();
        }
        if(e.getSource().equals(getVistaModoAdmin().getjButtonBack())){
            //New ControladorMenuPrincipal();
            System.out.println("Abre ventana MENU PRINCIPAL");
            getVistaModoAdmin().dispose();
        }
    }


    public ModoAdmin getVistaModoAdmin() {
        return vistaModoAdmin;
    }
    
}
