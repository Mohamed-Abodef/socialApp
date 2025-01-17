package com.example.socialApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comment_id;



    private String text_comment;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Posts post;

    public void setPost(Posts post) {
        this.post = post;
    }

    public Posts getPost() {
        return post;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }





    public void setText_comment(String text_comment) {
        this.text_comment = text_comment;
    }

    public int getComment_id() {
        return comment_id;
    }





    public String getText_comment() {
        return text_comment;
    }
}
