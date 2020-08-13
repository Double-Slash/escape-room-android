package com.example.escape.cafe_detail;

public class Model {

    private int image;
    private String thema;
    private String cafe;

    public Model(int image, String thema, String cafe) {
        this.image = image;
        this.thema = thema;
        this.cafe = cafe;
    }

    public int getImage() { return image; }

    public void setImage(int image) {
        this.image = image;
    }

    public String getThema() {
        return thema;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }

    public String getCafe() {
        return cafe;
    }

    public void setCafe(String cafe) {
        this.cafe = cafe;
    }
}
