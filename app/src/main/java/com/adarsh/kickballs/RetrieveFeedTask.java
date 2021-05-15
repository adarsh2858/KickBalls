package com.adarsh.kickballs;

import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RetrieveFeedTask extends AsyncTask<URL, Integer, Long> {
    protected Long doInBackground(URL... urls) {
        int count = urls.length;
        long totalSize = 0;
        try {
            // Create a neat value object to hold the URL
//            URL url = new URL("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
            URL url = new URL("https://h5p9ullr2j.execute-api.ap-south-1.amazonaws.com/dev/service");

            // Open a connection(?) on the URL(??) and cast the response(???)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Now it's "open", we can set the request method, headers etc.
            connection.setRequestProperty("accept", "application/json");

            // This line makes the request
            InputStream responseStream = connection.getInputStream();
            System.out.println(responseStream);

            // Manually converting the response body InputStream to APOD using Jackson
//            ObjectMapper mapper = new ObjectMapper();
//            APOD apod = mapper.readValue(responseStream, APOD.class);

            // Finally we have the response

//            System.out.println(apod.title);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalSize;
    }

}
