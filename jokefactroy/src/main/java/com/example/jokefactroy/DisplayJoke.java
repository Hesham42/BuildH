package com.example.jokefactroy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJoke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        String JokeResult = null;
        TextView textview = (TextView) findViewById(R.id.joke_text);

        Intent intent = getIntent();
        JokeResult = intent.getStringExtra("joke");

        if (JokeResult != null) {
            textview.setText(JokeResult);
        } else {
            textview.setText("Dig deeped, we gotta find the joke!");
        }
    }
}
