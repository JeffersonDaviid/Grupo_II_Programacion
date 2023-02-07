import BussinessLogic.PersonaBL;
import BussinessLogic.Entities.Persona;

public class App {
    public static void main(String[] args) throws Exception {

        PersonaBL personas = new PersonaBL();

        for (Persona p : personas.getPesonas()) {
            System.out.println(
                    "Usuario <" + p.getId() + "> : " + p.getName().toUpperCase());
            System.out.println("\t <> Email: "
                    + p.getEmail());
            System.out.println("\t <> Phone: "
                    + p.getPhone());
            System.out.println("\t <> Website: "
                    + p.getWebsite());
            // ACCEDER A UN OBJETO DE SEGUNDO NIVEL
            System.out.println("\t <> Empresa: "
                    + p.getEmpresa()
                            .toUpperCase());
            System.out.println();
        }
    }
}
