package ru.StayLonely.FunkoCom.config.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String description;
    private LocalDateTime createdAt;

    public User() {

    }

    public User(String username, String password, String email, String description, LocalDateTime createdAt) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.description = description;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


}

