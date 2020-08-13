package com.example.escape.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.escape.R;

import java.util.ArrayList;

public class cafeadapter extends BaseAdapter {
    ArrayList<cafeitem> items = new ArrayList<cafeitem>();
    Context context;

    public void addItem(cafeitem item){
        items.add(item);
    }

    @Override
    public Object getItem(int position){
        return items.get(position);
    }

    @Override
    public int getCount(){
        return items.size();
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        context = parent.getContext();
        cafeitem listitem = items.get(position);

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_cafelist, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView_cafe);
        TextView textview_cafe = convertView.findViewById(R.id.textView_cafename);
        TextView textview_genre = convertView.findViewById(R.id.textView_genrelist);
        TextView textview_star = convertView.findViewById(R.id.textView_star);

        imageView.setImageDrawable(listitem.getCafeimage());
        textview_cafe.setText(listitem.getCafename());
        textview_genre.setText(listitem.getGenrelist());
        textview_star.setText(Double.toString(listitem.getStar()));

        return convertView;
    }
}
