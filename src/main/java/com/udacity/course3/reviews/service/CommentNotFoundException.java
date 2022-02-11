package com.udacity.course3.reviews.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Comment not found")
public class CommentNotFoundException extends Exception {

    private String message;

    public CommentNotFoundException(String message) {
        super(message);
    }
}