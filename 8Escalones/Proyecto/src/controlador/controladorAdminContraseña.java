package controlador;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class controladorAdminContraseña implements ActionListener{
    private AdminContraseña vista;
    private String contrasenia = "admin";

    public controladorAdminContraseña( String contrasenia) {
        super();
        this.vista = new AdminContraseña(this);
        vista.setVisible(true);
        this.contrasenia = contrasenia;
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
