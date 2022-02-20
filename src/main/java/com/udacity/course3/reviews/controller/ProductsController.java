package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.domain.Product;
import com.udacity.course3.reviews.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring REST controller for working with product entity.
 */
@RestController
public class ProductsController {

    @Autowired
    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Creates a product.
     *
     * 1. Accept product as argument. Use {@link RequestBody} annotation.
     * 2. Save product.
     */
    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product) {
        // if request body is valid, persist body
        // if not respond with bad request
        if (product != null) {
            productService.save(product);
        }
        else {
            throw new HttpServerErrorException(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Finds a product by id.
     *
     * @param id The id of the product.
     * @return The product if found, or a 404 not found.
     */
    @GetMapping( "products/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        Product product = productService.retrieveById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * Lists all products.
     *
     * @return The list of products.
     */
    @GetMapping("/products")
    public List<?> listProducts() {
        List<Product> products = productService.retrieveAll();
        return products != null ? products : new ArrayList<>();
    }
}