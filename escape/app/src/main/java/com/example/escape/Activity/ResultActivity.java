package com.example.escape_room.Activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.escape_room.Adapter.DetailThemeAdapter;
import com.example.escape_room.Adapter.Item_detail;
import com.example.escape_room.R;
import com.example.escape_room.Server.DetailImageBitMap;
import com.example.escape_room.Server.Task;
import com.example.escape_room.Server.model_theme;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class ResultActivity extends AppCompatActivity {

    model_theme[] modelThemes;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        GridView gridView = findViewById(R.id.gridview_theme);
        DetailThemeAdapter adapter = new DetailThemeAdapter();

        String themeText = "null";

        Task task = new Task();
        task.setapitype("theme/week");
        try {
            themeText = task.execute().get();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }

        modelThemes = new model_theme[jsonlength(themeText)];
        jsonParsing(themeText);

        Bitmap bm;



        for(int i=0; i<jsonlength(themeText); i++){
            DetailImageBitMap detailImageBitMap = new DetailImageBitMap("http://220.149.235.230/"+modelThemes[i].getImage());
            Bitmap bitmap = null;

            try {
                bitmap = detailImageBitMap.execute().get();
            }catch (InterruptedException e){
                e.printStackTrace();
            }catch (ExecutionException e){
                e.printStackTrace();
            }
            adapter.addItem(new Item_detail(bitmap, modelThemes[i].getThemeName(), modelThemes[i].getDescription(),modelThemes[i].getGenreId()));
        }

        gridView.setAdapter(adapter);

    }

    private void jsonParsing(String json)
    {
        try{

            JSONArray themeArray = new JSONArray(json);

            for(int i=0; i<themeArray.length(); i++)
            {
                JSONObject themeObject = themeArray.getJSONObject(i);

                modelThemes[i] = new model_theme(themeObject.getString("themeId")
                        ,themeObject.getString("themeName")
                        ,themeObject.getString("cafeName")
                        ,themeObject.getString("area")
                        ,themeObject.getString("genreId")
                        ,themeObject.getString("price")
                        ,themeObject.getString("pricePlus")
                        ,themeObject.getString("level")
                        ,themeObject.getString("time")
                        ,themeObject.getString("activity")
                        ,themeObject.getString("peopleNum")
                        ,themeObject.getString("barrier")
                        ,themeObject.getString("rating")
                        ,themeObject.getString("image")
                        ,themeObject.getString("description")
                        ,themeObject.getString("liked")
                        ,themeObject.getString("review")
                );
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private  int jsonlength(String json){
        try{
            JSONArray themeArray = new JSONArray(json);
            return  themeArray.length();
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
