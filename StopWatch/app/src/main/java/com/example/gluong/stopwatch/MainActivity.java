package com.example.gluong.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Handler handler;
    private boolean isRunning;
    private long startTime = 0;
    private MyClockView clock;
    private Runnable refresh = () -> {
        update();
        if (isRunning)
            handler.postDelayed(this.refresh, 500);
    };

    private void update() {
        long time = (System.nanoTime() - startTime) / 1_000_000_000;
        ((TextView) findViewById(R.id.timeDisplay)).setText(time/60 + " : "  + time%60);
        clock.setElapsedTime(time);
    }

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        if (b != null) {
            startTime = b.getLong("startTime");
            isRunning = b.getBoolean("active");
        }

        handler = new Handler();
        clock = (MyClockView) findViewById(R.id.clock);

        Button start = (Button) findViewById(R.id.startButton);
        Button stop = (Button) findViewById(R.id.stopButton);

        start.setOnClickListener(v -> {
            isRunning = true;
            startTime = System.nanoTime();
            handler.post(refresh);
        });

        stop.setOnClickListener(v -> {
            isRunning = false;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.post(refresh);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(refresh);
    }

    @Override
    protected void onSaveInstanceState(Bundle b) {
        super.onSaveInstanceState(b);
        b.putLong("startTime", startTime);
        b.putBoolean("active", isRunning);
    }
}
