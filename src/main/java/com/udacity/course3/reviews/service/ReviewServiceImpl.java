package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repository.ReviewRepository;

import java.util.List;
import java.util.Optional;

public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    @Override
    public Review retrieveById(long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        return optionalReview.orElseThrow(ReviewNotFoundException::new);
    }

    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public List<Review> retrieveAllById(long productId) {
        return reviewRepository.findAllById(productId);
    }
}
