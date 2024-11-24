import Vista.MenuPrincipal;

public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(() -> {
try {
MenuPrincipal frame = new MenuPrincipal();
frame.setVisible(true);
} catch (Exception e) {
}
    });
}