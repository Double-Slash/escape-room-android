package com.example.room_escape_review;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyHolder extends RecyclerView.ViewHolder {

    ImageView mImaeView;
    TextView mTitle, mDes, mCafe, dateNow;

    long now = System.currentTimeMillis();
    // 현재시간을 date 변수에 저장한다.
    Date date = new Date(now);
    // 시간을 나타냇 포맷을 정한다 ( yyyy/MM/dd 같은 형태로 변형 가능 )
    SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy.MM.dd");
    // nowDate 변수에 값을 저장한다.
    String formatDate = sdfNow.format(date);

    public MyHolder(@NonNull View itemView) {
        super(itemView);
        this.mImaeView = itemView.findViewById(R.id.image);
        this.mTitle= itemView.findViewById(R.id.title);
        this.mCafe=itemView.findViewById(R.id.cafe);
        this.mDes=itemView.findViewById(R.id.description);
        this.dateNow = itemView.findViewById(R.id.date);
        dateNow.setText(formatDate);
    }
}

