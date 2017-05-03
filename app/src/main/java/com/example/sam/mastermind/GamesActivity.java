package com.example.sam.mastermind;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;


public class GamesActivity extends AppCompatActivity {

    GridView mGridView;
    GridView lePlateau;
    List<Integer> lesChoix = new ArrayList<>();
    Context mContext = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        lePlateau = (GridView) findViewById(R.id.plateauJeu);
        lePlateau.setAdapter(new ImageAdapter(this, lesChoix));
        mGridView = (GridView) findViewById(R.id.affiche_bille);
        mGridView.setAdapter(new ImageAdapter(this));
        mGridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                lesChoix.add((Integer) mGridView.getAdapter().getItem(position));
                lePlateau.setAdapter(new ImageAdapter(mContext, lesChoix));
            }
        });

    }
}
