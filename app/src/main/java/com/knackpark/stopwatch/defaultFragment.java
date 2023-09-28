package com.knackpark.stopwatch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class defaultFragment extends Fragment {
    public  int seconds = 0;
    private Handler handler;
    private Runnable runnable;
    private boolean isRunning = false;
    TextView sec;
    Button start;
    Button reset;
    Button pause;
    public defaultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_default, container, false);

        sec =  view.findViewById(R.id.second);
        start = view.findViewById(R.id.start);
        reset = view.findViewById(R.id.reset);
        pause = view.findViewById(R.id.pause);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (isRunning) {
                    seconds++;
                    updateTimerUI();
                }
                handler.postDelayed(this, 1000);
            }
        };


       start.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startStopwatch();
           }
       });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopStopwatch();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetStopwatch();
            }
        });



        return view;

    }




    private void startStopwatch() {
        isRunning = true;
        start.setEnabled(false);
        pause.setEnabled(true);
        reset.setEnabled(false);
        handler.post(runnable);
    }

    private void stopStopwatch() {
        isRunning = false;
        start.setEnabled(true);
        pause.setEnabled(false);
        reset.setEnabled(true);
        handler.removeCallbacks(runnable);
    }

    private void resetStopwatch() {
        isRunning = false;
        seconds = 0;
        updateTimerUI();
        start.setEnabled(true);
        pause.setEnabled(false);
        reset.setEnabled(false);
    }

    private void updateTimerUI() {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        String timeString = String.format("%02d:%02d:%02d", hours, minutes, secs);
        sec.setText(timeString);
    }







}