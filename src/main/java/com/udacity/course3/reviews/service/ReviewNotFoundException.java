package com.udacity.course3.reviews.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Review Not Found")
public class ReviewNotFoundException extends Exception {

    private String message;

    public ReviewNotFoundException(String message) {
        super(message);
    }
}
