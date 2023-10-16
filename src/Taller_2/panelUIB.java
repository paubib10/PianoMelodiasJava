package Taller_2;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Representa un panel que muestra la imagen de la UIB.
 * Extiende JPanel.
 * 
 * @author Pau Toni Bibiloni Martínez
 */
public class panelUIB extends JPanel {

    /**
     * Constructor de la clase panelUIB. 
     * Configura el diseño del panel como BorderLayout.
     */
    public panelUIB() {
        setLayout(new BorderLayout());
        initComponents();
    }
    
    /**
     * Inicializa los componentes del panel.
     * Crea un JLabel con una imagen de la UIB escalada y lo agrega al panel.
     */
    public void initComponents() {
        JLabel uibPic = new JLabel();
        // Carga la imagen desde el archivo
        Image img = new ImageIcon(getClass().getResource("/pics/uibpic.jpg")).getImage();

        // Escala la imagen para ajustarla al tamaño que queremos
        Image newimg = img.getScaledInstance(725, 550, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newimg);

        uibPic.setIcon(imageIcon); // Crea un ImageIcon con la imagen escalada

        add(uibPic); // Agrega el JLabel al panel
    }
}
