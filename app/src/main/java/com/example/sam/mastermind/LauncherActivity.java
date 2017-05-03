package com.example.sam.mastermind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LauncherActivity extends AppCompatActivity {

    Button go;
    Button regle;
    ImageView image;
    int i =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        image = (ImageView) findViewById(R.id.accueil);
        image.setImageResource(R.drawable.rouge);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch(i)
                {
                    case 0: image.setImageResource(R.drawable.rouge);
                        i++;
                        break;
                    case 1: image.setImageResource(R.drawable.blanc);
                        i++;
                        break;
                    case 2: image.setImageResource(R.drawable.bleu);
                        i++;
                        break;
                    case 3: image.setImageResource(R.drawable.jaune);
                        i++;
                        break;
                    case 4: image.setImageResource(R.drawable.orange);
                        i++;
                        break;
                    case 5: image.setImageResource(R.drawable.rose);
                        i++;
                        break;
                    case 6: image.setImageResource(R.drawable.vert);
                        i++;
                        break;
                    case 7: image.setImageResource(R.drawable.violet);
                        i = 0;
                        break;
                    default: image.setImageResource(R.drawable.rouge);
                        break;

                }

            }
        });

        go = (Button) findViewById(R.id.lancerPartie);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LauncherActivity.this, GamesActivity.class);
                startActivity(intent);
            }
        });

        regle = (Button) findViewById(R.id.regle);
        regle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LauncherActivity.this, ReglesActivity.class);
                startActivity(intent);
            }
        });

    }
}
