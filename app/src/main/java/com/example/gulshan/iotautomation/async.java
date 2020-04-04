package com.example.gulshan.iotautomation;


import android.os.AsyncTask;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class async extends AsyncTask<String ,Void,Void> {

    Socket s;
    DataOutputStream dataOutputStream;
    PrintWriter printWriter;

    @Override
    protected Void doInBackground(String... voids) {
        String message = voids[0];
        try {
            Socket s = new Socket("192.168.4.1" , 80);
            printWriter = new PrintWriter(s.getOutputStream());

            printWriter.write(message);
            printWriter.flush();
            printWriter.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Sync Error", "doInBackground: SendError");
        }
        return null;
    }
}