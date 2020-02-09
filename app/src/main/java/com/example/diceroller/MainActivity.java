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

    int enterNumber;

    TextView numberInputted;

    EditText numberInputEditText;

    Button submitNumberButton;

    int UserNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitNumberButton = (Button) findViewById(R.id.submitButton);
        submitNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputEditText = (EditText) findViewById(R.id.numberInput);
                UserNumber = Integer.valueOf(numberInputEditText.getText().toString());
                numberInputted = (TextView) findViewById(R.id.numberInputtedTextView);
                numberInputted.setText("You entered: " + UserNumber);

                Log.d("DiceRoller", "Your entered number is: " + UserNumber);
            }
            });

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
                TextView congratsMessage;
                congratsMessage = (TextView) findViewById(R.id.congratulationsTextView);
                if(UserNumber == number)
                {
                    congratsMessage.setText("Congratulations!");
                }
                else
                {
                    congratsMessage.setText("Unlucky :(");
                }

            }
        });


    }
}
