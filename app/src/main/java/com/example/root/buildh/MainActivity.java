package com.example.root.buildh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
    }



    public void tellJoke(View view) {
//        progressBar.setVisibility(View.VISIBLE);
        com.example.root.buildh.JokeLoader jokeLoader  =
                new com.example.root.buildh.JokeLoader(this);
        jokeLoader.execute();
        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
    }
}
