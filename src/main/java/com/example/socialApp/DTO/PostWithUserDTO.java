package com.example.socialApp.DTO;

public class PostWithUserDTO {
    private String user_name;
    private String user_photo;
    private int post_id;
    private String text_post;
    private String img_url;
    private int comments;
    private int likes;

    public PostWithUserDTO(String userName, String userPhoto, int postId, String textPost, String imgUrl, int comments, int likes) {
        this.user_name = userName;
        this.user_photo = userPhoto;
        this.post_id = postId;
        this.text_post = textPost;
        this.img_url = imgUrl;
        this.comments = comments;
        this.likes = likes;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
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

    public String getUser_name() {
        return user_name;
    }

    public String getUser_photo() {
        return user_photo;
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
