package com.myapplicationdev.android.p05_ps;

import java.io.Serializable;

public class Song implements Serializable {
    private int _id,years,stars;
    private String title, singers;

    public Song(int _id, int years, int stars, String title, String singers) {
        this._id = _id;
        this.years = years;
        this.stars = stars;
        this.title = title;
        this.singers = singers;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public int get_id() {
        return _id;
    }


    public int getYears() {
        return years;
    }


    public int getStar() {
        return stars;
    }


    public String getTitle() {
        return title;
    }


    public String getSingers() {
        return singers;
    }

}
