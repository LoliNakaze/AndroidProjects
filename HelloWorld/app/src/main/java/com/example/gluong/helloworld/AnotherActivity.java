package com.example.gluong.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by gluong on 09/10/17.
 */

public class AnotherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity);

        final TextView testView = (TextView) findViewById(R.id.testText);
        testView.setText(getIntent().getStringExtra("test"));
    }
}

