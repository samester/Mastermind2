package com.example.sam.mastermind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReglesActivity extends AppCompatActivity {

    TextView lesRegles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regles);
        lesRegles = (TextView) findViewById(R.id.lesRegles);
        lesRegles.setText("Not Yet Implemented");
    }
}
