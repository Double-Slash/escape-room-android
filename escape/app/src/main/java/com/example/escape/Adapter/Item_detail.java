package com.example.escape_room.Adapter;

import android.graphics.Bitmap;

public class Item_detail {
    Bitmap themeimage;
    String themename;
    String themedes;
    String themegen;

    public Item_detail(Bitmap themeimage, String themename, String themedes, String themegen) {
        this.themeimage = themeimage;
        this.themename = themename;
        this.themedes = themedes;
        this.themegen = themegen;
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

    public String getThemedes() {
        return themedes;
    }

    public void setThemedes(String themedes) {
        this.themedes = themedes;
    }

    public String getThemegen() {
        return themegen;
    }

    public void setThemegen(String themegen) {
        this.themegen = themegen;
    }
}