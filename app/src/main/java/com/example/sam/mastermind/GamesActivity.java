package com.example.sam.mastermind;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class GamesActivity extends AppCompatActivity {

    GridView lesBoules;
    GridView lePlateau;
    Button razButton;
    Button verifButton;

    List<Integer> lesChoix = new ArrayList<>();
    List<Integer> laSolution = new ArrayList<>();

    Context mContext = this;
    int nbCoup = 0;
    int nbBoule = 0;


    String HASWIN = "HASWIN";
    String RESULTAT = "LASOLUCE";
    boolean hasWin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        createSolutionAleat();

        razButton = (Button) findViewById(R.id.raz);

        verifButton = (Button) findViewById(R.id.verif);


        lePlateau = (GridView) findViewById(R.id.plateauJeu);
        lePlateau.setAdapter(new ImageAdapter(this, lesChoix));
        lesBoules = (GridView) findViewById(R.id.affiche_bille);
        lesBoules.setAdapter(new ImageAdapter(this));
        lesBoules.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if(containsAtLine((Integer) lesBoules.getAdapter().getItem(position)))
                    Toast.makeText(mContext, "Impossible de metttre deux fois la même boule sur cette ligne", Toast.LENGTH_LONG).show();
                else if(nbBoule >= 4 )
                    Toast.makeText(mContext, "Impossible de d'ajouter une nouvelle boule sur cette ligne", Toast.LENGTH_LONG).show();
                else {
                    lesChoix.add((Integer) lesBoules.getAdapter().getItem(position));
                    lePlateau.setAdapter(new ImageAdapter(mContext, lesChoix));
                    nbBoule++;
                }
            }
        });

        //Gerer RAZ et VERIF(+ ENDGAME)
        razButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Supprimer les bille de la grille (juste cette ligne)
                // On enlève le dernier élément de la liste nbBoule fois

                for(int i = 0; i < nbBoule; i++)
                {
                    lesChoix.remove(lesChoix.size()-1);
                }

                // Affichage du nouveau plateau

                lePlateau.setAdapter(new ImageAdapter(mContext, lesChoix));

                // Remettre nbBoule à zero
                nbBoule = 0;

            }
        });

        verifButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int nbCorrect = 0;
                int nbPresqueCorrect = 0;

                if (nbBoule == 4) {

                    //Calculer les corrects et presque corrects
                    for(int i = 0; i < 4; i++) {
                        if (laSolution.get(i).equals(lesChoix.get(5*nbCoup + i)))
                            nbCorrect++;

                        else if(containsAtLine(laSolution.get(i)))
                            nbPresqueCorrect++;
                    }

                    int laReponse = nbCorrect + (10 * nbPresqueCorrect);

                    switch(laReponse)
                    {
                        case 0 : lesChoix.add(R.drawable.sol00);
                            break;
                        case 1 : lesChoix.add(R.drawable.sol1);
                            break;
                        case 2 : lesChoix.add(R.drawable.sol2);
                            break;
                        case 3 : lesChoix.add(R.drawable.sol3);
                            break;
                        case 4 : lesChoix.add(R.drawable.sol4);
                            //Gerer fin de partie
                            Intent intent = new Intent(mContext, FinDePartieActivity.class);
                            intent.putIntegerArrayListExtra(RESULTAT, (ArrayList) laSolution);
                            intent.putExtra(HASWIN, true);
                            startActivity(intent);
                            finish();


                            break;
                        case 10: lesChoix.add(R.drawable.sol10);
                            break;
                        case 11: lesChoix.add(R.drawable.sol11);
                            break;
                        case 12: lesChoix.add(R.drawable.sol12);
                            break;
                        case 13: lesChoix.add(R.drawable.sol13);
                            break;
                        case 20: lesChoix.add(R.drawable.sol20);
                            break;
                        case 21: lesChoix.add(R.drawable.sol21);
                            break;
                        case 22: lesChoix.add(R.drawable.sol22);
                            break;
                        case 30: lesChoix.add(R.drawable.sol30);
                            break;
                        case 31: lesChoix.add(R.drawable.sol31);
                            break;
                        case 40: lesChoix.add(R.drawable.sol40);
                            break;
                    }

                    nbCoup++;
                    nbBoule = 0;
                    lePlateau.setAdapter(new ImageAdapter(mContext, lesChoix));

                    if(nbCoup == 8)
                    {

                        Intent intent = new Intent(mContext, FinDePartieActivity.class);
                        intent.putExtra(HASWIN, false);
                        intent.putIntegerArrayListExtra(RESULTAT, (ArrayList) laSolution);
                        startActivity(intent);
                        finish();
                    }

                } else {
                    Toast.makeText(mContext, "Vous devez placer 4 billes avant de lancer une vérification", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void createSolutionAleat() {
        List<Integer> mThumbIds = new ArrayList<>();
        mThumbIds.add(R.drawable.blanc);
        mThumbIds.add(R.drawable.bleu);
        mThumbIds.add(R.drawable.jaune);
        mThumbIds.add(R.drawable.orange);
        mThumbIds.add(R.drawable.rose);
        mThumbIds.add(R.drawable.rouge);
        mThumbIds.add(R.drawable.vert);
        mThumbIds.add(R.drawable.violet);

        for(int i = 0; i < 4; i++)
        {
            int rand = (int) (Math.random() * 100) % mThumbIds.size();
            laSolution.add(mThumbIds.get(rand));
            mThumbIds.remove(rand);
        }
    }

    private boolean containsAtLine(Integer integer)
    {
           for(int i = 5*nbCoup; i < lesChoix.size(); i++)
           {
               if(lesChoix.get(i).equals(integer))
                   return true;
           }
           return false;
    }
}
