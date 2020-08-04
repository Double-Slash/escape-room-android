package com.example.escape.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escape.Adapter.RecyclerAdapter;
import com.example.escape.Adapter.Item;
import com.example.escape.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    final int ITEM_SIZE = 5;
    String str;
    Item[] item;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home , container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        List<Item> items = new ArrayList<>();
        item = new Item[ITEM_SIZE];
        item[0] = new Item(R.drawable.a, "금주의 테마");
        item[1] = new Item(R.drawable.b, "#2");
        item[2] = new Item(R.drawable.c, "#3");
        item[3] = new Item(R.drawable.d, "#4");
        item[4] = new Item(R.drawable.e, "#5");

        for (int i = 0; i < ITEM_SIZE; i++) {
            items.add(item[i]);
        }

        recyclerView.setAdapter(new RecyclerAdapter(getContext(), items, R.layout.fragment_home));

        return view;

    }

}