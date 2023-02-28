package GUI.UI_Component;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.toedter.calendar.JCalendar;

public class CustomTextLabel extends JPanel{
    private JLabel label;
    private CustomText textField;

    /**
     * JText personalizado que incluye una etiqueta y además al hacer clic sobre él se muestra un calendario JCalendar
     * @param labelText : recibe un string que sera mostrado en el label
     * @param textFieldColumns : indica la cantidad de columnas que ocupara el JText
     */
    public CustomTextLabel(String labelText, int textFieldColumns){
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        label = new JLabel(labelText);
        label.setBackground(Color.white);
        label.setFont(new Font("TI-Nspire", Font.PLAIN, 12));
        Border bordeInferiorResaltado = BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK), 
        BorderFactory.createEmptyBorder(1, 0, 0, 0));
        label.setBorder(bordeInferiorResaltado);
        textField = new CustomText("Fecha","Ingresa Fecha");
        add(label, BorderLayout.WEST);
        add(textField, BorderLayout.CENTER);

        textField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(textField);
                JDialog dialogo = new JDialog(parentFrame, "Seleccionar fecha", true);
                JCalendar calendario = new JCalendar();
                //Calendar fechaActual = Calendar.getInstance();
                calendario.addPropertyChangeListener(new PropertyChangeListener() {
                    public void propertyChange(PropertyChangeEvent evt) {
                        if(evt.getOldValue() != null) {
                            Calendar fechaSeleccionada = calendario.getCalendar();
                            Calendar fechaActual = Calendar.getInstance();
                            //A continuación se establece la hora en 0 para que solo se comparen fechas
                            fechaActual.set(Calendar.HOUR_OF_DAY, 0);
                            fechaActual.set(Calendar.MINUTE, 0);
                            fechaActual.set(Calendar.SECOND, 0);
                            fechaActual.set(Calendar.MILLISECOND, 0);
                            if(fechaSeleccionada.compareTo(fechaActual) < 0) {
                                JOptionPane.showMessageDialog(parentFrame, "La fecha seleccionada debe ser mayor o igual a la fecha actual.", "Fecha inválida", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                            textField.setText(formatoFecha.format(fechaSeleccionada.getTime()));
                        }
                    }
                });
                dialogo.setLocationRelativeTo(parentFrame);
                dialogo.getContentPane().add(calendario);
                dialogo.pack();
                dialogo.setVisible(true);
            }
        });
    }


    public void setText(String text) {
        textField.setText(text);
    }

    public String getText() {
        return textField.getText();
    }
}
