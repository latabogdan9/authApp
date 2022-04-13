package com.example.authapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Home extends AppCompatActivity {
    public static int timerRunning=0;
    public static int counter = 30;
    public int resetCode(){
        int r=0;
        Random rand = new Random();
        for(int i=0;i<6;i++) {
            r = r * 10 + rand.nextInt(10);
            while(i==0 && r==0)
                r = r * 10 + rand.nextInt(10);
        }
        return r;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String s = data.getStringExtra("Name");
        change(s);
    }
    public void change(String s){
        Button b1 = findViewById(R.id.button9);
        Button b2 = findViewById(R.id.button10);
        Button b3 = findViewById(R.id.button11);
        Button b4 = findViewById(R.id.button12);
        Button b5 = findViewById(R.id.button13);
        Button b6 = findViewById(R.id.button14);
        Button b7 = findViewById(R.id.button15);
        Button b8 = findViewById(R.id.button16);
        Button b9 = findViewById(R.id.button17);
        Button b10 = findViewById(R.id.button18);
        Button b11 = findViewById(R.id.button19);
        Button b12 = findViewById(R.id.button20);

        if(b2.getVisibility()== View.INVISIBLE && b1.getVisibility()==View.VISIBLE){
            b1.setText(s);
            b2.setVisibility(View.VISIBLE);
        } else if(b3.getVisibility()== View.INVISIBLE && b2.getVisibility()==View.VISIBLE){
            b2.setText(s);
            b3.setVisibility(View.VISIBLE);
        } else if(b4.getVisibility()== View.INVISIBLE && b3.getVisibility()==View.VISIBLE){
            b3.setText(s);
            b4.setVisibility(View.VISIBLE);
        } else if(b5.getVisibility()== View.INVISIBLE && b4.getVisibility()==View.VISIBLE){
            b4.setText(s);
            b5.setVisibility(View.VISIBLE);
        } else if(b6.getVisibility()== View.INVISIBLE && b5.getVisibility()==View.VISIBLE){
            b5.setText(s);
            b6.setVisibility(View.VISIBLE);
        } else if(b7.getVisibility()== View.INVISIBLE && b6.getVisibility()==View.VISIBLE){
            b6.setText(s);
            b7.setVisibility(View.VISIBLE);
        } else if(b8.getVisibility()== View.INVISIBLE && b7.getVisibility()==View.VISIBLE){
            b7.setText(s);
            b8.setVisibility(View.VISIBLE);
        } else if(b9.getVisibility()== View.INVISIBLE && b8.getVisibility()==View.VISIBLE){
            b8.setText(s);
            b9.setVisibility(View.VISIBLE);
        } else if(b10.getVisibility()== View.INVISIBLE && b9.getVisibility()==View.VISIBLE){
            b9.setText(s);
            b10.setVisibility(View.VISIBLE);
        } else if(b11.getVisibility()== View.INVISIBLE && b10.getVisibility()==View.VISIBLE){
            b10.setText(s);
            b11.setVisibility(View.VISIBLE);
        } else if(b12.getVisibility()== View.INVISIBLE && b11.getVisibility()==View.VISIBLE){
            b11.setText(s);
            b12.setVisibility(View.VISIBLE);
        } else b12.setText(s);

    }
    public void accountButton(View v){
        Button b = (Button)v;
        if(b.getText().toString().equals("+")){
            Intent i = new Intent(this,NewAccActivity.class);
            startActivityForResult(i,100);

        }
        else{
            TextView custom = findViewById(R.id.customTextView);
            TextView acces = findViewById(R.id.accesCodeTextView);
            if(timerRunning==1) {
                TextView tv7 = findViewById(R.id.textView7);
                TextView timerView = findViewById(R.id.timerTextView);

                timerRunning = 2;
                timerView.setVisibility(View.VISIBLE);
                acces.setVisibility(View.VISIBLE);
                custom.setVisibility(View.VISIBLE);
                tv7.setVisibility(View.VISIBLE);
            }
            acces.setText(Integer.toString(resetCode()));
            counter=31;
            custom.setText("Your access code for " + b.getText() + " is:");
        }
    }
    public void goToSettings(View v){
        Intent i = new Intent(this,SettingsActivity.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Intent i = getIntent();
        String name = i.getStringExtra("Name");

        TextView t = findViewById(R.id.textView2);
        t.setText("Hello, " + name + "!");

        TextView acces = findViewById(R.id.accesCodeTextView);
        acces.setText(Integer.toString(resetCode()));
        TextView timerView = findViewById(R.id.timerTextView);
        timerRunning=1;
        Timer timer = new Timer("TimerThread",true);

        timer.scheduleAtFixedRate(new TimerTask() {
                                      @Override
                                      public void run() {
                                          runOnUiThread(new Runnable() {
                                              @Override
                                              public void run() {
                                                  Home.counter--;
                                                  if(Home.counter==-1){
                                                      Home.counter=30;
                                                      acces.setText(Integer.toString(resetCode()));

                                                  }
                                                  timerView.setText(Integer.toString(Home.counter));
                                              }
                                          });
                                      }
                                  },
                0, 1000);

    }
}