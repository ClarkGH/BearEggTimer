package com.example.clarkhinchcliff.beareggtimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.TestMethod;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timerSeekbar = (SeekBar)findViewById(R.id.timerSeekBar);
        final TextView timerTextview = (TextView)findViewById(R.id.textView);

        timerSeekbar.setMax(600);
        timerSeekbar.setProgress(30);

        timerSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int minutes = (int) progress/60;
                int seconds = (int) progress - minutes * 60;

                String secondsString = Integer.toString(seconds);

                if (secondsString == "0") {
                    secondsString = "00";
                }

                timerTextview.setText(Integer.toString(minutes) + ":" + secondsString));
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
