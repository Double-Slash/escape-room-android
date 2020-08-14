package com.example.escape_room.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.escape_room.R;

import java.util.ArrayList;

public class RecyclerAdapter extends BaseAdapter {
    ArrayList<Item> items = new ArrayList<Item>();
    Context context;

    public void addItem(Item item){
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
        Item listitem = items.get(position);

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_themelist, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView_theme);
        TextView textview_theme = convertView.findViewById(R.id.textView_themename);
        TextView textview_cafe = convertView.findViewById(R.id.textView_cafename);
        TextView textview_area = convertView.findViewById(R.id.textView_area);

        imageView.setImageBitmap(listitem.getThemeimage());
        textview_theme.setText(listitem.getThemename());
        textview_cafe.setText(listitem.getCafename());
        textview_area.setText(listitem.getCafearea());

        return convertView;
    }
}