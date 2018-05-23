package com.ev.gone.fubiz.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ev.gone.fubiz.Models.LinkSongs;
import com.ev.gone.fubiz.R;

import java.util.ArrayList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by gone on 3/11/18.
 */

public class LinkSongsAdapter extends ArrayAdapter<LinkSongs> {


    private Context mContext;
    private int mLayout;
    private ArrayList<LinkSongs> mList;

    public LinkSongsAdapter( Context context, int resource, ArrayList<LinkSongs> list) {

        super(context, resource, list);
        mContext = context;
        mLayout = resource;
        mList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            System.out.println("Create view");
            //create view
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mLayout, parent, false);
            //get child
            viewHolder = new ViewHolder();
            viewHolder.tvTest = convertView.findViewById(R.id.tvlink_items);

            //save
            convertView.setTag(viewHolder);
        }
        else{
            System.out.println("Re-use");
            viewHolder = (ViewHolder)convertView.getTag();
        }

        //put data
        LinkSongs linkSongs = mList.get(position);
        viewHolder.tvTest.setText(linkSongs.getLinks());

        return convertView;
    }


    private class ViewHolder{
        public TextView tvTest;
    }

}
