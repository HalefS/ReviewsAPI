package com.udacity.course3.reviews;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReviewsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReviewsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://localhost:3306/reviews_api", "halef",
				"SUVG3aaD").load();

		flyway.migrate();

	}
}