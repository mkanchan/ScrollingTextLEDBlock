package com.mukesh.kanchan.scrollingtextledblock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class allOnOffActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_on_off);

        String message = ("All On Off");
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_all_on_off);
        layout.addView(textView);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int numOfDevices = 2;
                LEDProcessor led = new LEDProcessor(numOfDevices);
                for (int i = 0; i < numOfDevices; i++) {
                    led.allOnOff(i + 1);
                }
            }
        }).start();
    }
}
