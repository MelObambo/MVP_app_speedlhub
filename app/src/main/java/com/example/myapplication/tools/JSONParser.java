package com.example.myapplication.tools;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Objects;

public class JSONParser {
    String charset = "UTF-8";
    HttpURLConnection connection;
    DataOutputStream wr;
    StringBuilder result;
    URL urlObj;
    JSONObject jObj = null;
    StringBuilder urlParams;
    StringBuilder bodyParams;
    String paramsString;

    protected static String convertBody(String str) {
        try {
            byte[] buffer = StandardCharsets.ISO_8859_1.encode(str).array();
            return new String(buffer);
        } catch (Exception ex) {
            ex.fillInStackTrace();
        }
        return null;
    }

    public JSONObject makeHttpRequest(String url, String apiKey, String urlParam,
                                      HashMap<String, String> hmUrlParams, HashMap<String, String> hmBodyParams) {

        urlParams = new StringBuilder();
        int i = 0;
        for (String key : hmUrlParams.keySet()) {
            try {
                if (i != 0){
                    urlParams.append("&");
                }
                urlParams.append(key).append("=").append(URLEncoder.encode(hmUrlParams.get(key), charset));

            } catch (UnsupportedEncodingException e) {
                e.fillInStackTrace();
            }
            i++;
        }

//        bodyParams = new StringBuilder();
//        int j = 0;
//        for (String key : hmBodyParams.keySet()) {
//            if (j == 0){
//                bodyParams.append("{\"");
//            } else {
//                bodyParams.append(",\"");
//            }
//            bodyParams.append(key).append("\": \"").append(hmBodyParams.get(key)).append("\"");
//            j++;
//        }
//        if (bodyParams.length() != 0) {
//            bodyParams.append("}");
//            paramsString = bodyParams.toString();
//        }

        if (!Objects.isNull(urlParam)) {
            url += "/" + urlParam;
        } else if (urlParams.length() != 0) {
            url += "?" + urlParams.toString();
        }
        try {
            urlObj = new URL(url);
            connection = (HttpURLConnection) urlObj.openConnection();
            connection.setDoOutput(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept-Charset", charset);
            //TODO: add the other request properties

            //connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            //ou
            //connection.setRequestProperty("x-api-key", apiKey);

            connection.setConnectTimeout(15000);
            connection.setReadTimeout(10000);
            connection.connect();
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        try {
            InputStream in = new BufferedInputStream(connection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            // help to debug
            Log.d("JSON Parser", "result: " + result.toString());
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        connection.disconnect();

        try {
            jObj = new JSONObject(result.toString());
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        return jObj;
    }
}
