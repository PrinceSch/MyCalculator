package ru.geeekbrains.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewFirst;
    private TextView textViewOperation;
    private TextView textViewSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewFirst = findViewById(R.id.text_view_first);
        textViewOperation = findViewById(R.id.text_view_operation);
        textViewSecond = findViewById(R.id.text_view_second);

        Button button0 = findViewById(R.id.button_0);
        button0.setOnClickListener(v -> textViewFirst.setText(button0.getText()));

        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(v -> textViewFirst.setText(button1.getText()));

        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(v -> textViewFirst.setText(button2.getText()));

        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(v -> textViewFirst.setText(button3.getText()));

        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(v -> textViewFirst.setText(button4.getText()));

        Button button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(v -> textViewFirst.setText(button5.getText()));

        Button button6 = findViewById(R.id.button_6);
        button6.setOnClickListener(v -> textViewFirst.setText(button6.getText()));

        Button button7 = findViewById(R.id.button_7);
        button7.setOnClickListener(v -> textViewFirst.setText(button7.getText()));

        Button button8 = findViewById(R.id.button_8);
        button8.setOnClickListener(v -> textViewFirst.setText(button8.getText()));

        Button button9 = findViewById(R.id.button_9);
        button9.setOnClickListener(v -> textViewFirst.setText(button9.getText()));

        Button buttonDel = findViewById(R.id.button_delete);
        buttonDel.setOnClickListener(v -> textViewFirst.setText(buttonDel.getText()));

        Button buttonAdd = findViewById(R.id.button_addition);
        buttonAdd.setOnClickListener(v -> textViewFirst.setText(buttonAdd.getText()));

        Button buttonSub = findViewById(R.id.button_subtraction);
        buttonSub.setOnClickListener(v -> textViewFirst.setText(buttonSub.getText()));

        Button buttonMult = findViewById(R.id.button_multiplication);
        buttonMult.setOnClickListener(v -> textViewFirst.setText(buttonMult.getText()));

        Button buttonDiv = findViewById(R.id.button_division);
        buttonDiv.setOnClickListener(v -> textViewFirst.setText(buttonDiv.getText()));

        Button buttonAnswer = findViewById(R.id.button_answer);
        buttonAnswer.setOnClickListener(v -> textViewFirst.setText(buttonAnswer.getText()));


    }


}