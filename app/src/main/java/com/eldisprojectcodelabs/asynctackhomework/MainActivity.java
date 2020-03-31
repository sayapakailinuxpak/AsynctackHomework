package com.eldisprojectcodelabs.asynctackhomework;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textViewStatus;
    Button buttonStartTask;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewStatus = findViewById(R.id.textview_status);
        buttonStartTask = findViewById(R.id.button_start_task);
        progressBar = findViewById(R.id.progress_bar);

        buttonStartTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressAsynctask progressAsynctask = new ProgressAsynctask(textViewStatus, progressBar);
                progressAsynctask.execute();
            }
        });
    }


}
