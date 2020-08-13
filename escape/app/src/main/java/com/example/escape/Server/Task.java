package com.example.escape.Server;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Task extends AsyncTask<String, String, String> {

    URL url = null;
    String str, receiveMsg;
    String apitype;

    @Override
    public String doInBackground(String... params) {
        try {
            url = new URL("http://220.149.235.230:8001/api/"+apitype);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

            InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
            BufferedReader reader = new BufferedReader(tmp);
            StringBuffer buffer = new StringBuffer();
            while ((str = reader.readLine()) != null) {
                buffer.append(str);
            }
            receiveMsg = buffer.toString();
            Log.i("receiveMsg : ", receiveMsg);

            reader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return receiveMsg;
    }

    public void setapitype(String apitype){
        this.apitype = apitype;
    }

    public String[] cafejsonParser(String jsonString) {

        String cafeId = null;
        String cafeName = null;
        String area = null;
        String address = null;
        String latitude = null;
        String longtitude = null;
        String url = null;
        String phonenum = null;
        String logo = null;
        String themes = null;

        String[] arraysum = new String[10];
        try {
            JSONArray jarray = new JSONObject(jsonString).getJSONArray("food_list");
                for (int i = 0; i < jarray.length(); i++) {
                HashMap map = new HashMap<>();
                JSONObject jObject = jarray.getJSONObject(i);

                cafeId = jObject.optString("cafeId");
                cafeName = jObject.optString("cafeName");
                area = jObject.optString("area");
                address = jObject.optString("address");
                latitude = jObject.optString("latitude");
                longtitude = jObject.optString("longtitude");
                url = jObject.optString("url");
                phonenum = jObject.optString("phonenum");
                logo = jObject.optString("logo");
                themes = jObject.optString("themes");

                arraysum[0] = cafeId;
                arraysum[1] = cafeName;
                arraysum[2] = area;
                arraysum[3] = address;
                arraysum[4] = latitude;
                arraysum[5] = longtitude;
                arraysum[6] = url;
                arraysum[7] = phonenum;
                arraysum[8] = logo;
                arraysum[9] = themes;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arraysum;
    }

}
