package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.repository.CommentRepository;

import java.util.Optional;

public class CommentServiceImpl implements CommentService{


    private CommentRepository commentRepository;

    @Override
    public Comment findById(long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        return optionalComment.orElseThrow(CommentNotFoundException::new);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
