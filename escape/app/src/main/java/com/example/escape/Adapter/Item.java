package com.example.escape.Adapter;

public class Item {
    int image;
    String title;

    int getImage() {
        return this.image;
    }
    String getTitle() {
        return this.title;
    }

    public Item(int image, String title) {
        this.image = image;
        this.title = title;
    }
}