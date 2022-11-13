package com.example.asyncprocessing_ri;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Currency> currencies = new ArrayList<>();
    com.example.asyncprocessing_ri.CurrencyAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new com.example.asyncprocessing_ri.DataLoader() {
            @Override
            protected void onPostExecute(ArrayList<Currency> currencies) {

                recyclerView = findViewById(R.id.recyclerView);
                adapter = new
                        com.example.asyncprocessing_ri.
                                CurrencyAdapter(currencies, getApplication());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(
                        new LinearLayoutManager(MainActivity.this));
            }
        }.execute(currencies);

    }
}