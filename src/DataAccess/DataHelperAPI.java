package DataAccess;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataHelperAPI {

    public static void main(String[] args) throws IOException {
        try {

            URL url = new URL("https://jsonplaceholder.typicode.com/users/");
            HttpURLConnection conn = (HttpsURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            InputStream strm = conn.getInputStream();
            byte[] arrayStream = strm.readAllBytes();

            String contentJson = "";

            for (byte tmp : arrayStream) {
                contentJson += (char) tmp;
            }
            // System.out.println(contentJson);

            JSONArray json = new JSONArray(contentJson);

            for (Object obj : json) {
                // SIMULANDO UN WHERE

                // ACCEDER A UN OBJETO DE PRIMER NIVEL
                System.out.println("Usuario: " + ((JSONObject) obj).get("name").toString().toUpperCase());
                System.out.println("\t <> Email: "
                        + ((JSONObject) obj).get("email").toString().toUpperCase());
                System.out.println("\t <> Phone: "
                        + ((JSONObject) obj).get("phone").toString().toUpperCase());
                System.out.println("\t <> Website: "
                        + ((JSONObject) obj).get("website").toString().toUpperCase());
                // ACCEDER A UN OBJETO DE SEGUNDO NIVEL
                System.out.println("\t <> Empresa: "
                        + new JSONObject(((JSONObject) obj).get("company").toString()).get("name").toString()
                                .toUpperCase());
                System.out.println();
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}