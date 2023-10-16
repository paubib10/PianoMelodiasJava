package Taller_2;

import javax.swing.JFrame;

/**
 * Clase principal que representa el programa del Taller 2.
 * Extiende JFrame.
 * 
 * @author Pau Toni Bibiloni Martínez
 */
public class Taller_2 extends JFrame {

    public static panelContenidos panel = new panelContenidos();
    public static String[] notas;
    
    /**
     * Método principal que inicia el programa.
     * Crea una instancia de la clase Taller_2 y la hace visible.
     * 
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        new Taller_2().setVisible(true);
    }
    
    /**
     * Constructor de la clase Taller_2.
     * Configura la ventana principal de la aplicación.
     */
    public Taller_2() {
        setTitle("TALLER 2 - PROGRAMACIÓN II - CURSO 2022-2023");
        setResizable(false);
        setSize(725, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setContentPane(panel);
    }
}
