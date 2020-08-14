package com.example.escape_room.Server;

import android.graphics.drawable.Drawable;

public class model_theme {
    String themeId = null;

    public model_theme(String themeId, String themeName, String cafeName, String area, String genreId, String price, String pricePlus, String level, String time, String activity, String peopleNum, String barrier, String rating, String image, String description, String liked, String review) {
        this.themeId = themeId;
        this.themeName = themeName;
        this.area = area;
        this.genreId = genreId;
        this.price = price;
        this.pricePlus = pricePlus;
        this.level = level;
        this.time = time;
        this.activity = activity;
        this. peopleNum = peopleNum;
        this.barrier = barrier;
        this.rating = rating;
        this.image = image;
        this.description = description;
        this.liked = liked;
        this.review = review;
    }

    String themeName;
    String cafeName;
    String area;
    String genreId;
    String price;
    String pricePlus;
    String level;
    String time;
    String activity;
    String peopleNum;
    String barrier;
    String rating;
    String image;
    String description;
    String liked;
    String review;

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    public String getCafeName() {
        return cafeName;
    }

    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPricePlus() {
        return pricePlus;
    }

    public void setPricePlus(String pricePlus) {
        this.pricePlus = pricePlus;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(String peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getBarrier() {
        return barrier;
    }

    public void setBarrier(String barrier) {
        this.barrier = barrier;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLiked() {
        return liked;
    }

    public void setLiked(String liked) {
        this.liked = liked;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
