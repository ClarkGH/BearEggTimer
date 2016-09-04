package com.example.clarkhinchcliff.beareggtimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.TestMethod;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar timerSeekbar;
    TextView timerTextview;

    public void updateTimer(int secondsLeft){
        int minutes = (int) secondsLeft/60;
        int seconds = (int) secondsLeft - minutes * 60;

        String secondsString = Integer.toString(seconds);

        if(seconds <= 9){
            secondsString = "0" + secondsString;
        }

        timerTextview.setText(Integer.toString(minutes) + ":" + secondsString);
    }

    public void toggleTimer(View view) {
        new CountDownTimer(timerSeekbar.getProgress() * 1000, 1000) {

            @Override
            public void onTick(long milliSecLeft) {
                updateTimer((int)milliSecLeft / 1000);
            }

            @Override
            public void onFinish() {
                timerTextview.setText("0:00");
                Log.i("books", "cooks");
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekbar = (SeekBar)findViewById(R.id.timerSeekBar);
        timerTextview = (TextView)findViewById(R.id.textView);

        timerSeekbar.setMax(600);
        timerSeekbar.setProgress(30);

        timerSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
