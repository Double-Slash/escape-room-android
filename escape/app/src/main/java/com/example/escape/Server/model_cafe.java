package com.example.escape.Server;

import android.graphics.drawable.Drawable;

public class model_cafe {

    String cafeId = null;

    public model_cafe(String cafeId, String cafeName, String area, String address, String latitude, String longtitude, String url, String phonenum, String logo, String themes) {
        this.cafeId = cafeId;
        this.cafeName = cafeName;
        this.area = area;
        this.address = address;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.url = url;
        this.phonenum = phonenum;
        this.logo = logo;
        this.themes = themes;
    }

    String cafeName = null;
    String area = null;
    String address = null;
    String latitude = null;
    String longtitude = null;
    String url = null;
    String phonenum = null;
    String logo = null;
    String themes = null;

    public String getCafeId() {
        return cafeId;
    }

    public void setCafeId(String cafeId) {
        this.cafeId = cafeId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getThemes() {
        return themes;
    }

    public void setThemes(String themes) {
        this.themes = themes;
    }
}
