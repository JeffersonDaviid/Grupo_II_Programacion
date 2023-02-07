package BussinessLogic;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import BussinessLogic.Entities.Persona;
import DataAccess.PersonaDAC;

public class PersonaBL {

    public ArrayList<Persona> getPesonas() throws IOException {
        try {
            ArrayList<Persona> lsUsuarios = new ArrayList<Persona>();
            PersonaDAC personaDac = new PersonaDAC();
            JSONArray resultado = personaDac.getResultado();
            for (Object obj : resultado) {
                Persona p = new Persona(
                        Integer.parseInt(((JSONObject) obj).get("id").toString()),
                        ((JSONObject) obj).get("name").toString(),
                        ((JSONObject) obj).get("email").toString(),
                        ((JSONObject) obj).get("phone").toString(),
                        ((JSONObject) obj).get("website").toString(),
                        new JSONObject(((JSONObject) obj).get("company").toString()).get("name").toString());
                lsUsuarios.add(p);
            }
            return lsUsuarios;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
