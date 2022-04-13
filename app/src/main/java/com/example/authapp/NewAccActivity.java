package com.example.authapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class NewAccActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_acc);



    }

    public void buttonclick(View v){
        TextView name = findViewById(R.id.nameTextView);
        TextView mail = findViewById(R.id.mailTextView);
        TextView pass = findViewById(R.id.passTextView);
        if(name.getText().toString().equals("") || mail.getText().toString().equals("") || pass.getText().toString().equals("")){
            Toast.makeText(this,"Please enter your information",Toast.LENGTH_LONG).show();
        } else {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("Name", name.getText().toString());
            setResult(RESULT_CANCELED,returnIntent);
            finish();
        }

    }
}