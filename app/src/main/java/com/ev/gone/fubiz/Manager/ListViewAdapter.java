package com.ev.gone.fubiz.Manager;

/**
 * Created by gone on 2/27/18.
 */

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ev.gone.fubiz.R;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<String> {

    private final Activity context;
    ArrayList<String> content;
//    private final Integer[] imgid;
    TextView tvContent;

    public ListViewAdapter(Activity context, ArrayList<String> content) {
        super(context, R.layout.inflate_list_view, content);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.content = content;
    }

    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.inflate_list_view, null, true);
        tvContent = (TextView) rowView.findViewById(R.id.tv_content);


        Typeface customfont = Typeface.createFromAsset(getContext().getAssets(), "font/aqua.ttf");
        tvContent.setTypeface(customfont);
//        ImageView ivImage = (ImageView) rowView.findViewById(R.id.ivImage);

        tvContent.setText(content.get(position));
//        ivImage.setImageResource(imgid[position]);
        return rowView;

    };
}