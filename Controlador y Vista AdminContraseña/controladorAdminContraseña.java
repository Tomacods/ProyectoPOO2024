package controlador;
import ventanas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class controladorAdminContraseña implements ActionListener, MouseListener {
    private AdminContraseña vista;
    private String contrasenia = "admin";

    public controladorAdminContraseña(AdminContraseña vista, String contrasenia) {
        super();
        this.vista = new AdminContraseña(this);
        vista.setVisible(true);
        this.contrasenia = contrasenia;
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
        if (e.getSource().equals(getVista().getjIngresar())){
            char[] contraseniaIngresada = vista.getjPasswordField1().getPassword();
            char[] contraseniaValida = this.contrasenia.toCharArray();
            Boolean validarContrasenias = java.util.Arrays.equals(contraseniaIngresada, contraseniaValida);
            if (validarContrasenias) {
                System.out.println("Ingreso sin problemas!");
                new controladorModoAdmin();
                getVista().dispose();
            } else {
                System.out.println("Contraseñia erronea, vuelva a intentarlo");
                java.util.Arrays.fill(contraseniaIngresada, '\0'); //Limpia el texto ingresado
            }
        }
        if(e.getSource().equals(getVista().getjButtonBack())){
            //New ControladorMenuPrincipal();
            System.out.println("Abre ventana MENU PRINCIPAL");
            getVista().dispose();
        }
    }

    public AdminContraseña getVista() {
        return vista;
    }

    public void setVista(AdminContraseña vista) {
        this.vista = vista;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
}
