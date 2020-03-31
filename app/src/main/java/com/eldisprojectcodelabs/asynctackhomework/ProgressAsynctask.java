package com.eldisprojectcodelabs.asynctackhomework;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class ProgressAsynctask extends AsyncTask<Integer, Integer, String> {
    private WeakReference<TextView> textViewWeakReference;
    private WeakReference<ProgressBar> progressBarWeakReference;

    ProgressAsynctask(TextView textView, ProgressBar progressBar) {
        textViewWeakReference = new WeakReference<>(textView);
        progressBarWeakReference = new WeakReference<>(progressBar);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textViewWeakReference.get().setText("Napping");
        progressBarWeakReference.get().setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(Integer... integers) {
        int minValue = 0;
        int maxValue = 100;
        int i;
        for (i = minValue; i <= maxValue; i+=10){
            try{
                Thread.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            publishProgress(i);
        }


        return "Download Complete!";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressBarWeakReference.get().setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(String result){
        super.onPostExecute(result);
        textViewWeakReference.get().setText(result);
    }
}
