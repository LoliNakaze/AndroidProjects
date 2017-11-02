package com.example.gluong.helloworld;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.buttonTest);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                /*
                final TextView test = (TextView) findViewById(R.id.textView4);
                test.setVisibility(View.VISIBLE);
                */

                // Don't forget to declare the activity in the manifest.
                Intent i = new Intent(MainActivity.this, AnotherActivity.class);
                i.putExtra("test", "Activity has been started !");
                startActivity(i);

               // startActivity(new Intent(MainActivity.this, MainActivity.class));

                /*
                final Button buttonHide = (Button) findViewById(R.id.buttonHide);
                buttonHide.setVisibility(View.VISIBLE);
                buttonHide.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Code here executes on main thread after user presses button
                        test.setVisibility(View.INVISIBLE);
                        buttonHide.setVisibility(View.INVISIBLE);
                    }
                });
                */
            }
        });
    }
}


