package com.example.escape.Fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Movie;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.escape.Adapter.cafeadapter;
import com.example.escape.Adapter.cafeitem;
import com.example.escape.R;
import com.example.escape.Server.LoadImageBitmap;
import com.example.escape.Server.Task;
import com.example.escape.Server.model_cafe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

public class SearchFragment extends Fragment {
    model_cafe[] modelCafes;
    Handler handler = new Handler();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_search , container, false);
        GridView gridView = view.findViewById(R.id.gridview_cafe);
        cafeadapter adapter = new cafeadapter();

        Button button_search = view.findViewById(R.id.button_search);

        String cafeText = "null";


        Task task = new Task();
        task.setapitype("cafe");
        try {
            cafeText = task.execute().get();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }

        modelCafes = new model_cafe[jsonlength(cafeText)];
        jsonParsing(cafeText);

        Bitmap bm;

        for(int i=0; i<jsonlength(cafeText); i++){
            LoadImageBitmap loadImageBitmap = new LoadImageBitmap("http://220.149.235.230/"+modelCafes[i].getLogo());
            Bitmap bitmap = null;

            try {
                bitmap = loadImageBitmap.execute().get();
            }catch (InterruptedException e){
                e.printStackTrace();
            }catch (ExecutionException e){
                e.printStackTrace();
            }
            adapter.addItem(new cafeitem(bitmap, modelCafes[i].getCafeName(), modelCafes[i].getArea(),1));
        }

        gridView.setAdapter(adapter);

        button_search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });

        return view;
    }

    private void jsonParsing(String json)
    {
        try{

            JSONArray cafeArray = new JSONArray(json);

            for(int i=0; i<cafeArray.length(); i++)
            {
                JSONObject cafeObject = cafeArray.getJSONObject(i);

                modelCafes[i] = new model_cafe(cafeObject.getString("cafeId")
                        ,cafeObject.getString("cafeName")
                        ,cafeObject.getString("area")
                        ,cafeObject.getString("address")
                        ,cafeObject.getString("latitude")
                        ,cafeObject.getString("longitude")
                        ,cafeObject.getString("url")
                        ,cafeObject.getString("phoneNum")
                        ,cafeObject.getString("logo")
                        ,cafeObject.getString("themes")
                        );
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private  int jsonlength(String json){
        try{
            JSONArray cafeArray = new JSONArray(json);
            return  cafeArray.length();
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

