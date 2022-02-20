package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.domain.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    Review retrieveById(long id);

    void save(Review review);

    List<Review> retrieveAllById(long productId);
}
