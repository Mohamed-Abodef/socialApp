package com.example.socialApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comment_id;
    private int post_id;
    private int user_id;
    private String text_comment;

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setText_comment(String text_comment) {
        this.text_comment = text_comment;
    }

    public int getComment_id() {
        return comment_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getText_comment() {
        return text_comment;
    }
}
