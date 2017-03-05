package com.mukesh.kanchan.scrollingtextledblock;

import android.util.Log;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayLEDMessageActivity extends AppCompatActivity {
    private static final String TAG = "DisplayLED";

    LEDProcessor led;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_ledmessage);

        Intent intent = getIntent();
        final String displayTxt = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String message = ("Displayed: ").concat(displayTxt);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_ledmessage);
        layout.addView(textView);

        int numOfDevices = 2;
        led = new LEDProcessor(numOfDevices);
        new Thread(new Runnable() {
                @Override
                public void run() {
                long delayTime = (long) 0.05;
                if (displayTxt.length() != 0) {
                    String scrollTxt = displayTxt.toUpperCase();
                    for (int i = 0; i < scrollTxt.length(); i++) {
                        if (i == 0) {
                            led.printLetter(' ', true, 1);
                            if (Character.isDigit(scrollTxt.charAt(i)))
                                led.printNumber(scrollTxt.charAt(i), 2);
                            else
                                led.printLetter(scrollTxt.charAt(i), true, 2);
                            try {
                                Thread.sleep(delayTime);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        } else if (i == scrollTxt.length()) {
                            if (Character.isDigit(scrollTxt.charAt(i-1)))
                                led.printNumber(scrollTxt.charAt(i-1), 1);
                            else
                                led.printLetter(scrollTxt.charAt(i-1), true, 1);
                            led.printLetter(' ', true, 2);
                            try {
                                Thread.sleep(delayTime);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            if (Character.isDigit(scrollTxt.charAt(i-1)))
                                led.printNumber(scrollTxt.charAt(i-1), 1);
                            else
                                led.printLetter(scrollTxt.charAt(i-1), true, 1);
                            if (Character.isDigit(scrollTxt.charAt(i)))
                                led.printNumber(scrollTxt.charAt(i), 2);
                            else
                                led.printLetter(scrollTxt.charAt(i), true, 2);
                            try {
                                Thread.sleep(delayTime);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        led.printLetter(' ', true, 1);
                    }
                 led.clearDisplays();
                }
            }
        }).start();
    }
}
