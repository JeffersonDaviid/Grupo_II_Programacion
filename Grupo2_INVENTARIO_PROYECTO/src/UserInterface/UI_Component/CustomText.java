/**
 * @autor: Jefferson Chileno
 * @email: jeffersonchile2001@gmail.com
 * @version: 0.1
 */

package UserInterface.UI_Component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class CustomText extends JTextField implements FocusListener {
    private String hoverGeneral, advertenciaGeneral;

    /**
     * 
     * TextField por defecto, solo valida campos vacios
     */
    public CustomText() {
        setPersonalizacion();
    }

    /**
     * 
     * @param hover Hover de JtextField
     */
    public CustomText(String hover) {
        super(hover);
        hoverGeneral = hover;
        setPersonalizacion();

    }

    /**
     * 
     * @param hover       Hover del JtextField
     * @param advertencia Advertencia en caso que deje el campo vacio
     */
    public CustomText(String hover, String advertencia) {
        super(hover);
        hoverGeneral = hover;
        advertenciaGeneral = advertencia;
        setPersonalizacion();

    }

    private void setPersonalizacion() {
        addFocusListener(this);
        setForeground(Color.GRAY);
        setCaretColor(Color.BLACK);
        setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
        setMinimumSize(new Dimension(20, 20)); // no hace nada en RESPONSIVE
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (getText().trim().equalsIgnoreCase(advertenciaGeneral)) {
            setText("");
        }

        if (getText().trim().equalsIgnoreCase(hoverGeneral)) {
            setText("");
        }
        setForeground(Color.BLACK);
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getText().trim().length() == 0) {
            setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.RED));
            setForeground(Color.GRAY);
            setText(advertenciaGeneral);
        } else {
            // setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
            setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
        }

        // SOLO ES UNA PRUEBA
        if (validarProducto(getText())) {
            // JOptionPane.showMessageDialog(null, "El dato es valido");
        } else {
            JOptionPane.showMessageDialog(null, "El dato NO es valido");
        }

    }

    public boolean validarNombre(String valor) {
        return valor.trim().matches("^([a-z]|[A-Z]| [a-z]| [A-Z])+$");
    }

    public boolean validarProducto(String valor) {
        return valor.trim().matches("^(.|[a-z]|[A-Z]|[0-9]| [0-9]| [a-z]| [A-Z])+");
    }

}
