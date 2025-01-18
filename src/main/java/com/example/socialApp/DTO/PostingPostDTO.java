package com.example.socialApp.DTO;

import org.springframework.web.multipart.MultipartFile;

public class PostingPostDTO {

    private String text;
    private MultipartFile file;
    private int user_id;

    public PostingPostDTO(String text, MultipartFile file, int user_id) {
        this.text = text;
        this.file = file;
        this.user_id = user_id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getText() {
        return text;
    }

    public MultipartFile getFile() {
        return file;
    }

    public int getUser_id() {
        return user_id;
    }
}
