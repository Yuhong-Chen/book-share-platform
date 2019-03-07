package impl.model;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {

    private String hostname = "";
    private HttpURLConnection urlConnection;

    public Request(String resource) {
        try {
            URL url = new URL(hostname + resource);
            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends POST request to resource at host
     * @param json
     */
    public void post(JsonObject json) {
        OutputStream out = null;
        try {
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");

            out = urlConnection.getOutputStream();
            out.write(json.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
