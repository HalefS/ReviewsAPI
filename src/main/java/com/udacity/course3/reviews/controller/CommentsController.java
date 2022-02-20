package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.domain.Comment;
import com.udacity.course3.reviews.domain.Review;
import com.udacity.course3.reviews.service.CommentService;
import com.udacity.course3.reviews.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private CommentService commentService;

    public CommentsController(ReviewService reviewService, CommentService commentService) {
        this.reviewService = reviewService;
        this.commentService = commentService;
    }

    /**
     * Creates a comment for a review.
     *
     * @param reviewId The id of the review.
     */
    @PostMapping(value = "/reviews/{reviewId}")
    public ResponseEntity<?> createCommentForReview(@PathVariable("reviewId") Integer reviewId, @RequestBody Comment comment) {
        Review review = reviewService.retrieveById(reviewId);
        comment.setReview(review);
        commentService.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    /**
     * List comments for a review.
     *
     * @param reviewId The id of the review.
     */
    @GetMapping(value = "/reviews/{reviewId}")
    public List<?> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
        Review review = reviewService.retrieveById(reviewId);
        return new ArrayList<>(review.getComments());
    }
}