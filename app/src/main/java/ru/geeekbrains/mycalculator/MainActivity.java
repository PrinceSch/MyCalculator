package ru.geeekbrains.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewFirst;
    TextView textViewOperation;
    TextView textViewSecond;
    private final static String keyNumbers = "numbers";
    static int theme = R.style.Theme_MyCalculator;

    CalculatorLogic calculatorLogic = new CalculatorLogic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewFirst = findViewById(R.id.text_view_first);
        textViewOperation = findViewById(R.id.text_view_operation);
        textViewSecond = findViewById(R.id.text_view_second);

        Button buttonSettings = findViewById(R.id.button_settings);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent runSettings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(runSettings);
            //как пересоздавать активити из другого? новый запуск? мой текущий вариант рабочий, но чую, что это костыль.
            }
        });

        Button button0 = findViewById(R.id.button_0);
        button0.setOnClickListener(v -> calculatorLogic.numberButton(button0,textViewSecond));

        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(v -> calculatorLogic.numberButton(button1,textViewSecond));

        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(v -> calculatorLogic.numberButton(button2,textViewSecond));

        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(v -> calculatorLogic.numberButton(button3,textViewSecond));

        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(v -> calculatorLogic.numberButton(button4,textViewSecond));

        Button button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(v -> calculatorLogic.numberButton(button5,textViewSecond));

        Button button6 = findViewById(R.id.button_6);
        button6.setOnClickListener(v -> calculatorLogic.numberButton(button6,textViewSecond));

        Button button7 = findViewById(R.id.button_7);
        button7.setOnClickListener(v -> calculatorLogic.numberButton(button7,textViewSecond));

        Button button8 = findViewById(R.id.button_8);
        button8.setOnClickListener(v -> calculatorLogic.numberButton(button8,textViewSecond));

        Button button9 = findViewById(R.id.button_9);
        button9.setOnClickListener(v -> calculatorLogic.numberButton(button9,textViewSecond));

        Button buttonDel = findViewById(R.id.button_delete);
        buttonDel.setOnClickListener(v -> calculatorLogic.clearButton(textViewSecond, textViewFirst, textViewOperation));

        Button buttonAdd = findViewById(R.id.button_addition);
        buttonAdd.setOnClickListener(v -> calculatorLogic.operatorButton(buttonAdd, textViewSecond, textViewFirst, textViewOperation));

        Button buttonSub = findViewById(R.id.button_subtraction);
        buttonSub.setOnClickListener(v -> calculatorLogic.operatorButton(buttonSub, textViewSecond, textViewFirst, textViewOperation));

        Button buttonMult = findViewById(R.id.button_multiplication);
        buttonMult.setOnClickListener(v -> calculatorLogic.operatorButton(buttonMult, textViewSecond, textViewFirst, textViewOperation));

        Button buttonDiv = findViewById(R.id.button_division);
        buttonDiv.setOnClickListener(v -> calculatorLogic.operatorButton(buttonDiv, textViewSecond, textViewFirst, textViewOperation));

        Button buttonAnswer = findViewById(R.id.button_answer);
        buttonAnswer.setOnClickListener(v -> calculatorLogic.answerButton(textViewSecond, textViewFirst, textViewOperation));

    }


    public static void setIntTheme(int theme) {
        MainActivity.theme = theme;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(keyNumbers,calculatorLogic);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculatorLogic = savedInstanceState.getParcelable(keyNumbers);
        //не могу сообразить, что дальше жедать с этим parcelable - данные сохраняются при повороте экрана, но не отображаются.
    }
}