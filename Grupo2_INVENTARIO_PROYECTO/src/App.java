import java.util.ArrayList;

import pkPersona.Trabajador;

public class App {
    public static void main(String[] args) throws Exception {

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
