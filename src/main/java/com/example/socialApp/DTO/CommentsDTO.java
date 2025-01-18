package com.example.socialApp.DTO;

public class CommentsDTO {

    private String text_comment;
    private int comment_id;
    private String user_name;
    private String user_photo;
    private int user_id;
    private int post_id;

    public CommentsDTO(String text_comment, int comment_id, String user_name, String user_photo, int user_id, int post_id) {
        this.text_comment = text_comment;
        this.comment_id = comment_id;
        this.user_name = user_name;
        this.user_photo = user_photo;
        this.user_id = user_id;
        this.post_id = post_id;
    }

    public void setText_comment(String text_comment) {
        this.text_comment = text_comment;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getText_comment() {
        return text_comment;
    }

    public int getComment_id() {
        return comment_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getPost_id() {
        return post_id;
    }
}
