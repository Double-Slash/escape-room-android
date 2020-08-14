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

public class DetailThemeAdapter extends BaseAdapter {

    ArrayList<Item_detail> items = new ArrayList<Item_detail>();
    Context context;

    public void addItem(Item_detail item){
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
        Item_detail listitem = items.get(position);

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_detail, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView_theme);
        TextView textview_theme = convertView.findViewById(R.id.textView_themename);
        TextView textview_desc = convertView.findViewById(R.id.textView2_themecontent);
        TextView textview_gen = convertView.findViewById(R.id.textView4);

        imageView.setImageBitmap(listitem.getThemeimage());
        textview_theme.setText(listitem.getThemename());
        textview_desc.setText(listitem.getThemedes());
        textview_gen.setText(listitem.getThemegen());

        return convertView;
    }
}
