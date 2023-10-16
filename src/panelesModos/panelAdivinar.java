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
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import Taller_2.Taller_2;

/**
 * Representa un panel utilizado para adivinar notas musicales.
 * Extiende JPanel.
 * 
 * @author Pau Toni Bibiloni Martínez
 */
public class panelAdivinar extends JPanel {

    private JButton notasDibujadas[] = new JButton[110];
    private int indice = 0;
    private String[] notas;
    
    /**
     * Constructor de la clase panelAdivinar.
     * Recibe un arreglo de notas como parámetro.
     * Configura el diseño del panel como GridLayout y llama al método initComponents().
     * 
     * @param notas El arreglo de notas utilizado para adivinar la melodía.
     */
    public panelAdivinar(String[] notas) {
        this.notas = notas;
        setLayout(new GridLayout(10, 11));
        initComponents();
    }
    
    /**
     * Inicializa los componentes del panel.
     * Establece el color de fondo del panel como negro.
     * Crea y configura los botones para representar las notas.
     * Agrega los botones al panel.
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
     * Agrega una nota adivinada al panel.
     * Verifica si la nota introducida coincide con la secuencia de notas de la melodía.
     * Actualiza el color del botón correspondiente a la nota adivinada.
     * Reproduce el sonido asociado a la nota.
     * Incrementa el índice de la melodía.
     * Si se adivinan todas las notas, muestra un mensaje de éxito.
     * 
     * @param nota La nota adivinada.
     */
    public void addNotaAdivinar(String nota) {
        if (indice >= 110) {
            Taller_2.panel.cambiarDefault();
            return;
        } 
        // Verificar si la nota introducida coincide con la secuencia de notas de la melodía
        if (notas[indice] != null && notas[indice].equals(nota)) {
            notasDibujadas[indice].setBackground(obtenerColorNota(nota));
            reproduccionSonido(nota.toLowerCase() + ".wav");
            indice++;
        } else {
            reproduccionSonido("error.wav");
        }
        
        if (notas[indice] == null) {
            reproduccionSonido("campeones.wav");
            JOptionPane.showMessageDialog(null, "¡Has adivinado todas las notas!");
        }
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
