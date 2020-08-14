package com.example.escape_room.Adapter;

import android.graphics.Bitmap;

public class Item {
    Bitmap themeimage;
    String themename;
    String cafename;
    String cafearea;

    public Item(Bitmap themeimage, String themename, String cafename, String cafearea) {
        this.themeimage = themeimage;
        this.themename = themename;
        this.cafename = cafename;
        this.cafearea = cafearea;
    }

    public Bitmap getThemeimage() {
        return themeimage;
    }

    public void setThemeimage(Bitmap themeimage) {
        this.themeimage = themeimage;
    }

    public String getThemename() {
        return themename;
    }

    public void setThemename(String themename) {
        this.themename = themename;
    }

    public String getCafename() {
        return cafename;
    }

    public void setCafename(String cafename) {
        this.cafename = cafename;
    }

    public String getCafearea() {
        return cafearea;
    }

    public void setCafearea(String cafearea) {
        this.cafearea = cafearea;
    }
}