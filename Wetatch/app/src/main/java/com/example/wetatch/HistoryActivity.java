package com.example.wetatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE) {
            // Если устройство перевернули в альбомную ориентацию, то Activity надо закрыть
            finish();
            return;
        }

        if (savedInstanceState == null) {
            // Если Activity запускается первый раз
            // то добавим фрагмент в Activity
            HistoryFragment details = new HistoryFragment();

            //добавим фрагмент в активити                       //?? как работает ??
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, details).commit();
        }
    }

}
