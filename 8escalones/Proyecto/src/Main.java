import Vista.MenuPrincipal;

public static void Main(String[] args) {
    java.awt.EventQueue.invokeLater(() -> {
try {
MenuPrincipal frame = new MenuPrincipal();
frame.setVisible(true);
} catch (Exception e) {
}
    });
}