package panelesModos;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Representa un panel que contiene un botón para reproducir notas musicales.
 * Extiende JPanel e implementa ActionListener.
 * 
 * @author Pau Toni Bibiloni Martínez
 */
public class panelBotonReproducir extends JPanel implements ActionListener {

    private reproducirNotas repronot;
    
    /**
     * Constructor de la clase panelBotonReproducir.
     * Recibe un objeto reproducirNotas como parámetro.
     * Configura el diseño del panel como GridLayout y llama al método initComponents().
     * 
     * @param repronot El objeto reproducirNotas asociado al botón de reproducir notas.
     */
    public panelBotonReproducir(reproducirNotas repronot) {
        this.repronot = repronot;
        setLayout(new GridLayout(1, 1));
        initComponents();

    }
    
    /**
     * Inicializa los componentes del panel.
     * Crea y configura el botón de reproducir notas.
     * Agrega el botón al panel y registra el ActionListener.
     */
    public void initComponents() {
        JButton botonREPRO = new JButton(">");
        botonREPRO.setFont(new java.awt.Font("Dialog", 1, 26));
        add(botonREPRO);
        botonREPRO.addActionListener(this);
    }
    
    /**
     * Maneja el evento de acción generado por el botón de reproducir notas.
     * Llama al método playNota() del objeto reproducirNotas asociado.
     * 
     * @param evento El evento de acción generado.
     */
    public void actionPerformed(ActionEvent evento) {
        repronot.playNota();
    }
}
