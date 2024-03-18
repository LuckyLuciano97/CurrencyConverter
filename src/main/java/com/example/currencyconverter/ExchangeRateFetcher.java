package com.example.currencyconverter;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateFetcher {

    String req_result;
    String result;
    private static HttpURLConnection connection;

    private static final String APIKEY = "99dddd8d92499f0d4e4c202b";

    public ExchangeRateFetcher(String baseCurrency, String targetCurrency, String amount) throws IOException {

        URL url = new URL("https://v6.exchangerate-api.com/v6/" + APIKEY + "/pair/" + baseCurrency + "/" + targetCurrency);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

// Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();



// Accessing object
        req_result = jsonobj.get("conversion_rate").getAsString();
        result = String.valueOf((Double.parseDouble(req_result) * Double.parseDouble(amount)));
    }

    public String getReq_result() {
        return req_result;
    }

    public void setReq_result(String req_result) {
        this.req_result = req_result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}


