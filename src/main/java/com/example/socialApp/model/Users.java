package com.example.socialApp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    private String user_name;
    private String user_photo;
    private String user_BG;
    private int posts;
    private int followers_num;
    private int following_num;
    private String email;
    private String pass;
    private String phone;
    private LocalDate birth;

    @OneToMany(mappedBy = "user")
    private List<Posts> postsObj;

    @OneToMany(mappedBy = "user")
    private List<Comments> commentsObj;

    public void setCommentsObj(List<Comments> commentsObj) {
        this.commentsObj = commentsObj;
    }

    public List<Comments> getCommentsObj() {
        return commentsObj;
    }

    public void setPostsObj(List<Posts> postsObj) {
        this.postsObj = postsObj;
    }

    public List<Posts> getPostsObj() {
        return postsObj;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public void setUser_BG(String user_BG) {
        this.user_BG = user_BG;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public void setFollowers_num(int follwors_num) {
        this.followers_num = follwors_num;
    }

    public void setFollowing_num(int following_num) {
        this.following_num = following_num;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public String getUser_BG() {
        return user_BG;
    }

    public int getPosts() {
        return posts;
    }

    public int getFollowers_num() {
        return followers_num;
    }

    public int getFollowing_num() {
        return following_num;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirth() {
        return birth;
    }
}
