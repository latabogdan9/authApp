package com.example.authapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void loginMethod(View v){
        String msg;
        EditText login = findViewById(R.id.emailText);
        EditText pass = findViewById(R.id.passText);
        /*
        if(login.getText().toString().equals("") || pass.getText().toString().equals("")){
            Toast.makeText(this,"Please enter your information",Toast.LENGTH_LONG).show();
        }
        else{
            msg = "login-" + login.getText().toString() + "-" + pass.getText().toString();
            Log.d("Sdfa", "loginMethod1: "+ msg);
            ClientThread clt = new ClientThread("192.168.2.1",8001,msg);

            Log.d("Sdfa", "loginMethod2: "+ msg);
            clt.start();
            Log.d("Sdfa", "loginMethod3: "+ msg);

            if(Helper.raspunsLogin==true){
                Toast.makeText(this,"Te-ai logat",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this,"Cont gresit",Toast.LENGTH_LONG).show();
            }
        }*/
        if(login.getText().toString().equals("bogdan") || pass.getText().toString().equals("123")){
            Intent i = new Intent(this,Home.class);
            i.putExtra("Name",login.getText().toString());
            startActivity(i);
        }
    }

    public void goToRegister(View v){
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }
}