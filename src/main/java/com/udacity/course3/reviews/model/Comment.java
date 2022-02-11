package com.udacity.course3.reviews.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "comments")
public class Comment {

    @Id
    private long id;
    @ManyToOne(targetEntity = User.class)
    private User author;
    @ManyToOne(targetEntity = Review.class)
    private Review review;

    public Comment() {
        // EMPTY
    }

    public Comment(User author, Review review) {
        this.author = author;
        this.review = review;
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

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
