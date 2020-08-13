package com.example.escape.Adapter;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class cafeitem {
    Drawable cafeimage;
    String cafename;
    String genrelist;
    double star;

    public cafeitem(Drawable cafeimage, String cafename, String genrelist, double star){
        this.cafeimage = cafeimage;
        this.cafename = cafename;
        this.genrelist = genrelist;
        this.star = star;
    }

    public Drawable getCafeimage() {
        return cafeimage;
    }

    public void setCafeimage(Drawable  cafeimage) {
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
