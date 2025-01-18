package com.example.socialApp.DTO;

public class ProfileInfoDTO {
    private String user_name;
    private String user_photo;
    private String user_BG;
    private int posts;
    private int followers_num;
    private int following_num;

    public ProfileInfoDTO(String user_name, String user_photo, String user_BG, int posts, int followers_num, int following_num) {
        this.user_name = user_name;
        this.user_photo = user_photo;
        this.user_BG = user_BG;
        this.posts = posts;
        this.followers_num = followers_num;
        this.following_num = following_num;
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

    public void setFollowers_num(int followers_num) {
        this.followers_num = followers_num;
    }

    public void setFollowing_num(int following_num) {
        this.following_num = following_num;
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
}
