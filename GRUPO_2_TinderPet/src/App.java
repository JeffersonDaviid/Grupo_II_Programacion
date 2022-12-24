import java.util.ArrayList;
import java.util.Scanner;

import pkMascota.Mascota;
import pkPersona.Propietario;

public class App {

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\n\t\tBienvenido a TINDER-PET GRUPO II\n\n");
        System.out.println("1. Registrar mascota\n2. Listar mascotas\n3. Establecer match\n0. Salir");
        int opcion = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        if (opcion == 1)
            return 1;
        if (opcion == 2)
            return 2;
        if (opcion == 3)
            return 3;
        if (opcion == 0)
            return 0;

        return -1;
    }

    public static void registrarMascota(ArrayList<Mascota> lsMascotas) {
        Scanner sc = new Scanner(System.in);
        String nombre;
        String tipo;
        String raza;
        String edad;
        String nombrePropietario;
        String observacion;

        System.out.println("\n\n\n\tBienvenido al sistema de registro de TINDER-PET");
        do {
            System.out.print("Datos de la mascota: ");
            nombre = sc.nextLine();
        } while (!ingresarDatoString(nombre));
        do {
            System.out.print("Ingrese genero de la mascota (M = Masculino, F = Femenino): ");
            tipo = sc.nextLine();
        } while (!ingresarDatoChar(tipo));
        do {
            System.out.print("Ingrese la raza de la mascota: ");
            raza = sc.nextLine();
        } while (!ingresarDatoString(raza));
        do {
            System.out.print("Ingrese edad de la mascota: ");
            edad = sc.nextLine();
        } while (!ingresarDatoInt(edad));
        do {
            System.out.print("Ingrese propietario de la mascota: ");
            nombrePropietario = sc.nextLine();
        } while (!ingresarDatoString(nombrePropietario));
        Propietario propietario = new Propietario(nombrePropietario);
        // do {
        System.out.print("Ingrese observacion de la mascota: ");
        observacion = sc.nextLine();
        // } while (!ingresarDatoString(observacion));

        // ingresar mascota
        Mascota pet = new Mascota(nombre, tipo, raza, Integer.parseInt(edad), propietario, observacion);
        lsMascotas.add(pet);
        System.out.println("\n\n\n" + pet.getNombre() + " ha sido agredado exitosamente :)");

    }

    public static void mostrarMascota(ArrayList<Mascota> lsMascotas) {
        int numMacota = -1;
        System.out.println("\n\n\tListado de user-pets en TINDER-PET\n\n");
        for (Mascota pet : lsMascotas) {
            numMacota++;
            if (pet.getEstadoMatch() == true) {
                System.out.println("Mascota #" + numMacota);
                System.out.println("\tNombre:\t\t" + pet.getNombre());
                System.out.println("\tTipo:\t\t" + pet.getTipo());
                System.out.println("\tRaza:\t\t" + pet.getRaza());
                System.out.println("\tEdad:\t\t" + pet.getEdad());
                System.out.println("\tEstadoMatch:\t" + pet.getEstadoMatch());
                System.out.println("\tPropietario:\t" + pet.getPropietario().getNombre());
                System.out.println("\tObservacion:\t" + pet.getObservacion());
                System.out.println();
            }
        }
    }

    public static void establecerMatch(ArrayList<Mascota> lsMascotas) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de mascota con la que desea enlazar <3");
        int posicion1 = sc.nextInt();
        System.out.println("Ingrese el numero de mascota con la que desea enlazar <3");
        int posicion2 = sc.nextInt();
        // vamos a pedir las posciones de las mascotas que se van a enlazar

        for (int i = 0; i < lsMascotas.size(); i++) {
            if (i == posicion1 && lsMascotas.get(i).getEstadoMatch() == true)
                lsMascotas.get(i).setEstadoMatch(false);
            if (i == posicion2 && lsMascotas.get(i).getEstadoMatch() == true)
                lsMascotas.get(i).setEstadoMatch(false);
        }
        System.out.println("\t" + lsMascotas.get(posicion1).getNombre() + " y " + lsMascotas.get(posicion2).getNombre()
                + " ahora están enlazados <3 \n\n\n\n\n");
    }

    public static void main(String[] args) throws Exception {
        // lista de todas las mascotas de la App
        ArrayList<Mascota> lsMascotas = new ArrayList<Mascota>();
        Propietario propietario1 = new Propietario("Jefferson");
        Propietario propietario2 = new Propietario("Evelyn");
        Propietario propietario3 = new Propietario("Alanis");
        Propietario propietario4 = new Propietario("Joselyn");
        // pets por defecto
        Mascota p1 = new Mascota("Daniela", "F", "calle", 12, propietario2, "Es muy linda xd");
        Mascota p2 = new Mascota("Daniel", "M", "cool", 12, propietario3, "Es un crack");
        Mascota p3 = new Mascota("Daniela", "M", "calle", 12, propietario1, "Le gusta el helado");
        Mascota p4 = new Mascota("Daniela", "M", "calle", 12, propietario2, "Es muy linda xd");
        Mascota p5 = new Mascota("Daniela", "M", "calle", 12, propietario4, "Es muy linda xd");
        Mascota p6 = new Mascota("Daniela", "M", "calle", 12, propietario3, "Es muy linda xd");
        lsMascotas.add(p1);
        lsMascotas.add(p2);
        lsMascotas.add(p3);
        lsMascotas.add(p4);
        lsMascotas.add(p5);
        lsMascotas.add(p6);
        do {
            switch (menu()) {
                case 1:
                    registrarMascota(lsMascotas);
                    break;
                case 2:
                    mostrarMascota(lsMascotas);
                    break;
                case 3:
                    establecerMatch(lsMascotas);
                    break;
                case 0:
                    System.out.println("Adioooossss....");
                    return;

                default:
                    break;
            }
        } while (true);
    }

    public static boolean ingresarDatoString(String dato) {
        return dato.matches("^([A-Z]{1}[a-z]{1,16})( [A-Z]{1}[a-z]{1,16}){0,1}$");
    }

    /**
     * Permite validar que el dato ingresado sea un solo caracter en mayuscula sea M
     * o F
     * 
     * @param dato string
     * @return true if it's true/correct
     */
    public static boolean ingresarDatoChar(String dato) {
        return dato.matches("^[M,F]$");
    }

    /**
     * 
     * @param dato
     * @return
     */
    public static boolean ingresarDatoInt(String dato) {
        // float
        // return dato.matches("^0|[1-9]+|1[1-9](.0|[1-9]+|1[1-9])*$");
        return dato.matches("^0|[1-9]+|1[1-9]$");
    }
}
