package com.rajanks.digitaldiary.Util;

/**
 * Created by rajan.kali on 16/08/16.
 */
public class AppBase {

    private static AppBase instance = null;

    public static AppBase getInstance() {
        if (instance == null) {
            instance = new AppBase();
        }
        return instance;
    }

    private AppBase() {

    }

    private String name;
    private String detail;
    private String imageUrl;
    private String roll_no;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }
}