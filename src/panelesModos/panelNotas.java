package panelesModos;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import Taller_2.Taller_2;


/**
 * Representa un panel que muestra las notas dibujadas.
 * Extiende JPanel.
 * 
 * @author Pau Toni Bibiloni Martínez
 */
public class panelNotas extends JPanel {

    private JButton notasDibujadas[] = new JButton[110];
    private int indice = 0;
    
    /**
     * Constructor de la clase panelNotas.
     * Configura el diseño del panel como una cuadrícula de 10 filas y 11 columnas.
     */
    public panelNotas() {
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
     * Agrega una nota al panel.
     * @param nota La nota a añadir.
     */
    public void addNota(String nota) {
        if (indice >= 110) {
            Taller_2.panel.cambiarDefault();
            return;
        }
        notasDibujadas[indice].setBackground(obtenerColorNota(nota));
        indice++;
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
