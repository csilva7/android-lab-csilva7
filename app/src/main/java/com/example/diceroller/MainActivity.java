package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import java.util.Random;

public class MainActivity<rollTheDiceButton> extends AppCompatActivity {

    Button rollDiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollDiceButton = (Button) findViewById(R.id.rollTheDiceButton);

        rollDiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView randomNumber;
                randomNumber = (TextView) findViewById(R.id.randomNumberTextView);
                Random r = new Random();
                int min = 1;
                int max = 6;
                int number = r.nextInt((max - min)+1)+min;
                randomNumber.setText(Integer.toString(number));

            }
        });


    }
}
