package edu.eci.ieti.Users.data;

import edu.eci.ieti.Users.dto.UserDto;

public class User {
    private String id;
    private UserDto user;
    private String createdAt;

    public User(String id, UserDto user, String createdAt) {
        this.id = id;
        this.user = user;
        this.createdAt = createdAt;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
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
                "id='" + id + '\'' +
                ", user=" + user +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}