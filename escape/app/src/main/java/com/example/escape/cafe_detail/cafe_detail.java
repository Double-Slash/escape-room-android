package com.example.cafe_detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.media.Rating;
import android.os.Bundle;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.List;

public class cafe_detail extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

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
        models.add(new Model(R.drawable.kiki,"테마명","카페명"));
        models.add(new Model(R.drawable.kiki,"테마명1","카페명"));
        models.add(new Model(R.drawable.kiki,"테마명2","카페명"));
        models.add(new Model(R.drawable.kiki,"테마명3","카페명"));

        adapter = new Adapter(models, this);

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
}