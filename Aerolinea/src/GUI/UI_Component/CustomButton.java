package GUI.UI_Component;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class CustomButton extends JButton implements MouseListener {
    public CustomButton(String label) {
        super(label);
        setPersonalizacion();
    }

    public CustomButton(String label, String iconPath) {
        super(label);
        setPersonalizacion();
        setIcon(new ImageIcon(iconPath));
    }

    /**
     * Método que coloca toda la personalización
     * 
     */
    void setPersonalizacion() {
        addMouseListener(this);
        setOpaque(false);
        setForeground(Color.black);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setHorizontalAlignment(SwingConstants.LEFT);
        setFont(new Font("Dialog", Font.ROMAN_BASELINE | Font.LAYOUT_LEFT_TO_RIGHT, 12));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setForeground(new Color(255, 87, 34));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.BLACK);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}
