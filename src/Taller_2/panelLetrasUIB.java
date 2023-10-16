package Taller_2;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Representa un panel que muestra las letras de la UIB.
 * Extiende JPanel.
 * 
 * @author Pau Toni Bibiloni Martínez
 */
public class panelLetrasUIB extends JPanel {
    
    /**
     * Constructor de la clase panelLetrasUIB.
     * Configura el diseño del panel como BorderLayout.
     */
    public panelLetrasUIB() {
        setLayout(new BorderLayout()); // Configura el diseño del panel como BorderLayout
        initComponents();
    }
    
    /**
     * Inicializa los componentes del panel.
     * Crea una etiqueta con el texto "TALLER 2 - PROGRAMACIÓN II - CURSO 2022-23",
     * la centra horizontalmente y la agrega al panel.
     */
    public void initComponents() {
        setBackground(Color.BLACK); // Establece el color de fondo del panel como negro
        
        JLabel etiqueta = new JLabel("TALLER 2 - PROGRAMACIÓN II - CURSO 2022-23");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto horizontalmente en el JLabel
        etiqueta.setFont(new java.awt.Font("Dialog", 1, 26));
        etiqueta.setForeground(Color.GRAY);
        add(etiqueta); // Agrega el JLabel al panel
    }  
}
