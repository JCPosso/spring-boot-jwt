package edu.eci.ieti.Users.data;

import edu.eci.ieti.Users.dto.UserDto;

public class User {
    private String email;
    private String id;
    private String createdAt;
    private String name;
    private String lastName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User(String id, UserDto user, String createdAt ) {
        this.id = id;
        this.createdAt = createdAt;
        this.name = user.getName();
        this.email = user.getEmail();
        this.lastName = user.getLastName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}