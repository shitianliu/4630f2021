package com.example.mydesign;

import android.app.Application;

public class CurrentUser extends Application {
    private String username;
    private Integer position;
    private String Text;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    @Override
    public void onCreate() {
        this.username="";
        this.position=0;
        this.Text="";
        super.onCreate();
    }
}
