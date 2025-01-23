package io.swagger.client.selfCreatedServicesEtc;

import com.google.gson.Gson;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequest {
    public static <T> String sendPostRequest(String urlString, T t) throws Exception {
        URL url = new URL(urlString);
        System.out.println(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");

        String jsonInputString;

        if (t instanceof String) {
            jsonInputString = (String) t;
        } else {
            Gson gson = new Gson();
            jsonInputString = gson.toJson(t);
        }

        System.out.println("debugging:" + jsonInputString);

        // JSON-Daten senden
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        return HttpResponse.getFullResponse(con);
    }
}
