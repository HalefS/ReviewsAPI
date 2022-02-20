package com.udacity.course3.reviews.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, targetEntity = Review.class)
    Collection<Review> reviews;
    @Column(unique = true, nullable = false)
    private String name;
    @NotNull
    private String description;
    @NotNull
    @Column(name = "stock_count")
    private int stockCount;

    public Product() {
        // EMPTY
    }

    public Product(Collection<Review> reviews, String name, String description, int stockCount) {
        this.reviews = reviews;
        this.name = name;
        this.description = description;
        this.stockCount = stockCount;
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

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }
}
