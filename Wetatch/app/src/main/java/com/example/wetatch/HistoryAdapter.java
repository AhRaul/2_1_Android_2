package com.example.wetatch;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>  {
    private String[] data;

    // Передаем в конструктор источник данных
    // В нашем случае это массив, но может быть и запросом к БД
    public HistoryAdapter(String[] data) {
        this.data = data;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        // Каждый пункт списка в нашем случае это строка
        public TextView textView;

        public ViewHolder(@NonNull TextView itemView) {
            super(itemView);
            textView = itemView;
        }
    }

    // Создать новый элемент пользовательского интерфейса
    // Запускается менеджером
    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);
        ViewHolder vh = new ViewHolder((TextView) v);
        return vh;
    }

    // Заменить данные в пользовательском интерфейсе
    // Вызывается менеджером
    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder viewHolder, int i) {
    // Получить элемент из источника данных (БД, интернет...)
    // Вынести на экран используя ViewHolder
        viewHolder.textView.setText(data[i]);
    }

    // Вернуть размер данных, вызывается менеджером
    @Override
    public int getItemCount() {
        return this.data.length;
    }
}
