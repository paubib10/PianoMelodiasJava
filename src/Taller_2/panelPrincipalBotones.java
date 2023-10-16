package Taller_2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Representa un panel que contiene los botones principales del programa.
 * Extiende JPanel y implementa ActionListener.
 *
 * @author Pau Toni Bibiloni Martínez
 */
public class panelPrincipalBotones extends JPanel implements ActionListener {

    private final String[] botonesInicio = {"CREAR", "REPRODUCIR", "ADIVINAR", "SALIR"};

    private boolean crearSeleccionado = false;

    /**
     * Constructor de la clase panelPrincipalBotones. Configura el diseño del
     * panel como una cuadrícula de 1 fila y 4 columnas y llama al método
     * initComponents().
     */
    public panelPrincipalBotones() {
        setLayout(new GridLayout(1, 4));
        initComponents();
    }

    /**
     * Inicializa los componentes del panel. Crea y configura los botones
     * principales y los agrega al panel.
     */
    public void initComponents() {

        for (int i = 0; i < botonesInicio.length; i++) {
            JButton botonMain = new JButton(botonesInicio[i]);
            botonMain.setBackground(Color.black);
            botonMain.setFont(new java.awt.Font("Dialog", 1, 12));
            botonMain.setForeground(Color.white);
            botonMain.addActionListener(this);
            add(botonMain);
        }
    }

    /**
     * Maneja los eventos de acción de los botones. Realiza diferentes acciones
     * dependiendo del botón presionado.
     *
     * @param evento Objeto ActionEvent que representa el evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        switch (evento.getActionCommand()) {

            case "CREAR" -> {
                // Llama al método cambiarActividadNotas() en Taller_2.panel
                Taller_2.panel.cambiarActividadNotas();

                crearSeleccionado = true;
            }
            case "REPRODUCIR" -> {
                if (crearSeleccionado) {
                    // Llama al método cambiarActividadReproducir() en Taller_2.panel
                    Taller_2.panel.cambiarActividadReproducir();
                } else {
                    JOptionPane.showMessageDialog(null, "Primero debes crear la melodia");
                }
            }
            case "ADIVINAR" -> {
                if (crearSeleccionado) {
                    // Llama al método cambiarActividadAdivinar() en Taller_2.panel
                    Taller_2.panel.cambiarActividadAdivinar();
                } else {
                    JOptionPane.showMessageDialog(null, "Primero debes crear la melodia");
                }
            }
            case "SALIR" -> {
                System.exit(0); // Sale del programa
            }
        }
    }
}
