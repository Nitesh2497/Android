package com.example.async;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Async";

    Button start;
    Button random;
    TextView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.BtnStart);
        random = findViewById(R.id.BtnRandom);
        counter = findViewById(R.id.tvCounter);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Counter counter = new Counter();
                counter.execute(5);
            }
        });

        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random1 = new Random();
                counter.setText(String.valueOf(random1.nextInt(100)));
            }
        });
    }
    
    class Counter extends AsyncTask<Integer,Integer,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            Log.d(TAG, "doInBackground: Counter Started");
            Integer n = integers[0];
            for(int i=0;i<n;i++){
                wait1sec();
                publishProgress(i);
            }
            Log.d(TAG, "doInBackground: Counter Ended");
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            counter.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

    }

    void wait1sec(){
        long startTime =  System.currentTimeMillis();
        while (System.currentTimeMillis()<startTime+1000);
    }
}


