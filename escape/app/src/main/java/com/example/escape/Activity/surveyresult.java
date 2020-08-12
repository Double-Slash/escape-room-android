package com.example.escape.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.escape.R;

public class surveyresult extends AppCompatActivity {
    TextView resulttext;
    Button returnbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surveyresult);
        resulttext = findViewById(R.id.textView);
        returnbutton = findViewById(R.id.button);

        Intent secondintent = getIntent();
        String genreresult = secondintent.getStringExtra("genreresult");

        final Intent mainIntent = new Intent(this, MainActivity.class);

        resulttext.setText("당신의 맞춤 테마는 "+genreresult+"입니다");

        returnbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mainIntent);
            }
        });
    }
}
