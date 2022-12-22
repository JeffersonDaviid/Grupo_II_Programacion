import java.util.ArrayList;
import java.util.Scanner;

import pkMascota.Mascota;

public class App extends Mascota {

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
        int edad;
        boolean estadoMatch;
        String propietario;
        String observacion;

        System.out.println("\n\n\n\tBienvenido al sistema de registro de TINDER-PET");
        System.out.print("Datos de la mascota: ");
        System.out.println("Ingrese nombre de la mascota: ");
        nombre = sc.nextLine();
        sc.nextLine();
        System.out.println("Ingrese genero de la mascota (M = Masculino, F = Femenino): ");
        tipo = sc.nextLine();
        sc.nextLine();
        System.out.println("Ingrese la raza de la mascota: ");
        raza = sc.nextLine();
        sc.nextLine();
        System.out.println("Ingrese edad de la mascota: ");
        edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese propietario de la mascota: ");
        propietario = sc.nextLine();
        sc.nextLine();
        System.out.println("Ingrese observacion de la mascota: ");
        observacion = sc.nextLine();
        sc.nextLine();

        estadoMatch = true;

        // ingresar mascota
        Mascota pet = new Mascota(nombre, tipo, raza, edad, estadoMatch, propietario, observacion);
        lsMascotas.add(pet);
        System.out.println("\n\n\n" + pet.nombre + " ha sido agredado exitosamente :)");

    }

    public static void mostrarMascota(ArrayList<Mascota> lsMascotas) {
        int numMacota = -1;
        System.out.println("\n\n\tListado de user-pets en TINDER-PET\n\n");
        for (Mascota pet : lsMascotas) {
            numMacota++;
            if (pet.estadoMatch == true) {
                System.out.println("Mascota #" + numMacota);
                System.out.println("\tNombre:\t\t" + pet.nombre);
                System.out.println("\tTipo:\t\t" + pet.tipo);
                System.out.println("\tRaza:\t\t" + pet.raza);
                System.out.println("\tEdad:\t\t" + pet.edad);
                System.out.println("\tEstadoMatch:\t" + pet.estadoMatch);
                System.out.println("\tPropietario:\t" + pet.propietario);
                System.out.println("\tObservacion:\t" + pet.observacion);
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
            if (i == posicion1 && lsMascotas.get(i).estadoMatch == true)
                lsMascotas.get(i).estadoMatch = false;
            if (i == posicion2 && lsMascotas.get(i).estadoMatch == true)
                lsMascotas.get(i).estadoMatch = false;
        }
        System.out.println("\t" + lsMascotas.get(posicion1).nombre + " y " + lsMascotas.get(posicion2).nombre
                + " ahora están enlazados <3 \n\n\n\n\n");

    }

    public static void main(String[] args) throws Exception {
        // lista de todas las mascotas de la App
        ArrayList<Mascota> lsMascotas = new ArrayList<Mascota>();

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
}
