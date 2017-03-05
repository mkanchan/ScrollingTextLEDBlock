package com.mukesh.kanchan.scrollingtextledblock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

public class PlayDiceGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_dice_game);

        String message = ("Play dice game");
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_play_dice_game);
        layout.addView(textView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                int numOfDevices =2;
                LEDProcessor led = new LEDProcessor(numOfDevices);
                Random rand = new Random();
                int max = 6;
                int min = 1;
                for (int i=0; i <numOfDevices; i++){
                    int randomNum = min + rand.nextInt((max - min) + 1);
                    led.printDice(randomNum,  i+1);
                }
            }
        }).start();
    }

}
