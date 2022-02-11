package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.model.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {

    Product retrieveById(long id);

    void save(Product product);
}