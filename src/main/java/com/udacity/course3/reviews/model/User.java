package com.udacity.course3.reviews.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity(name = "users")
public class User {

    @Id
    private long id;
    @NotNull
    @Column(unique = true)
    private String username;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    Collection<Comment> comments;

    protected User() {
        // EMPTY
    }

    public User(String username, Collection<Comment> comments) {
        this.username = username;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
