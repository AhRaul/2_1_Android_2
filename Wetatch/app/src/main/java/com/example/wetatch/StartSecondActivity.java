package com.example.wetatch;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class StartSecondActivity implements View.OnClickListener{
    //кючевые слова интентов
    public final static String TEXT = "TEXT";
    public final static String SWITCH_ATMOS = "ATMOS";
    public final static String SWITCH_WIND = "WIND";

    private Activity sourceActivity;

    public StartSecondActivity(Activity sourceActivity) {
        this.sourceActivity = sourceActivity;
    }

    @Override
    public void onClick(View v) {
        EditText txt = (EditText) sourceActivity.findViewById(R.id.editTextCityName);
        Switch switchAtmos = (Switch)sourceActivity.findViewById(R.id.switchAtmos);     //состояние свича атмосфера
        Switch switchWind = (Switch)sourceActivity.findViewById(R.id.switchWind);       //состояние свича ветер
        Intent intent = new Intent(sourceActivity, OutInfoActivity.class);
        intent.putExtra(TEXT, txt.getText().toString());
        intent.putExtra(SWITCH_ATMOS, switchAtmos.isChecked());                         //занесение состояния свитча в интент
        intent.putExtra(SWITCH_WIND, switchWind.isChecked());                           //занесение состояния свитча в интент
        sourceActivity.startActivity(intent);
    }
}
