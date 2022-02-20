package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.domain.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    Comment findById(long id);

    void save(Comment comment);
}
