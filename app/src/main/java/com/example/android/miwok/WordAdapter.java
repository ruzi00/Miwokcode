package com.example.android.miwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by rasr00 on 07/05/2017.
 */

public class WordAdapter extends ArrayAdapter <Word>{

    private int mColor;

    public WordAdapter(Context context, ArrayList<Word> pWords, int coloring) {
        super(context,0, pWords);
        mColor = coloring;
    }





    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word local_word = getItem(position);
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok);
        miwokTextView.setText(local_word.getmMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.english);
        defaultTextView.setText(local_word.getmDefaultTranslation());

        ImageView imageViewRep = (ImageView) listItemView.findViewById(R.id.image);
        if (local_word.hasImage()) {
            imageViewRep.setImageResource(local_word.getmImageResourceId());
            imageViewRep.setVisibility(View.VISIBLE);
        } else
            imageViewRep.setVisibility(View.GONE);

        View contain = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColor);
        contain.setBackgroundColor(color);

        return listItemView;
    }
}
