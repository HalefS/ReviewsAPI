package com.udacity.course3.reviews.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity(name = "reviews")
public class Review {

    @Id
    private long id;
    @OneToOne(targetEntity = User.class)
    private User author;
    @NotNull
    private String title;
    @NotNull
    @Size(min = 0, max = 5)
    private int stars;
    @NotNull
    private String text;
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private Collection<Comment> comments;

    public Review() {
        // EMPTY
    }

    public Review(User author, String title, int stars, String text, Collection<Comment> comments) {
        this.author = author;
        this.title = title;
        this.stars = stars;
        this.text = text;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
}
