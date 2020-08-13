package com.example.escape.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.escape.Adapter.cafeadapter;
import com.example.escape.Adapter.cafeitem;
import com.example.escape.R;
import com.example.escape.Server.Task;

public class SearchFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_search , container, false);
        GridView gridView = view.findViewById(R.id.gridview_cafe);
        cafeadapter adapter = new cafeadapter();

        Button button_search = view.findViewById(R.id.button_search);

        button_search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Task task = new Task();
                task.setapitype("cafe");
                task.doInBackground();
            }
        });


        //adapter.addItem(new cafeitem());

        return view;
    }
}

