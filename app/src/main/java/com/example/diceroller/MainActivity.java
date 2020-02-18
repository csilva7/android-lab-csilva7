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

    int Score = 0;

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

    }
        public void roll_the_dice (){
            TextView randomNumber = (TextView) findViewById(R.id.randomNumberTextView);
            //randomNumber = (TextView) findViewById(R.id.randomNumberTextView);
            Random r = new Random();
            int min = 1;
            int max = 6;
            int number = r.nextInt((max - min) + 1) + min;
            randomNumber.setText(Integer.toString(number));
        }

        public void on_button_click(View v) {

            roll_the_dice();
            TextView stringNumber = (TextView) findViewById(R.id.randomNumberTextView);
            int number = Integer.valueOf(stringNumber.getText().toString());
            TextView congratsMessage = (TextView) findViewById(R.id.congratulationsTextView);
            if (UserNumber == number) {
                congratsMessage.setText("Congratulations!");
                Score = Score + 1;
                TextView currentScore;
                currentScore = (TextView) findViewById(R.id.scoreTextView);
                currentScore.setText(Integer.toString(Score));
                Log.d("DiceRoller", "Your score is: " + Score);
            } else {
                congratsMessage.setText("Unlucky :(");
            }


        }

        public void iceBreakers(View view) {
        roll_the_dice();
        TextView stringNumber = (TextView) findViewById(R.id.randomNumberTextView);
        int number = Integer.valueOf(stringNumber.getText().toString());
        TextView icebreakerQuestion = (TextView) findViewById(R.id.randomQuestionTextView);
        if(number == 1)
        {
            icebreakerQuestion.setText("If you could go anywhere in the world, where would you go?");
        }
        else if(number == 2)
        {
            icebreakerQuestion.setText("If you were stranded on a desert island, what three things would you want to take with you?");
        }
        else if(number == 3)
        {
            icebreakerQuestion.setText("If you could eat only one food for the rest of your life, what would that be?");
        }
        else if(number == 4)
        {
            icebreakerQuestion.setText("If you won a million dollars, what is the first thing you would buy?");
        }
        else if(number == 5)
        {
            icebreakerQuestion.setText("If you could spaned the day with one fictional character, who would it be?");
        }
        else if (number == 6)
        {
            icebreakerQuestion.setText("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
        }


        }
}
