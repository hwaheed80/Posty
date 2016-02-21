package com.blackfishatom.posty;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hwaheed on 2/21/2016.
 */
public class WebRequest {

    public static <Input, Output> String Process(String apiurl, Input params) {
        try {
            String paramjson = Helper.GetJson(params);
            HttpURLConnection connection = null;
            URL url = new URL(apiurl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("_appclient", "android");
            connection.setRequestProperty("_appuserid", "hwaheed");
            connection.setRequestProperty("_appaccountid", "100");
            connection.setRequestProperty("_apptoken", "token");
            connection.getOutputStream().write(paramjson.getBytes());
            connection.connect();
            InputStream inputstream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
            String responseline = null;
            StringBuilder reponsebuilder = new StringBuilder();
            while ((responseline = reader.readLine()) != null) {
                reponsebuilder.append(responseline);
            }

            return reponsebuilder.toString();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
