package com.adarsh.kickballs;

import java.io.Serializable;

public class User implements Serializable {

    private String id;

    private String name;

    private int score;

    private String description;

    private int photo;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoto() {
        return this.photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public User() {
    }

    public User(String id, String name, int score, String description, int photo) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.description = description;
        this.photo = photo;
    }
}
