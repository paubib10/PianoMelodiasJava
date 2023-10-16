package Taller_2;

import panelesModos.panelAdivinar;
import panelesModos.panelBotonesAdivinar;
import panelesModos.panelNotas;
import panelesModos.panelPiano;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import static javax.swing.JSplitPane.VERTICAL_SPLIT;
import panelesModos.panelBotonReproducir;
import panelesModos.reproducirNotas;

/**
 * Representa un panel que contiene los distintos componentes y actividades del programa.
 * Extiende JPanel.
 * 
 * @author Pau Toni Bibiloni Martínez
 */
public class panelContenidos extends JPanel {

    private static JSplitPane separador1, separador2;
    
    /**
     * Constructor de la clase panelContenidos.
     * Configura el diseño del panel como BorderLayout y llama al método initComponents().
     */
    public panelContenidos() {
        setLayout(new BorderLayout());
        initComponents();
    }
    
    /**
     * Inicializa los componentes del panel.
     * Crea y configura los paneles separadores (JSplitPane) y los agrega al panel principal.
     */
    private void initComponents() {
        separador1 = new JSplitPane(VERTICAL_SPLIT, new panelUIB(), new panelLetrasUIB());
        separador1.setEnabled(false);
        separador1.setDividerLocation(550);

        separador2 = new JSplitPane(VERTICAL_SPLIT, separador1, new panelPrincipalBotones());
        separador2.setEnabled(false);
        separador2.setDividerLocation(625);

        add(separador2);
    }
    
    /**
     * Cambia a la vista predeterminada.
     * Restablece los paneles separadores y las ubicaciones de los divisores a sus valores iniciales.
     */
    public void cambiarDefault() {
        separador1.setLeftComponent(new panelUIB());
        separador1.setEnabled(false);
        separador1.setDividerLocation(550);
        separador1.setRightComponent(new panelLetrasUIB());

        separador2.setDividerLocation(625);
    }
    
    /**
     * Cambia al panel de letras de la UIB.
     * Actualiza el panel derecho del primer separador con el panel de letras de la UIB.
     * Ajusta las ubicaciones de los divisores.
     */
    public void cambiarPanelLetras() {
        separador1.setEnabled(false);
        separador1.setDividerLocation(550);
        separador1.setRightComponent(new panelLetrasUIB());

        separador2.setDividerLocation(625);
    }
    
    /**
     * Cambia a la actividad de creación de notas.
     * Actualiza el panel izquierdo del primer separador con el panel de notas.
     * Actualiza el panel derecho del primer separador con el panel de piano.
     * Ajusta las ubicaciones de los divisores.
     */
    public void cambiarActividadNotas() {
        panelNotas tablero = new panelNotas();

        separador1.setLeftComponent(tablero);
        separador1.setEnabled(false);
        separador1.setDividerLocation(550);
        separador1.setRightComponent(new panelPiano(tablero));

        separador2.setDividerLocation(625);
    }
    
    /**
     * Cambia a la actividad de reproducción de notas.
     * Actualiza el panel izquierdo del primer separador con el panel de reproducción de notas.
     * Actualiza el panel derecho del primer separador con el panel de botón de reproducción.
     * Ajusta las ubicaciones de los divisores.
     */
    public void cambiarActividadReproducir() {
        reproducirNotas reproducirNotas = new reproducirNotas(Taller_2.notas);
        separador1.setLeftComponent(reproducirNotas);
        separador1.setDividerLocation(550);
        separador1.setRightComponent(new panelBotonReproducir(reproducirNotas));
        separador2.setDividerLocation(625);
    }
    
    /**
     * Cambia a la actividad de adivinar notas.
     * Actualiza el panel izquierdo del primer separador con el panel de adivinar notas.
     * Actualiza el panel derecho del primer separador con el panel de botones de adivinar.
     * Ajusta las ubicaciones de los divisores.
     */
    public void cambiarActividadAdivinar() {
        panelAdivinar tablero2 = new panelAdivinar(Taller_2.notas);

        separador1.setLeftComponent(tablero2);
        separador1.setEnabled(false);
        separador1.setDividerLocation(550);
        separador1.setRightComponent(new panelBotonesAdivinar(tablero2));

        separador2.setDividerLocation(625);
    }
}
