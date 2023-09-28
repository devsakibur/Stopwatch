package com.knackpark.stopwatch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;


public class customFragment extends Fragment {


    public customFragment() {}

    public  int seconds;
    private Handler handler;
    private Runnable runnable;
    private boolean isRunning = false;
    TextView dispay;
    EditText input;
    Button start;
    Button reset;
    Button pause;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom, container, false);


        input =view.findViewById(R.id.displayInput);
        dispay =  view.findViewById(R.id.display);
        start = view.findViewById(R.id.start);
        reset = view.findViewById(R.id.reset);
        pause = view.findViewById(R.id.pause);




        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
startCountdown();

            }
        });



        return view ;
    }


    private void startCountdown() {
        String secondsStr = input.getText().toString();
        if (secondsStr.isEmpty()) {
            return; // No input, do nothing
        }

        long totalSeconds = Long.parseLong(secondsStr) * 1000; // Convert to milliseconds
        new CountDownTimer(totalSeconds, 1000) {
            public void onTick(long millisUntilFinished) {
                long secondsRemaining = millisUntilFinished / 1000;
                updateCountdownUI(secondsRemaining);
            }

            public void onFinish() {
                updateCountdownUI(0);
            }
        }.start();
    }


    private void updateCountdownUI(long secondsRemaining) {
        int hours = (int) (secondsRemaining / 3600);
        int minutes = (int) ((secondsRemaining % 3600) / 60);
        int seconds = (int) (secondsRemaining % 60);

        String countdownText = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        dispay.setText(countdownText);
    }




}