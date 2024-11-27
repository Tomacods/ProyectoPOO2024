package Modelos;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioLoop {

    private Clip musica;
    private Thread audioThread;

    public void reproducir(String ruta) {
        // Crear y arrancar un hilo para reproducir el audio
        audioThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Nombre o ruta del archivo de sonido
                    String soundName = ruta; 
                    System.out.println("Ruta de audio: " + soundName);
                    AudioInputStream audioFondo = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());

                    // Crear un clip de audio
                    musica = AudioSystem.getClip();

                    // Abrir el clip con el archivo de audio
                    musica.open(audioFondo);

                    // Reproducir en loop indefinidamente
                    musica.loop(Clip.LOOP_CONTINUOUSLY);

                    // Esperar hasta que el audio se termine (esto puede ser ajustado según sea necesario)
                    while (musica.isRunning()) {
                        Thread.sleep(1000);  // Espera de 1 segundo para evitar usar demasiados recursos
                    }

                    // Detener el clip después de un tiempo si es necesario
                    //musica.stop();
                    //musica.close();

                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Iniciar el hilo de reproducción de audio
        audioThread.start();

        // El hilo principal puede continuar con otras tareas mientras se reproduce el audio en segundo plano
        System.out.println("El audio se está reproduciendo en loop. El hilo principal sigue ejecutándose.");
        
    }

    public void detener() {
        if (musica != null && musica.isRunning()) {
            musica.stop();  // Detener la reproducción del audio
            musica.close(); // Cerrar el clip de audio
            System.out.println("El audio ha sido detenido.");
        } else {
            System.out.println("No se está reproduciendo ningún audio.");
        }

        if (audioThread != null && audioThread.isAlive()) {
            audioThread.interrupt();  // Interrumpir el hilo de audio si es necesario
        }
    }

    public static void reproducirSonido(String ruta) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        String sonido = ruta;
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sonido).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
    }
}
