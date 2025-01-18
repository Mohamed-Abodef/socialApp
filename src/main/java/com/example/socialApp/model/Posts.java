package com.example.socialApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;
    private String text_post;
    private String img_url;
    private int comments;
    private int likes;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getUser() {

        return user;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public void setText_post(String text_post) {
        this.text_post = text_post;
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


    public int getPost_id() {
        return post_id;
    }

    public String getText_post() {
        return text_post;
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


}
