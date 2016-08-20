package com.rajanks.digitaldiary.DataModel;

/**
 * Created by rajan.kali on 16/08/16.
 */
public class Feed {

    private String title;
    private String content;

    public Feed(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
