package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.domain.Review;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

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
