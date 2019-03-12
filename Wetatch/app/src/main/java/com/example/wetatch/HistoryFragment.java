package com.example.wetatch;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {
    private View viewInflater;              //ссылка на рабочий макет фрагмента истории 3
    private RecyclerView recyclerView;
    private String[] data = {"-1", "-2", "-3", "-4"};       //тестовые данные

    //Фабричный метод create создает фрагмент
    public static HistoryFragment create() {
        HistoryFragment f = new HistoryFragment();      //создание
        return f;
    }

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.viewInflater = inflater.inflate(R.layout.fragment_history, container, false);
        this.recyclerView = viewInflater.findViewById(R.id.recycler_view);
        return this.viewInflater;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // эта установка служит для повышения производительности системы.
        this.recyclerView.setHasFixedSize(true);

        // будем работать со встроенным менеджером
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // Установим адаптер
        HistoryAdapter adapter = new HistoryAdapter(this.data);
        recyclerView.setAdapter(adapter);
    }
}
