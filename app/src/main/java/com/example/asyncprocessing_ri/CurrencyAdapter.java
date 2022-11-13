package com.example.asyncprocessing_ri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyViewHolder> {

    ArrayList<Currency> currencies;
    Context context;

    public CurrencyAdapter(ArrayList<Currency> currencies, Context context) {
        this.currencies = currencies;
        this.context = context;
    }

    @NonNull
    @Override
    public CurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View currencyView = inflater.
                                inflate(R.layout.list_item,
                                        parent,
                                        false);

        return new CurrencyViewHolder(currencyView);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyViewHolder holder, int position) {

        holder.currencyName.setText(currencies.get(position).currency);
        holder.currencyRate.setText(currencies.get(position).rate);

    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }
}
