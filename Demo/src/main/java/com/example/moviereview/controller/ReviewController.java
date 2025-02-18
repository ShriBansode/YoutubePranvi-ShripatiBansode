package com.example.moviereview.controller;

import com.example.moviereview.model.Review;
import com.example.moviereview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies/{movieId}/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public Review addReview(@PathVariable Long movieId, @RequestBody Review review) {
        return reviewService.addReview(movieId, review);
    }
}
