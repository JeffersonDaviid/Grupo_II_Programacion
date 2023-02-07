package DataAccess;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import org.json.JSONArray;

public class PersonaDAC extends DataHelperAPI {

    public JSONArray getResultado() throws IOException {
        HttpURLConnection conn = getConection(new URL("https://jsonplaceholder.typicode.com/users/"));
        try {
            conn.setRequestMethod("GET");

            InputStream strm = conn.getInputStream();
            byte[] arrayStream = strm.readAllBytes();

            String contentJson = "";

            for (byte tmp : arrayStream) {
                contentJson += (char) tmp;
            }
            // System.out.println(contentJson);}
            JSONArray json = new JSONArray(contentJson);
            return json;
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        return null;

    }

}
