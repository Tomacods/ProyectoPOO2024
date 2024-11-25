package controlador;
import Vista.OpcionesGenerales;
import Vista.AdminContraseña;
import Vista.ModoAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorAdminContraseña implements ActionListener{
    private AdminContraseña vista;
    private String contrasenia = "admin";

    public ControladorAdminContraseña(String contrasenia) {
        this.vista = new AdminContraseña();
        vista.setVisible(true);
        this.contrasenia = contrasenia;
        this.vista.getjIngresar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getVista().getjIngresar())){
            char[] contraseniaIngresada = vista.getjPasswordField1().getPassword();
            char[] contraseniaValida = this.contrasenia.toCharArray();
            Boolean validarContrasenias = java.util.Arrays.equals(contraseniaIngresada, contraseniaValida);
            if (validarContrasenias) {
                System.out.println("Ingreso sin problemas!");
                new ControladorModoAdmin();
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
