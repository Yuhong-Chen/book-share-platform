package client.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {

    private final String hostname = "http://localhost:8080/bookserver/webapi/";
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
     * @param json object to POST as data
     */
    public int post(JsonObject json) {
        OutputStream out = null;
        try {
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");

            out = urlConnection.getOutputStream();
            out.write(json.toString().getBytes());

            return urlConnection.getResponseCode();
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

        return 0;
    }

    /**
     * Sends GET request to resource at host
     */
    public JsonObject get() {
        OutputStream out = null;
        BufferedReader in = null;
        try {
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("GET");

            System.out.println(urlConnection.getResponseCode());

            if (urlConnection.getResponseCode() == 200) {
                String line;
                StringBuilder response = new StringBuilder();
                in = new BufferedReader(
                        new InputStreamReader(urlConnection.getInputStream())
                );

                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                System.out.println(response.toString());

                JsonParser parser = new JsonParser();

                return parser.parse(response.toString()).getAsJsonObject();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
