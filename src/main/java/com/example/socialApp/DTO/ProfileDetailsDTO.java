package com.example.socialApp.DTO;

public class ProfileDetailsDTO {
    private String user_name;
    private String email;
    private String phone;

    public ProfileDetailsDTO(String user_name, String email, String phone) {
        this.user_name = user_name;
        this.email = email;
        this.phone = phone;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
