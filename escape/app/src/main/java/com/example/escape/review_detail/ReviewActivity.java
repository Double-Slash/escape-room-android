package com.example.room_escape_review;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {

    RecyclerView mrecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_layout);

        mrecyclerView=findViewById(R.id.recyclerview);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(this, getMyList());
        mrecyclerView.setAdapter(myAdapter);

    }
    private ArrayList<Model> getMyList(){
        ArrayList<Model> models = new ArrayList<>();

        Model m= new Model();
        m.setTitle("테마명");
        m.setCafe("카페명");
        m.setScore("난이도");
        m.setDescription("후기");
        m.setImg(R.drawable.kiki);
        models.add(m);

        m.setTitle("테마명");
        m.setCafe("카페명");
        m.setScore("난이도");
        m.setDescription("후기");
        m.setImg(R.drawable.kiki);
        models.add(m);

        m.setTitle("테마명");
        m.setCafe("카페명");
        m.setScore("난이도");
        m.setDescription("후기");
        m.setImg(R.drawable.kiki);
        models.add(m);

        m.setTitle("테마명");
        m.setCafe("카페명");
        m.setScore("난이도");
        m.setDescription("후기");
        m.setImg(R.drawable.kiki);
        models.add(m);


        return models;
    }
}