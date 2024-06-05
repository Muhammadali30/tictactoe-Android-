package com.example.myapplication;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class tictac extends AppCompatActivity {
    private char sign = 'X';
    private Button[] buttons;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictac);
        getSupportActionBar().hide();

        final Button btn1 = findViewById(R.id.b1);
        final Button btn2 = findViewById(R.id.b2);
        final Button btn3 = findViewById(R.id.b3);
        final Button btn4 = findViewById(R.id.b4);
        final Button btn5 = findViewById(R.id.b5);
        final Button btn6 = findViewById(R.id.b6);
        final Button btn7 = findViewById(R.id.b7);
        final Button btn8 = findViewById(R.id.b8);
        final Button btn9 = findViewById(R.id.b9);
        final Button resetButton = findViewById(R.id.reset);
        final TextView txt = findViewById(R.id.text);

        buttons = new Button[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign = 'X';
                count=0;
                txt.setText("");
                for (Button button : buttons) {
                    button.setText("");
                    button.setBackgroundColor(Color.BLUE);
                    button.setEnabled(true);
                }
            }
        });

        for (final Button button : buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onButtonClick(button);
                }
            });
        }
    }

    private void onButtonClick(Button button) {
        if (sign == 'X') {
            button.setText("X");
            button.setBackgroundColor(Color.RED);
            sign = 'O';
        } else {
            button.setText("O");
            button.setBackgroundColor(Color.GREEN);
            sign = 'X';
        }
        button.setEnabled(false);
        check();
    }

    private void check() {
        count++;
        if ((buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X"))
                || (buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X"))
                || (buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X"))
                || (buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X"))
                || (buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X"))
                || (buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X"))
                || (buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X"))
                || (buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X"))) {
            displayWinner("Player 'X' Won the Match");
        } else if ((buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O"))
                || (buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O"))
                || (buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O"))
                || (buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O"))
                || (buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O"))
                || (buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O"))
                || (buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O"))
                || (buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O"))) {
            displayWinner("Player 'O' Won the match");
        } else if (count==9) {
            displayWinner("Draw");
        }
    }

    private void displayWinner(String message) {
        TextView txt = findViewById(R.id.text);
        txt.setText(message);
        for (Button button : buttons) {
            button.setEnabled(false);
        }

    }
}