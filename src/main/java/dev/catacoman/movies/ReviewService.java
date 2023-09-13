package dev.catacoman.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId)
    {
        Review review = reviewRepository.insert(new Review(reviewBody));
//using a template to import an update on the movie class
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId)) //which movie are we updating
                .apply(new Update().push("reviewIds").value(review))//applying the update and pushing a new review id into the empty review ids array
                .first();

        return review;

    }
}
