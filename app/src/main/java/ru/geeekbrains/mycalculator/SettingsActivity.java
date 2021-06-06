package ru.geeekbrains.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(MainActivity.theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button button_light = findViewById(R.id.button_light);
        initThemeButton(button_light, R.style.Theme_MyCalculator);
        Button button_dark = findViewById(R.id.button_dark);
        initThemeButton(button_dark, R.style.Custom);
    }

    private void initThemeButton (View button, final int codeStyle){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setIntTheme(codeStyle);
                recreate();
            }
        });
    }


}
