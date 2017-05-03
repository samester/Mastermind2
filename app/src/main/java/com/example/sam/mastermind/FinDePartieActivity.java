package com.example.sam.mastermind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class FinDePartieActivity extends AppCompatActivity {

    String HASWIN = "HASWIN";
    String RESULTAT = "LASOLUCE";


    int steph = 0;

    TextView leResultat;
    GridView mGridView;
    Button retry;
    Button menuPrin;

    ArrayList<Integer> laSolution = new ArrayList<>();
    boolean haswin = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_de_partie);
        Intent intent = getIntent();
        haswin = intent.getBooleanExtra(HASWIN, false);
        laSolution = intent.getIntegerArrayListExtra(RESULTAT);

        leResultat = (TextView) findViewById(R.id.resultat);
        mGridView = (GridView) findViewById(R.id.lesbonnesboules);
        retry = (Button) findViewById(R.id.retry);
        menuPrin = (Button) findViewById(R.id.menuPrincipal);

        if(haswin)
        {
            leResultat.setText("Félicitation vous avez trouvé la solution !\n");
        }
        else
        {
            leResultat.setText("Dommage Vous avez perdu, pourquoi ne pas réessayer ?\n");
        }
        leResultat.append("La Solution était : \n");

        mGridView.setAdapter(new ImageAdapter(this, laSolution));

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNouv = new Intent(getApplicationContext(), GamesActivity.class);
                startActivity(intentNouv);
                finish();
            }
        });

        menuPrin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
