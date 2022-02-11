package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.model.Comment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CommentService {

    Optional<Comment> findById(long id);

    void save(Comment comment);
}
