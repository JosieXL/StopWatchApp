package com.example.stopwatchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchAct extends AppCompatActivity {

    Button buttonStart, buttonStop;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timeHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        icanchor = findViewById(R.id.icanchor);
        timeHere = findViewById(R.id.timeHere);

        // create optional animation
        buttonStop.setAlpha(0);

        // load animation
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // passing animation
                icanchor.startAnimation(roundingalone);
                buttonStop.animate().alpha(1).translationY(-80).setDuration(300).start();
                buttonStart.animate().alpha(0).setDuration(300).start();
                // start time
                timeHere.setBase(SystemClock.elapsedRealtime());
                timeHere.start();
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // passing animation
                icanchor.clearAnimation();
                buttonStop.animate().alpha(0).translationY(-80).setDuration(300).start();
                buttonStart.animate().alpha(1).setDuration(300).start();
                // start time
                timeHere.stop();
            }
        });
    }
}