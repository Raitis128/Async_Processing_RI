package com.example.asyncprocessing_ri;

import android.os.AsyncTask;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

public class DataLoader extends AsyncTask<ArrayList<Currency>, Void, ArrayList<Currency>> {

    @SafeVarargs
    protected final ArrayList<Currency> doInBackground(ArrayList<Currency>... params) {

        ArrayList<Currency> asyncList = new ArrayList<>();

        try {
            asyncList = DataManager.getRateFromECB();
            return asyncList;
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            return asyncList;
        }
    }
}