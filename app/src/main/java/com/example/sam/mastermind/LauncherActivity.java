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
    int i =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        image = (ImageView) findViewById(R.id.accueil);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /**
                switch(i)
                {
                    case 0: image.setImageDrawable(R.drawable.BilleRouge);
                        i++;
                        break;
                    case 1: image.setImageDrawable(R.drawable.BilleJaune);
                        i++;
                        break;
                    case 2: image.setImageDrawable(R.mipmap.ic_launcher);
                        i++;
                        break;
                    case 3: image.setImageDrawable(R.mipmap.ic_launcher);
                        i++;
                        break;
                    case 4: image.setImageDrawable(R.mipmap.ic_launcher);
                        i++;
                        break;
                    case 5: image.setImageDrawable(R.mipmap.ic_launcher);
                        i++;
                        break;
                    case 6: image.setImageDrawable(R.mipmap.ic_launcher);
                        i++;
                        break;
                    case 7: image.setImageDrawable(R.mipmap.ic_launcher);
                        i = 0;
                        break;
                    default: image.setImageDrawable(R.mipmap.ic_launcher);
                        break;

                }
                */
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
