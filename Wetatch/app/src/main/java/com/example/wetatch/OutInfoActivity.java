package com.example.wetatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.INVISIBLE;
import static com.example.wetatch.StartSecondActivity.SWITCH_ATMOS;
import static com.example.wetatch.StartSecondActivity.SWITCH_WIND;
import static com.example.wetatch.StartSecondActivity.TEXT;

public class OutInfoActivity extends AppCompatActivity {
    String text;
    boolean atmos;
    boolean wind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_info);

        try {
            text = getIntent().getExtras().getString(TEXT);
            atmos = getIntent().getExtras().getBoolean(SWITCH_ATMOS);   //получаем состояние свитча из интерна
            wind = getIntent().getExtras().getBoolean(SWITCH_WIND);     //получаем состояние свитча из интерна
        } catch (NullPointerException e) {
            System.out.println("getIntent == null " + e);
        }

        //вывод названия города
        TextView textViewCityName = (TextView) findViewById(R.id.textViewCityName);
        textViewCityName.setText(text);

        //вывод данных о погоде
        TextView textViewTemperatureValue = (TextView) findViewById(R.id.textViewTemperatureValue);
        textViewTemperatureValue.setText("Данные о погоде города: ");
        textViewTemperatureValue.append(text);

        //вывод давления (если включен свитч)
        TextView textViewOutAtmos = (TextView) findViewById(R.id.textViewOutAtmos);
        if(atmos) {
            textViewOutAtmos.setVisibility(View.VISIBLE);
            textViewOutAtmos.setText("Данные о давлении города: ");
            textViewOutAtmos.append(text);
        } else {
            textViewOutAtmos.setVisibility(INVISIBLE);
        }

        //вывод направления ветра (если включен свитч)
        TextView textViewOutWind = (TextView) findViewById(R.id.textViewOutWind);
        if(wind) {
            textViewOutWind.setVisibility(View.VISIBLE);
            textViewOutWind.setText("Данные о скорости ветра города: ");
            textViewOutWind.append(text);
        } else  {
            textViewOutWind.setVisibility(View.INVISIBLE);
        }
    }
}
