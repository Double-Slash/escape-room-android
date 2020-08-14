package com.example.escape.cafe_detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.app.FragmentManager;
import android.graphics.Bitmap;
import android.media.Rating;
import android.os.Bundle;
import android.widget.RatingBar;

import com.example.escape.Adapter.cafeitem;
import com.example.escape.Fragment.MapFragment;
import com.example.escape.R;

import com.example.escape.Server.LoadImageBitmap;
import com.example.escape.Server.model_cafe;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.example.escape.Server.Task;
import com.example.escape.Server.model_cafe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;


public class cafe_detail extends AppCompatActivity implements OnMapReadyCallback {

    model_cafe[] modelCafes;
    ViewPager viewPager;
    com.example.escape.cafe_detail.Adapter adapter;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    private FragmentManager fragmentManager;
    private MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_detail);

        RatingBar rb = (RatingBar)findViewById(R.id.ratingBar);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

            }
        });

        adapter = new com.example.escape.cafe_detail.Adapter(modelCafes, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(0,0,380,0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng location = new LatLng(37.500237, 127.028354);//위치 샘플
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("강남키이스케이프");
        markerOptions.snippet("방탈출카페");
        markerOptions.position(location);
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,16));
    }
}