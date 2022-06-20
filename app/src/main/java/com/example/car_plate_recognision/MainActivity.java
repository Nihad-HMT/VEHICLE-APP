package com.example.car_plate_recognision;

import static android.text.TextUtils.isEmpty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    public static final String MyPREFERENCES = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();

        final EditText emailtext = findViewById(R.id.editTextTextEmailAddress);
        final EditText passwordtxt = findViewById(R.id.editTextTextPassword);

        Context context = this;

        Button btnLogin = findViewById(R.id.login);
        btnLogin.setOnClickListener(v -> {

            String username = emailtext.getText().toString();
            String password = passwordtxt.getText().toString();
            authenticateUser(username,password);

        });


    }

    private void authenticateUser(String username, String password) {
        if ((username.equals("varun")) && (password.equals("1234"))) {
            Log.e("USER CHECK ", "Credential match...");
        } else if ((username.equals("nihad")) && (password.equals("1234"))) {
        } else if ((username.equals("kuvilen")) && (password.equals("1234"))) {
        } else {
            Log.e("USER CHECK ", "Credential does not match....");
        }
    }
}