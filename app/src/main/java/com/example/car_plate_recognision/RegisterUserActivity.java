package com.example.car_plate_recognision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.car_plate_recognision.database.DataBaseHelper;
import com.example.car_plate_recognision.model.UserModel;

public class RegisterUserActivity extends AppCompatActivity {
    DataBaseHelper db = new DataBaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        EditText username = null;
        EditText lastname = null;
        EditText password = null;
        EditText nic = null;
        EditText email = null;
        EditText phone = null;
        Button register;

        username = findViewById(R.id.username);
        lastname = findViewById(R.id.lastname);
        password = findViewById(R.id.password);
        nic = findViewById(R.id.nic);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        register = findViewById(R.id.register);


//
        EditText finalEditTextTextPersonName = username;
        EditText finalEditTextTextPersonName1 = lastname;
        EditText finalEditTextTextPersonName2 = password;
        EditText finalEditTextTextPersonName3 = nic;
        EditText finalEditTextTextPersonName4 = email;
        EditText finalEditTextTextPersonName5 = phone;

        String username1 = username.getText().toString();
        String lastname2 = lastname.getText().toString();
        String password3 = password.getText().toString();
        String nic4 = nic.getText().toString();
        String email5 = email.getText().toString();
        String phone6 = phone.getText().toString();

        register.setOnClickListener(arg0 -> {
            // TODO Auto-generated method stub
            if(finalEditTextTextPersonName.getText().toString().trim().length()==0){
                finalEditTextTextPersonName.setError("UserName is not entered");
                finalEditTextTextPersonName.requestFocus();
            }
            if(finalEditTextTextPersonName1.getText().toString().trim().length()==0){
                finalEditTextTextPersonName1.setError("Password is not entered");
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
            db.addUser(new UserModel("",username1,password3,email5,"",phone6,nic4,""));
        });
    }
}