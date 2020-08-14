package com.example.room_escpae_lonsignin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.room_escpae_lonsignin.R.id.signin;

public class LoginActivity extends AppCompatActivity {

    Button sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sign = findViewById(R.id.signin);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent i = new Intent(LoginActivity.this,SinginActivity.class);
                startActivity(i);
            }
        });
    }
}