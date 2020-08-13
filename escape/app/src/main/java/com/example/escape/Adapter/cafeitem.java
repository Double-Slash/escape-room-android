package com.example.escape.Adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ViewFlipper;

public class cafeitem {
    Bitmap cafeimage;
    String cafename;
    String genrelist;
    double star;

    public cafeitem(Bitmap cafeimage, String cafename, String genrelist, double star){
        this.cafeimage = cafeimage;
        this.cafename = cafename;
        this.genrelist = genrelist;
        this.star = star;
    }

    public Bitmap getCafeimage() {
        return cafeimage;
    }

    public void setCafeimage(Bitmap cafeimage) {
        this.cafeimage = cafeimage;
    }

    public String getCafename() {
        return cafename;
    }

    public void setCafename(String cafename) {
        this.cafename = cafename;
    }

    public String getGenrelist() {
        return genrelist;
    }

    public void setGenrelist(String genrelist) {
        this.genrelist = genrelist;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }
}
