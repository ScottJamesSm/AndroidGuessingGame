package com.example.scottsmith.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private Button guessButton;
    private TextView clue;
    private EditText guess;

    private int generatedNumber;
    private int numberOfGuesses = 0;
    private final int MAX_GUESS_COUNT = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        guessButton = findViewById(R.id.submitguessbutton);
        clue = findViewById(R.id.clue_textview);
        guess = findViewById(R.id.guess_edittext);

        generatedNumber = (int) Math.ceil(Math.random() * 100);
        setListener();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setContentView(R.layout.activity_game);


        generatedNumber = (int) Math.ceil(Math.random() * 100);
    }

    private void setListener() {
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateGuess();
            }
        });
    }

    private void validateGuess() {


    }

    private void checkGuess(int userGuess) {
        //tod
        if (userGuess == generatedNumber) {

        } else if (numberOfGuesses == MAX_GUESS_COUNT) {
Intent loser = new Intent(this, ResultsActivity.class);
        } else if (userGuess < generatedNumber) {

            clue.setText(R.string.higher);
            clue.setVisibility(View.VISIBLE);
            guess.setText("");
                    numberOfGuesses++;

            } else if (userGuess > generatedNumber) {
            clue.setText("lower");
            clue.setVisibility(View.VISIBLE);
            guess.setText("");
            numberOfGuesses++;
            }

        }
    }

