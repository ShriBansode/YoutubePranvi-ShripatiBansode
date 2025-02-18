package com.example.moviereview.service;

import com.example.moviereview.model.Movie;
import com.example.moviereview.model.Review;
import com.example.moviereview.repository.MovieRepository;
import com.example.moviereview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    public Review addReview(Long movieId, Review review) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {
            review.setMovie(movie.get()); // Associate review with movie
            return reviewRepository.save(review); // Save review
        }
        return null;
    }
}
