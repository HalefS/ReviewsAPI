package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.domain.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    @Query("select r from Review r where r.product.id=:productId")
    List<Review> findAllById(@Param("productId") long productId);

}
