package com.example.car_plate_recognision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        EditText editTextTextPersonName = null;
        EditText editTextTextPersonName2 = null;
        EditText editTextTextPersonName3 = null;
        EditText editTextTextPersonName4 = null;
        EditText editTextTextPersonName5 = null;
        EditText editTextTextPersonName6 = null;
        Button register;
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);
        editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
        editTextTextPersonName5 = findViewById(R.id.editTextTextPersonName5);
        editTextTextPersonName6 = findViewById(R.id.editTextTextPersonName6);
        register = findViewById(R.id.register);

        EditText finalEditTextTextPersonName = editTextTextPersonName;
        EditText finalEditTextTextPersonName1 = editTextTextPersonName2;
        EditText finalEditTextTextPersonName2 = editTextTextPersonName3;
        EditText finalEditTextTextPersonName3 = editTextTextPersonName4;
        EditText finalEditTextTextPersonName4 = editTextTextPersonName5;
        EditText finalEditTextTextPersonName5 = editTextTextPersonName6;
        register.setOnClickListener(arg0 -> {
            // TODO Auto-generated method stub
            if(finalEditTextTextPersonName.getText().toString().trim().length()==0){
                finalEditTextTextPersonName.setError("UserName is not entered");
                finalEditTextTextPersonName.requestFocus();
            }
            if(finalEditTextTextPersonName1.getText().toString().trim().length()==0){
                finalEditTextTextPersonName1.setError("First-Name is not entered");
                finalEditTextTextPersonName1.requestFocus();
            }
            if(finalEditTextTextPersonName2.getText().toString().trim().length()==0){
                finalEditTextTextPersonName2.setError("Last-Name is not entered");
                finalEditTextTextPersonName2.requestFocus();
            }
            if(finalEditTextTextPersonName3.getText().toString().trim().length()==0){
                finalEditTextTextPersonName3.setError("NIC Number is not entered");
                finalEditTextTextPersonName3.requestFocus();
            }
            if(finalEditTextTextPersonName4.getText().toString().trim().length()==0){
                finalEditTextTextPersonName4.setError("Email is not entered");
                finalEditTextTextPersonName4.requestFocus();
            }
            if(finalEditTextTextPersonName5.getText().toString().trim().length()==0){
                finalEditTextTextPersonName5.setError("Mobile Number is not entered");
                finalEditTextTextPersonName5.requestFocus();
            }
            else{
                Intent it=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it);
            }
        });
    }
}