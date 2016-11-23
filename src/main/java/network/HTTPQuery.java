package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by mikhailsoparin on 22/11/16.
 */
public class HTTPQuery {

    public String sendingGetRequest(String city) throws IOException {

        StringBuilder urlString = new StringBuilder("http://www.goeuro.com/api/v2/position/suggest/en/");
        urlString.append(city);
        URL url = new URL(urlString.toString());

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();

        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        in.close();

        return response.toString();
    }


}
