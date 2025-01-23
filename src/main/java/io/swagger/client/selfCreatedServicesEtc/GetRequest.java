package io.swagger.client.selfCreatedServicesEtc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequest {
    static StringBuilder baseGetRequest(String urlString) {
        try {
            // Verbindung herstellen und Antwort abrufen
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Antwort lesen
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            return response;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
