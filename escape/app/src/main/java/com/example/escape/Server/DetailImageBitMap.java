package com.example.escape_room.Server;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class DetailImageBitMap extends AsyncTask<Void,Void, Bitmap> {

    private String urlStr;
    private static HashMap<String, Bitmap> bitmapHash = new HashMap<String, Bitmap>();

    public DetailImageBitMap(String urlStr) {
        this.urlStr = urlStr;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Bitmap doInBackground(Void... voids) {
        Bitmap bitmap = null;
        try {
            if (bitmapHash.containsKey(urlStr)) {
                Bitmap oldbitmap = bitmapHash.remove(urlStr);
                if(oldbitmap != null) {
                    oldbitmap.recycle();
                    oldbitmap = null;
                }
            }
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            conn.connect();
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            bitmap = BitmapFactory.decodeStream(bis);
            bis.close();
            bitmapHash.put(urlStr,bitmap);

            return bitmap;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}