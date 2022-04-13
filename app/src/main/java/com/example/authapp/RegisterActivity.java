package com.example.authapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void registerMethod(View v){
        String msg;
        EditText name = findViewById(R.id.nameText);
        EditText login = findViewById(R.id.emailText);
        EditText pass = findViewById(R.id.passText);
        if(login.getText().toString().equals("") || pass.getText().toString().equals("") || name.getText().toString().equals("")){
            Toast.makeText(this,"Please enter your information",Toast.LENGTH_LONG).show();
        }/*
        else{
            msg = "register-" + login.getText().toString() + "-" + pass.getText().toString() + "-" + name.getText().toString();
            ClientThread clt = new ClientThread("192.168.2.109",8001,msg);

            clt.start();

            Log.d("ttag", "registerMethod: "+ Helper.raspunsLogin);
            if(Helper.raspunsLogin==true){
                Toast.makeText(this,"Te-ai inregistrat",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this,"contul exista deja",Toast.LENGTH_LONG).show();
            }
        }*/
    }
    public void goToLogin(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}