package com.mukesh.kanchan.scrollingtextledblock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class swirlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swirl);

        String message = ("Swirl");
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_swirl);
        layout.addView(textView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                int numOfDevices =2;
                LEDProcessor led = new LEDProcessor(numOfDevices);
                for (int i=0; i <numOfDevices; i++){
                    led.swirl(i+1);
                }
            }
        }).start();
    }
}
