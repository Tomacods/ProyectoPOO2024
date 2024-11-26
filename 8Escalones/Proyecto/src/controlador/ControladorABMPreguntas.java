package controlador;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import Modelos.MultipleChoicePregunta;
import Modelos.PreguntaAproximacion;
import Modelos.Tematica;
import Vista.ABMPreguntas;


public class ControladorABMPreguntas {
    private ABMPreguntas vista;

    public ControladorABMPreguntas() {
        this.vista = new ABMPreguntas();
        vista.setVisible(true);
        traerTematicasCB();
        listeners();
    }

    

    private void traerTematicasCB() {
        ArrayList<Tematica> tematicas = Tematica.obtenerTematicas();
        for (Tematica tematica : tematicas) {
            vista.getjComboBoxTematica().addItem(tematica.getNombre());
            // traerPreguntasMC(tematica.getId());
        }
    }

    private void listeners() {

        vista.getjButtonBack().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            vista.dispose();
            new ControladorModoAdmin();
            }
        });
        vista.listenerTematica(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tematicaSeleccionada = (String) vista.getjComboBoxTematica().getSelectedItem();
                if (tematicaSeleccionada != null) {
                    int idTematica = obtenerIdPorNombre(tematicaSeleccionada);
                    actualizarPreguntas(idTematica);
                }
            }
        });

        vista.listenerTipo(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tematicaSeleccionada = (String) vista.getjComboBoxTematica().getSelectedItem();
                if (tematicaSeleccionada != null) {
                    int idTematica = obtenerIdPorNombre(tematicaSeleccionada);
                    actualizarPreguntas(idTematica);
                }
            }
        });

        vista.listenerActualizar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modificarPregunta();
                } catch (SQLException e1) {

                    e1.printStackTrace();
                }
            }
        });
        vista.listenerEliminar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    eliminarPregunta();
                } catch (SQLException e1) {

                    e1.printStackTrace();
                }
            }
        });
        vista.listenerInsertar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    insertarPregunta();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

    public static int obtenerIdPorNombre(String nombre) {
        for (Tematica tematica : Tematica.obtenerTematicas()) {
            if (tematica.getNombre().equals(nombre)) {
                return tematica.getId();
            }
        }
        throw new IllegalArgumentException("Temática no encontrada: " + nombre);

    }

    private void actualizarPreguntas(int idTematica) {
        String tipoSeleccionado = (String) vista.getjComboBoxTipo().getSelectedItem();
        if (tipoSeleccionado != null) {
            vista.getjComboBoxPregunta().removeAllItems();
            EstrategiaPregunta estrategia = null;
            if (tipoSeleccionado.equals("Multiple choice")) {
                estrategia = new EstrategiaPreguntaMC(vista);
            } else if (tipoSeleccionado.equals("Aproximacion")) {
                estrategia = new EstrategiaPreguntaAprox(vista);
            }
            if (estrategia != null) {
                try {
                    estrategia.traerPreguntas(idTematica);
                } catch (SQLException ex) {
                    System.err.println("Error al obtener preguntas: " + ex.getMessage());
                }
            }
        }
    }

    private void traerPreguntasMC(int id_tem) {
        vista.getjComboBoxPregunta().removeAllItems();
        ArrayList<MultipleChoicePregunta> preguntas = MultipleChoicePregunta.obtenerPreguntasMC(id_tem);
        for (MultipleChoicePregunta pregunta : preguntas) {
            vista.getjComboBoxPregunta().addItem(pregunta.getEnunciado());
        }
    }

    private void traerPreguntasAprox(int id_tem) throws SQLException {
        vista.getjComboBoxPregunta().removeAllItems();
        ArrayList<PreguntaAproximacion> preguntas = PreguntaAproximacion.obtenerPreguntasAproximacionTematica(id_tem);
        for (PreguntaAproximacion pregunta : preguntas) {
            vista.getjComboBoxPregunta().addItem(pregunta.getEnunciado());
        }

    }

    private void insertarPregunta() throws SQLException {
        String tipoSeleccionado = (String) vista.getjComboBoxTipo().getSelectedItem();
        if (tipoSeleccionado.equals("Multiple choice")) {
            String tematicaSeleccionada = (String) vista.getjComboBoxTematica().getSelectedItem();
            if (tematicaSeleccionada != null) {

                int idTematica = obtenerIdPorNombre(tematicaSeleccionada);

                MultipleChoicePregunta preguntaIns = new MultipleChoicePregunta(0, "", idTematica);
                this.vista.dispose();
                ControladorABMRespuestaMC controladorMC = new ControladorABMRespuestaMC(preguntaIns, true);
            } else {
                System.out.println("El campo de la nueva pregunta o la temática está vacío.");
            }
        } else if (tipoSeleccionado.equals("Aproximacion")) {
            String tematicaSeleccionada = (String) vista.getjComboBoxTematica().getSelectedItem();
            if (tematicaSeleccionada != null) {

                int idTematica = obtenerIdPorNombre(tematicaSeleccionada);

                PreguntaAproximacion preguntaIns = new PreguntaAproximacion(0, "", idTematica, 0);//ver como hacer con el valor aproximado
                this.vista.dispose();
                ControladorABMRespuestaAprox controladorAprox = new ControladorABMRespuestaAprox(preguntaIns, true)

            } else {
                System.out.println("El campo de la nueva pregunta o la temática está vacío.");
            }
        }
    }

    private void eliminarPregunta() throws SQLException {
        String tipoSeleccionado = (String) vista.getjComboBoxTipo().getSelectedItem();

        if (tipoSeleccionado.equals("Multiple choice")) {
            String selectedPregunta = (String) vista.getjComboBoxPregunta().getSelectedItem();
            if (selectedPregunta != null) {
                int idTematica = obtenerIdPorNombre((String) vista.getjComboBoxTematica().getSelectedItem());
                MultipleChoicePregunta pregunta = MultipleChoicePregunta.obtenerPreguntaPorEnunciado(selectedPregunta,
                        idTematica);
                if (pregunta != null) {
                    int idPregunta = pregunta.getIdPregunta();
                    System.out.println(
                            "Pregunta seleccionada para eliminar: " + selectedPregunta + ", ID: " + idPregunta);
                    MultipleChoicePregunta.eliminarPregunta(idPregunta); // Llamada a eliminar pregunta
                    traerPreguntasMC(idTematica); // Refrescar la lista de preguntas
                    System.out.println("Pregunta eliminada: " + selectedPregunta);
                } else {
                    System.out.println("No se encontró la pregunta con el enunciado seleccionado.");
                }
            }

        } else if (tipoSeleccionado.equals("Aproximacion")) {
            String selectedPregunta = (String) vista.getjComboBoxPregunta().getSelectedItem();
            int idTematica = obtenerIdPorNombre((String) vista.getjComboBoxTematica().getSelectedItem());
            PreguntaAproximacion pregunta = PreguntaAproximacion.obtenerPreguntaPorEnunciado(selectedPregunta,
                    idTematica);
            if (pregunta != null) {
                int idPregunta = pregunta.getIdPregunta();
                System.out.println("Pregunta seleccionada para eliminar: " + selectedPregunta + ", ID: " + idPregunta);
                PreguntaAproximacion.eliminarPreguntaAprox(idPregunta); 
                System.out.println("Pregunta eliminada: " + selectedPregunta);
                traerPreguntasAprox(idTematica);  
            } else {
                System.out.println("No se encontró la pregunta con el enunciado seleccionado.");
            }
        }
    }

    private void modificarPregunta() throws SQLException {
        String tipoSeleccionado = (String) vista.getjComboBoxTipo().getSelectedItem();
        if (tipoSeleccionado.equals("Multiple choice")) {

            String selectedPregunta = (String) vista.getjComboBoxPregunta().getSelectedItem();
            if (selectedPregunta == null) {
                System.out.println("No se ha seleccionado ninguna temática.");
                return;
            }
            MultipleChoicePregunta pregunta = MultipleChoicePregunta.obtenerPreguntaPorEnunciado(selectedPregunta, 1);
            if (pregunta == null) {
                System.out.println("No se encontró la temática seleccionada.");
                return;
            }
            String nuevaPregunta = vista.getjTextFieldNuevaPregunta().getText();
            if (nuevaPregunta.isEmpty()) {
                System.out.println("El campo de la nueva temática está vacío.");
                return;
            }
            pregunta.setEnunciado(nuevaPregunta);
            MultipleChoicePregunta.actualizarPregunta(pregunta);
            traerTematicasCB();
            System.out.println("pregunta modificada exitosamente.");

        } else if (tipoSeleccionado.equals("Aproximacion")) {
            String selectedPregunta = (String) vista.getjComboBoxPregunta().getSelectedItem();
            if (selectedPregunta == null) {
                System.out.println("No se ha seleccionado ninguna temática.");
                return;
            }
            PreguntaAproximacion pregunta = PreguntaAproximacion.obtenerPreguntaPorEnunciado(selectedPregunta, 1);
            if (pregunta == null) {
                System.out.println("No se encontró la temática seleccionada.");
                return;
            }
            String nuevaPregunta = vista.getjTextFieldNuevaPregunta().getText();
            if (nuevaPregunta.isEmpty()) {
                System.out.println("El campo de la nueva temática está vacío.");
                return;
            }
            pregunta.setEnunciado(nuevaPregunta);
            PreguntaAproximacion.actualizarPreguntaAprox(pregunta);
            traerTematicasCB();
            System.out.println("pregunta modificada exitosamente.");

        }
    }


}