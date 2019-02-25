package com.example.wetatch;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class StartSecondActivity implements View.OnClickListener{
    public final static String TEXT = "Введите город";

    private Activity sourceActivity;

    public StartSecondActivity(Activity sourceActivity) {
        this.sourceActivity = sourceActivity;
    }

    @Override
    public void onClick(View v) {
        EditText txt = (EditText) sourceActivity.findViewById(R.id.editTextCityName);
        Intent intent = new Intent(sourceActivity, OutInfoActivity.class);
        intent.putExtra(TEXT, txt.getText().toString());
        sourceActivity.startActivity(intent);
    }
}
