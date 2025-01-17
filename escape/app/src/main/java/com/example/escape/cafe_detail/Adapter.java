package com.example.escape.cafe_detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.escape.R;
import com.example.escape.cafe_detail.cafe_detail;

import java.util.List;

public class Adapter extends PagerAdapter {

    private List<com.example.escape.cafe_detail.Model> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<com.example.escape.cafe_detail.Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    public Adapter(List<com.example.escape.cafe_detail.Model> models, cafe_detail context) {
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item,container,false);

        ImageView imageView;
        TextView thema, cafe;

        imageView = view.findViewById(R.id.image);
        thema = view.findViewById(R.id.thema);
        cafe = view.findViewById(R.id.cafe);

        imageView.setImageResource(models.get(position).getImage());
        thema.setText(models.get(position).getThema());
        cafe.setText(models.get(position).getCafe());

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
