package com.example.socialApp.DTO;



public class RequestComment {

    private String text;
    private int user_id;
    private int post_id;

    public void setText(String text) {
        this.text = text;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getText() {
        return text;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getPost_id() {
        return post_id;
    }
}
