package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.model.Review;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ReviewService {

    Optional<Review> findById(long id);

    void save(Review review);
}
