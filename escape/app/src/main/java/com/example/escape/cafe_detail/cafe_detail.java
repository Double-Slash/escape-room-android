package com.example.escape.cafe_detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.app.FragmentManager;
import android.media.Rating;
import android.os.Bundle;
import android.widget.RatingBar;

import com.example.escape.Fragment.MapFragment;
import com.example.escape.R;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class cafe_detail extends AppCompatActivity implements OnMapReadyCallback {

    ViewPager viewPager;
    com.example.escape.cafe_detail.Adapter adapter;
    List<com.example.cafe_detail.Model> models;
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

        models = new ArrayList<>();
        models.add(new com.example.cafe_detail.Model(R.drawable.c,"테마명","카페명"));
        models.add(new com.example.cafe_detail.Model(R.drawable.c,"테마명1","카페명"));
        models.add(new com.example.cafe_detail.Model(R.drawable.c,"테마명2","카페명"));
        models.add(new com.example.cafe_detail.Model(R.drawable.c,"테마명3","카페명"));

        adapter = new com.example.escape.cafe_detail.Adapter(models, this);

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