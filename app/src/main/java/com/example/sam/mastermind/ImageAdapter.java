package com.example.sam.mastermind;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aymeric on 03/05/2017.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private List<Integer> mThumbIds = new ArrayList<>();

    public ImageAdapter(Context c) {
        mContext = c;
        mThumbIds.add(R.drawable.blanc);
        mThumbIds.add(R.drawable.bleu);
        mThumbIds.add(R.drawable.jaune);
        mThumbIds.add(R.drawable.orange);
        mThumbIds.add(R.drawable.rose);
        mThumbIds.add(R.drawable.rouge);
        mThumbIds.add(R.drawable.vert);
        mThumbIds.add(R.drawable.violet);



    }

    public ImageAdapter(Context c, List<Integer> thumbIDS) {
        mContext = c;
        mThumbIds = thumbIDS;
    }

    public int getCount() {
        return mThumbIds.size();
    }

    public Object getItem(int position) {
        return mThumbIds.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds.get(position));
        return imageView;
    }


}
