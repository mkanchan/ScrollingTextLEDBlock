package com.mukesh.kanchan.scrollingtextledblock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.mukesh.kanchan.scollingtextledblock.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** Called when the user clicks the Display button */
    public void displayMessage(View view) {
        Intent intent = new Intent(this, DisplayLEDMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    /** Called when the user clicks the Play Dice Game button */
    public void playDiceGame(View view) {
        Intent intent = new Intent(this, PlayDiceGameActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "Dice Game ON");
        startActivity(intent);
    }

    /** Called when the user clicks the All On Off button */
    public void allOnOff(View view) {
        Intent intent = new Intent(this, allOnOffActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "all ON OFF");
        startActivity(intent);
    }
    /** Called when the user clicks the Swirl button */
    public void swirl(View view) {
        Intent intent = new Intent(this, swirlActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "Swirl...");
        startActivity(intent);
    }
    /** Called when the user clicks the Diagonal button */
    public void diagonal(View view) {
        Intent intent = new Intent(this, diagonalActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "Diagonal....");
        startActivity(intent);
    }
    /** Called when the user clicks the Sixty four button */
    public void sixtyFour(View view) {
        Intent intent = new Intent(this, sixtyFourActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "sixty Four....");
        startActivity(intent);
    }
}
