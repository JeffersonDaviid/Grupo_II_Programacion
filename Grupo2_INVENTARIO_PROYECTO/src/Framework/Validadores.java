package Framework;

import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class Validadores {
    public final Scanner sc = new Scanner(System.in);

    /**
     * Obteniene y verifica un valor entero
     * 
     * @param etiqueta texto a mostrar de la petición
     * @return retorna el valor entero
     */
    public int getNumberInt(String etiqueta) {
        String dato;
        do {
            System.out.println(etiqueta);
            dato = sc.nextLine();
            if (dato.trim().length() == 0)
                System.out.println("\tWARNING! No se puede dejar campos sin llenar :(");
            else {
                if (validarDatoEntero(dato))
                    return Integer.parseInt(dato);
                else {
                    System.out.println("\tWARNING! El valor ingresado no es válido");
                }
            }
        } while (true);
    }

    /**
     * Obteniene y verifica una numero decimal
     * 
     * @param etiqueta texto a mostrar de la petición
     * @return retorna el valor float
     */
    public float getNumberFloat(String etiqueta) {
        String dato;
        do {
            System.out.println(etiqueta);
            dato = sc.nextLine();
            if (dato.trim().length() == 0)
                System.out.println("\tWARNING! No se puede dejar campos sin llenar :(");
            else {
                if (validarDatoFloat(dato))
                    return Float.parseFloat(dato);
                else {
                    System.out.println("\tWARNING! El valor ingresado no es válido");
                }
            }
        } while (true);
    }

    /**
     * Obteniene y verifica una cadena de texto
     * 
     * @param etiqueta texto a mostrar de la petición
     */
    public String getChar(String etiqueta) {
        String dato;
        do {
            System.out.println(etiqueta);
            dato = sc.nextLine();
            if (dato.trim().length() == 0)
                System.out.println("\tWARNING! No es posible dejar campos sin llenar :( \n");
        } while (dato.trim().length() == 0);
        return dato.substring(0, 1).toUpperCase();
    }

    /**
     * Obteniene y verifica una cadena de texto
     * 
     * @param etiqueta texto a mostrar de la petición
     */
    public String getString(String etiqueta) {
        String dato;
        do {
            System.out.println(etiqueta);
            dato = sc.next();
            if (dato.trim().length() == 0)
                System.out.println("\tWARNING! No es posible dejar campos sin llenar :( \n");
        } while (dato.trim().length() == 0);
        return dato;
    }

    public boolean validarDatoEntero(String dato) {
        return dato.matches("[0-9]{1,9}");
    }

    public boolean validarDatoFloat(String dato) {
        return dato.matches("([0-9]{0,9}.[0-9]{1,9})|[0-9]{1,9}");
    }

    /**
     * Método que desactiva la opción de copiar, pegar y cortar texto de un
     * componente
     * 
     * @param componente : se envía como parámetro el componente, ya sea txt, txa,
     *                   etc.
     */
    public static void deshabilitarCVX(JComponent componente) {
        componente.getInputMap().put(KeyStroke.getKeyStroke("control C"), "none");
        componente.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
        componente.getInputMap().put(KeyStroke.getKeyStroke("shift INSERT"), "none");
        componente.getInputMap().put(KeyStroke.getKeyStroke("control X"), "none");
    }
}