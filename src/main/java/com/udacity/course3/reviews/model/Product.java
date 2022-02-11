package com.udacity.course3.reviews.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity(name = "products")
public class Product {

    @Id
    private long id;
    @OneToMany(mappedBy = "product")
    Collection<Review> reviews;
    @Column(unique = true, nullable = false)
    private String name;
    @NotNull
    private String description;

    public Product() {
        // EMPTY
    }

    public Product(Collection<Review> reviews, String name, String description) {
        this.reviews = reviews;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
