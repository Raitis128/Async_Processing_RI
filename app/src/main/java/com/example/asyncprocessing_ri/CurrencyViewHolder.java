package com.example.asyncprocessing_ri;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CurrencyViewHolder extends RecyclerView.ViewHolder {

    TextView currencyName;
    TextView currencyRate;
    CurrencyViewHolder(View itemView) {

        super(itemView);

        currencyName = itemView
                .findViewById(R.id.tvCurrencyName);
        currencyRate = itemView
                .findViewById(R.id.tvCurrencyRate);
    }
  }
