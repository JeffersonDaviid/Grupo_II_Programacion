package DataAccess;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public abstract class DataHelperAPI {

    protected static HttpURLConnection getConection(URL url) {
        try {
            HttpURLConnection conn;
            conn = (HttpsURLConnection) url.openConnection();
            return conn;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}