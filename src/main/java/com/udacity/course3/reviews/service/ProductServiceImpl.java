package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.repository.ProductRepository;

import java.util.Optional;

public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Override
    public Product retrieveById(long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
