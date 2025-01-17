package com.example.escape_room.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.escape_room.Activity.ResultActivity;
import com.example.escape_room.Adapter.WeekThemeAdapter;
import com.example.escape_room.Adapter.Item;
import com.example.escape_room.R;
import com.example.escape_room.Server.WeekImageBitmap;
import com.example.escape_room.Server.Task;
import com.example.escape_room.Server.model_theme;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class HomeFragment extends Fragment {
    model_theme[] modelThemes;
    Handler handler = new Handler();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home , container, false);
        GridView gridView = view.findViewById(R.id.gridview_theme);
        WeekThemeAdapter adapter = new WeekThemeAdapter();

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
            WeekImageBitmap weekImageBitmap = new WeekImageBitmap("http://220.149.235.230/"+modelThemes[i].getImage());
            Bitmap bitmap = null;

            try {
                bitmap = weekImageBitmap.execute().get();
            }catch (InterruptedException e){
                e.printStackTrace();
            }catch (ExecutionException e){
                e.printStackTrace();
            }
            adapter.addItem(new Item(bitmap, modelThemes[i].getCafeName(), modelThemes[i].getArea(),modelThemes[i].getGenreId()));
        }

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),ResultActivity.class);
                startActivity(intent);
            }
        });


        return view;
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