package com.example.wetatch;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainNavigator {

    private StartAppFragment startAppFragment;
    private OutInfoFragment outInfoFragment;
    private HistoryFragment historyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ActualChoiceState("", false, false);  //первая активация статиков состояний

        startAppFragment = new StartAppFragment();
        outInfoFragment = new OutInfoFragment();
        historyFragment = new HistoryFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // добавить фрагмент
        fragmentTransaction.add(R.id.cities, startAppFragment);
        // закрыть транзакцию
        fragmentTransaction.commit();
    }

    @Override
    public void startOutInfoFragment(String shape) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(startAppFragment);

        // добавить фрагмент
        fragmentTransaction.add(R.id.cities, outInfoFragment);
        fragmentTransaction.addToBackStack("");                     //??зачем ??

        // закрыть транзакцию
        fragmentTransaction.commit();

//        outInfoFragment.setShape(shape);    //shape - передаваемые параметры
    }

    @Override
    public void startHistoryFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(startAppFragment);

        // добавить фрагмент
        fragmentTransaction.add(R.id.cities, historyFragment);
        fragmentTransaction.addToBackStack("");                     //??зачем ??

        // закрыть транзакцию
        fragmentTransaction.commit();

//        historyFragment.setShape(shape);
    }
}
