package com.example.authapp;


import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientThread extends Thread {
    private String ipAddress;
    private int port;
    public String sendMsg;

    public ClientThread( String ip,int port,String sendMsg) {
        this.ipAddress = ip;
        this.port = port;
        this.sendMsg = sendMsg;
    }

    @Override
    public void run() {
        try {
            Socket clientSocket = new Socket(ipAddress, port);

            final String result = "true";
            Log.d("ttt", "run: " + result);
            if(result.contains("true")) Helper.raspunsLogin = true;
            else Helper.raspunsLogin = false;

        } catch (UnknownHostException unknownHostException) {
            Log.d("TAG", "run: nu merge 1");
        } catch (IOException ioException) {
            Log.d("TAG","run: nu merge 2");
        }
    }
}
