package com.example.car_plate_recognision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        ImageView BackButton = findViewById(R.id.imageView7);
        BackButton.setOnClickListener(v -> {
            Intent backButton = new Intent(RegisterActivity.this, HomePageActivity.class);
            startActivity(backButton);
        });
    }
}