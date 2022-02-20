package com.udacity.course3.reviews.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;
    @NotNull
    private String title;
    @NotNull
    @Min(value = 1, message = "Review should have at least 1 star")
    @Max(value = 5, message = "Review should have at most 5 stars")
    private int stars;
    @NotNull
    private String text;
    @OneToMany(mappedBy = "review")
    private Collection<Comment> comments;
    @ManyToOne(targetEntity = Product.class)
    @JsonIgnore
    private Product product;
   @Column(columnDefinition = "varchar(255) default 'Anonymous'")
    private String author;
    @Column(name = "created_at", columnDefinition = "timestamp default 'current_timestamp'")
    private Timestamp createdAt;

    public Review() {
        // EMPTY
    }

    public Review(String title, int stars, String text, Collection<Comment> comments, String author) {
        this.title = title;
        this.stars = stars;
        this.text = text;
        this.comments = comments;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
