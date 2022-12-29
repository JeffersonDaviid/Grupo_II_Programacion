import java.util.ArrayList;

import pkPersona.Trabajador;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Trabajador> lsTrabajadores = new ArrayList<Trabajador>();

        Trabajador trabajador1 = new Trabajador("Jefferson", "1752760500", 25, "M", 12345, "NOTHING XD");

        lsTrabajadores.add(trabajador1);

        for (Trabajador w : lsTrabajadores) {
            System.out.println("Su nombre es:\t" + w.getNombre());
            System.out.println("Su cedula es:\t" + w.getCedula());
            System.out.println("Su Sexo es:\t" + w.getSexo());
            System.out.println("Su Edad es:\t" + w.getEdad());
            System.out.println("Su Codigo es:\t" + w.getCodigo());
            System.out.println("Su Cargo es:\t" + w.getCargo());
        }

        String nombre = "Jefferson David Chileno Manobanda";

        char[] valores = nombre.toCharArray();
        for (int i = nombre.length() - 1; i >= 0; i--) {
            System.out.print(valores[i]);
        }

    }

    public static boolean validarNombre(String nombre) {
        return nombre.matches("^[A-Z]{1}[a-z]{2-16}$");
    }

    public static boolean validarEdad(String edad) {
        return edad.matches("^[1-6][0-9]$");
    }

    public static boolean validarCodigo(String codigo) {
        return codigo.matches("^[0-9]{6}$");
    }
}
