package com.example.sample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table(name = "task")
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    @JsonIgnore
    @ManyToOne
    private User user;

    protected Task() { }

    public Task(final User user, final String description) {
        this.user = user;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}