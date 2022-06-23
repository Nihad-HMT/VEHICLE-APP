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

import com.example.car_plate_recognision.database.DataBaseHelper;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    private DataBaseHelper db = new DataBaseHelper(this);
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
            Log.e("TEST", authenticateUser(username, password)+"");

            if (authenticateUser(username, password).equals("a")) {
                editor.putString("username",username);
                editor.commit();
                SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                String uname = prefs.getString("username", "N/A");
                Log.e("adminUSNA", uname);
                Intent loginIntent = new Intent(MainActivity.this, HomePageActivity.class);
                startActivity(loginIntent);
                finish();
            }

        });


    }

    public String authenticateUser(String uname, String password) {
        String role = "";
        if ((uname.equals("varun")) && (password.equals("1234"))) {
            Log.e("USER CHECK ", "Credential match...");
            role = getUserRole(uname);
        }else if ((uname.equals("nihad")) && (password.equals("1234"))){
            role = getUserRole(uname);
        }else if ((uname.equals("jeeresh")) && (password.equals("1234"))){
            role = getUserRole(uname);
        }else {
            Log.e("USER CHECK ", "Credential does not match....");
        }
        return role;
    }

    public String getUserRole(String uname) {
        return db.getUserRole(uname);
    }
}