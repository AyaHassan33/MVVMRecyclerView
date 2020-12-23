package com.example.mvvmrecyclerview.models;

public class Films {
    private String title;
    private String imageUrl;

    public Films(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }
    public Films(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
