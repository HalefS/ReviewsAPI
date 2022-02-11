package com.udacity.course3.reviews.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String title;
    @NotNull
    @Size(min = 1, max = 5)
    private int stars;
    @NotNull
    private String text;
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private Collection<Comment> comments;
    @ManyToOne(targetEntity = Product.class, cascade = CascadeType.ALL)
    private Product product;

    public Review() {
        // EMPTY
    }

    public Review(String title, int stars, String text, Collection<Comment> comments, Product product) {
        this.title = title;
        this.stars = stars;
        this.text = text;
        this.comments = comments;
        this.product = product;
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
}
