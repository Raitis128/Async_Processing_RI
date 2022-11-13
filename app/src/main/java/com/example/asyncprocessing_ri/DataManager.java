package com.example.asyncprocessing_ri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DataManager {

    public static ArrayList<com.example.asyncprocessing_ri.Currency> getRateFromECB() throws IOException {
        ArrayList<com.example.asyncprocessing_ri.Currency> currenciesList;
        try (InputStream stream = downloadUrl()) {
            currenciesList = com.example.asyncprocessing_ri.XmlParser.getRateFromECB(stream);
        }
        return currenciesList;
    }

    private static InputStream downloadUrl() throws IOException {
        URL url = new URL(com.example.asyncprocessing_ri.Constants.ECB_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(20000);
        conn.setConnectTimeout(25000);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
        return conn.getInputStream();
    }
}
