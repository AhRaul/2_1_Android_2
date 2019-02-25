package com.example.wetatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.wetatch.StartSecondActivity.TEXT;

public class OutInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_info);

        String text = getIntent().getExtras().getString(TEXT);

        //вывод названия города
        TextView textViewCityName = (TextView) findViewById(R.id.textViewCityName);
        textViewCityName.setText(text);

        //вывод данных о погоде
        TextView textViewTemperatureValue = (TextView) findViewById(R.id.textViewTemperatureValue);
        textViewTemperatureValue.setText("Данные о погоде города: ");
        textViewTemperatureValue.append(text);
    }
}
