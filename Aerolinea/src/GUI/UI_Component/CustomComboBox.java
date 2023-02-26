package GUI.UI_Component;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CustomComboBox extends JComboBox{

    private ImageIcon imagen;
    private String labeText = "Label";
    private Color lineColor = new Color(3, 155, 216);
    private boolean mouseOver;
    
    public CustomComboBox(ImageIcon imagen){
        super();
        this.imagen = imagen;
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(15, 3, 5, 3));
        setRenderer(new ComboBoxRenderer());
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomComboBox cb = (CustomComboBox)e.getSource();
                ComboBoxRenderer cr = (ComboBoxRenderer)cb.getRenderer();
                cr.setSelectedIndex(cb.getSelectedIndex());
            }
        });
    }

    class ComboBoxRenderer extends JLabel implements ListCellRenderer {
        private Font uhOhFont;

        public ComboBoxRenderer() {
            setOpaque(true);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }

        public Component getListCellRendererComponent(
                JList list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            ImageIcon icon = (ImageIcon)value;
            setIcon(icon);
            if (icon != null) {
                setText(icon.getDescription());
                setFont(list.getFont());
            } else {
                setText("");
                if (uhOhFont == null) { 
                    uhOhFont = new Font("Arial", Font.PLAIN, 12);
                }
                setFont(uhOhFont);
            }

            return this;
        }

        public void setSelectedIndex(int index) {
            if (index == -1) {
                setIcon(imagen);
            } else {
                ImageIcon icon = (ImageIcon)getItemAt(index);
                setIcon(icon);
            }
        }
    }

    public String getLabeText() {
        return labeText;
    }
    
    public void setLabeText(String labeText) {
        this.labeText = labeText;
    }
    
    public Color getLineColor() {
        return lineColor;
    }
    
    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }
}
    


    
