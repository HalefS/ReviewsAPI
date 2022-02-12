package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.service.ProductService;
import com.udacity.course3.reviews.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ProductService productService;

    public ReviewsController(ReviewService reviewService, ProductService productService) {
        this.reviewService = reviewService;
        this.productService = productService;
    }

    /**
     * Creates a review for a product.
     * <p>
     * 1. Add argument for review entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of product.
     * 3. If product not found, return NOT_FOUND.
     * 4. If found, save review.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @PostMapping(value = "/reviews/products/{productId}")
    public ResponseEntity<?> createReviewForProduct(@PathVariable("productId") Integer productId, @RequestBody Review review) {
        Product product = productService.retrieveById(productId);
        review.setProduct(product);
        reviewService.save(review);

        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @GetMapping(value = "/reviews/products/{productId}")
    public ResponseEntity<List<?>> listReviewsForProduct(@PathVariable("productId") Integer productId) {
        List<Review> reviews = reviewService.retrieveAllById(productId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}