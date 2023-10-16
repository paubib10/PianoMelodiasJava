package panelesModos;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import Taller_2.Taller_2;

/**
 * Clase que representa el panel para reproducir las notas musicales. Muestra
 * los botones de las notas y reproduce los sonidos asociados a cada nota. Los
 * botones de notas se dibujan en negro y cambian de color al reproducirse.
 *
 * @author Pau Toni Bibiloni Martínez
 */
public class reproducirNotas extends JPanel {

    private JButton notasDibujadas[] = new JButton[110]; // Array de JButton para representar las notas
    private int indice = 0;
    private String[] notas; // Array de notas
    
    /**
     * Constructor de la clase reproducirNotas.
     * Crea el panel y configura el diseño.
     * 
     * @param notas El array de notas musicales.
     */
    public reproducirNotas(String[] notas) {
        this.notas = notas;
        // Configura el diseño del panel como una cuadrícula de 10x11
        setLayout(new GridLayout(10, 11));
        initComponents();
    }
    
    /**
     * Inicializa los componentes del panel.
     * Crea los botones para representar las notas y los agrega al panel.
     */
    public void initComponents() {
        // Establece el color de fondo del panel como negro
        setBackground(Color.black);

        for (int i = 0; i < 110; i++) {
            notasDibujadas[i] = new JButton();
            // Establece un borde de color negro de grosor 8
            notasDibujadas[i].setBorder(BorderFactory.createLineBorder(Color.black, 8));
            notasDibujadas[i].setBackground(Color.black);
            // Deshabilita los botones para que no sean clickeables
            notasDibujadas[i].setEnabled(false);

            // Agregar los botones al panel
            add(notasDibujadas[i]);
        }
    }

    /**
     * Reproduce la siguiente nota musical y cambia el color del botón
     * correspondiente. Si no hay más notas, cambia al panel de letras de la
     * UIB.
     */
    public void playNota() {
        if (indice >= 110) {
            return;
        }
        if (notas[indice] != null) {
            String nota = notas[indice];
            // Establece el color de fondo del botón correspondiente a la nota
            notasDibujadas[indice].setBackground(obtenerColorNota(nota));
            // Reproduce el sonido asociado a la nota
            reproduccionSonido(nota.toLowerCase() + ".wav");
        } else {
            // Si no hay más notas, se cambia al panel de letras de la uib
            Taller_2.panel.cambiarPanelLetras();
        }
        indice++; // Incremento del índice
    }

    /**
     * Reproduce un sonido asociado a una nota musical.
     * 
     * @param sonido El nombre del archivo de sonido a reproducir.
     */
    private void reproduccionSonido(String sonido) {
        try {
            // Creamos el objeto AudioInputStream
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sonidos/" + sonido).getAbsoluteFile());
            // Creamos el objeto Clip
            Clip clip = AudioSystem.getClip();
            // Abrimos el archivo de audio con el método open
            clip.open(audioInputStream);
            // Comenzamos a reproducir el sonido
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("El formato del archivo de audio no está soportado: " + ex.getMessage());
        } catch (LineUnavailableException ex) {
            System.out.println("La línea de audio no está disponible: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error de lectura/escritura: " + ex.getMessage());
        }
    }

    /**
     * Obtiene el color asociado a una nota.
     * 
     * @param nota La nota para la cual obtener el color.
     * @return El color asociado a la nota.
     */
    private Color obtenerColorNota(String nota) {
        switch (nota) {
            case "DO":
                return Color.red;
            case "RE":
                return Color.pink;
            case "MI":
                return Color.cyan;
            case "FA":
                return Color.yellow;
            case "SOL":
                return Color.magenta;
            case "LA":
                return Color.white;
            case "SI":
                return Color.green;
            default:
                return Color.black;
        }
    }
}
