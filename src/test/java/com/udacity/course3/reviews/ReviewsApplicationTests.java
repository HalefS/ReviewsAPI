package com.udacity.course3.reviews;

import com.udacity.course3.reviews.domain.Comment;
import com.udacity.course3.reviews.domain.Product;
import com.udacity.course3.reviews.domain.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import com.udacity.course3.reviews.service.CommentNotFoundException;
import com.udacity.course3.reviews.service.ProductNotFoundException;
import com.udacity.course3.reviews.service.ReviewNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@RunWith(SpringRunner.class)
public class ReviewsApplicationTests {


	@Autowired private DataSource dataSource;
	@Autowired private EntityManager entityManager;
	@Autowired private JdbcTemplate jdbcTemplate;
	@Autowired private ProductRepository productRepository;
	@Autowired private CommentRepository commentRepository;
	@Autowired private ReviewRepository reviewRepository;


	@Test
	public void injectedComponentsNotNull() {
		assertThat(dataSource).isNotNull();
		assertThat(entityManager).isNotNull();
		assertThat(jdbcTemplate).isNotNull();
		assertThat(productRepository).isNotNull();
	}

	@Test
	public void insertedProductFoundByName() {
		Product product = new Product();
		product.setName("Football");
		product.setStockCount(100);
		product.setDescription("Superbowl 21 footballs");
		productRepository.save(product);

		assertThat(productRepository.findByName("Football")).isNotNull();
	}

	@Test
	public void reviewsForProductFound() {
		Collection<Review> reviews = Arrays.asList(
				new Review("Wow", 5, "This is awesome", List.of(), "HalefS"),
				new Review("Value", 4, "Great value for your buck", List.of(), "HalefS")
		);
		Product product = new Product(reviews, "Timberland Boot", "Timberland 6 inches boot", 56);
		productRepository.save(product);
		Product saved = productRepository.findByName("Timberland Boot").orElseThrow(ProductNotFoundException::new);
		assertThat(saved.getReviews().size()).isEqualTo(2);
	}

	@Test
	public void insertedReviewFoundByName() {
		Review review = new Review("Wow", 5, "This is amazing", List.of(), "Anonymous");
		reviewRepository.save(review);
		assertThat(review).isNotNull();
	}

	@Test
	public void commentsForInsertedReviewFound() {
		Collection<Comment> comments = List.of(
				new Comment("Thanks for leaving your review", "Review Author"),
				new Comment("Very Helpful", "Anonymous")
		);
		Review review = new Review("Wow", 5, "This is awesome", List.of(), "HalefS");
		review.setComments(comments);
		reviewRepository.save(review);

		Review saved = reviewRepository.findById(1L).orElseThrow(ReviewNotFoundException::new);
		assertThat(saved.getComments()).size().isEqualTo(2);
	}

	@Test
	public void insertedCommentFoundById() {
		Comment comment = new Comment("Superb review", "HalefS");
		commentRepository.save(comment);

		Comment saved = commentRepository.findById(1L).orElseThrow(CommentNotFoundException::new);
		assertThat(saved).isNotNull();
	}



}