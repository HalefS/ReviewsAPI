package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{


    @Autowired
    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

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
