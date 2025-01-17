package com.example.socialApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;
    private String test_post;
    private String img_url;
    private int comments;
    private int likes;
    private int user_id;

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public void setTest_post(String test_post) {
        this.test_post = test_post;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public String getTest_post() {
        return test_post;
    }

    public String getImg_url() {
        return img_url;
    }

    public int getComments() {
        return comments;
    }

    public int getLikes() {
        return likes;
    }

    public int getUser_id() {
        return user_id;
    }
}
