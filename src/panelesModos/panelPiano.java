package panelesModos;

import panelesModos.panelNotas;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JPanel;
import Taller_2.Taller_2;

/**
 * Representa un panel de piano que permite agregar notas musicales y reproducir su sonido.
 * Extiende JPanel y implementa ActionListener.
 * 
 * @author Pau Toni Bibiloni Martínez
 */
public class panelPiano extends JPanel implements ActionListener {

    private String[] botonesNotas = {"DO", "RE", "MI", "FA", "SOL", "LA", "SI"};
    private Color[] colores = {Color.red, Color.pink, Color.cyan, Color.yellow, Color.magenta, Color.white, Color.green};
    private panelNotas nota;
    private String[] notas = new String[110];
    private int indice = 0;
    
    /**
     * Constructor de la clase panelPiano.
     * Recibe un objeto panelNotas como parámetro.
     * Configura el diseño del panel como una cuadrícula de 1 fila y 8 columnas y llama al método initComponents().
     * @param nota Objeto panelNotas utilizado para agregar las notas musicales.
     */
    public panelPiano(panelNotas nota) {
        this.nota = nota;

        setLayout(new GridLayout(1, 8));
        initComponents();
    }
    
     /**
     * Inicializa los componentes del panel.
     * Crea y configura los botones de notas musicales y el botón "FIN", y los agrega al panel.
     * Asigna el mismo ActionListener a todos los botones para manejar los eventos de acción.
     */
    public void initComponents() {
        for (int i = 0; i < botonesNotas.length; i++) {
            JButton botonNota = new JButton(botonesNotas[i]);
            botonNota.setBackground(colores[i]);
            botonNota.setForeground(Color.black);
            botonNota.setFont(new java.awt.Font("Dialog", 1, 26));
            add(botonNota);
            botonNota.addActionListener(this);
        }
        JButton botonFIN = new JButton("FIN");
        botonFIN.setBackground(Color.black);
        botonFIN.setForeground(Color.white);
        botonFIN.setFont(new java.awt.Font("Dialog", 1, 26));
        botonFIN.addActionListener(this);
        add(botonFIN);
    }
    
     /**
     * Maneja los eventos de acción de los botones.
     * Agrega la nota musical al objeto panelNotas, reproduce su sonido y guarda la nota en el array de notas.
     * @param evento Objeto ActionEvent que representa el evento de acción.
     */
    public void actionPerformed(ActionEvent evento) {

        switch (evento.getActionCommand()) {
            // Si se presiona una nota musical
            case "DO", "RE", "MI", "FA", "SOL", "LA", "SI" -> {
                if (indice >= 110) {
                    Taller_2.panel.cambiarDefault();
                    Taller_2.notas = notas;
                    return;
                }
                nota.addNota(evento.getActionCommand());
                reproduccionSonido(evento.getActionCommand().toLowerCase() + ".wav");
                notas[indice] = evento.getActionCommand();
                indice++;
            }
            // Si se presiona el botón "FIN"
            case "FIN" -> {
                Taller_2.panel.cambiarDefault();
                Taller_2.notas = notas;
            }

        }
    }
    
    /**
     * Reproduce el sonido de una nota musical.
     * @param sonido Nombre del archivo de sonido de la nota.
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
}
