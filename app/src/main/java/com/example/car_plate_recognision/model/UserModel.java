package com.example.car_plate_recognision.model;

public class UserModel {

    private String userId;
    private String username;
    private String password;
    private String email;
    private String role;


    public UserModel(String userId, String password, String role, String username, String email) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.role = role;
        this.username = username;
    }

    public UserModel()
    {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
