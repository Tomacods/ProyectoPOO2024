package Vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class prueba extends JFrame {
    private JPanel panel;
    private ArrayList<JTextField> camposTexto; // Referencia para los JTextField

    public prueba(ArrayList<String> datos) {
        // Configurar la ventana
        setTitle("Vista Dinámica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Inicializar contenedor para los JTextField
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        camposTexto = new ArrayList<>();

        // Crear campos dinámicamente
        for (String dato : datos) {
            JTextField textField = new JTextField();
            textField.setText(dato); // Inicializar con el dato
            textField.setPreferredSize(new Dimension(200, 30));
            panel.add(textField);
            camposTexto.add(textField); // Guardar referencia
        }

        // Agregar el panel a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);

        // Botón para mostrar valores ingresados
        JButton botonMostrar = new JButton("Mostrar Valores");
        botonMostrar.addActionListener(e -> mostrarValores());
        add(botonMostrar, BorderLayout.SOUTH);
    }

    // Método para obtener valores ingresados en los JTextField
    private void mostrarValores() {
        for (int i = 0; i < camposTexto.size(); i++) {
            System.out.println("Campo " + (i + 1) + ": " + camposTexto.get(i).getText());
        }
    }
}
