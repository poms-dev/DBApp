package com.example.dbapp.model;

import androidx.annotation.NonNull;

import java.util.Objects;

public class User {

    public String username;
    public int score;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, int score) {
        this.username = username;
        this.score = score;
    }

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return score == user.score && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, score);
    }
}