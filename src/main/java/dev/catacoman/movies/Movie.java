package dev.catacoman.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection ="movies")
@Data //annotation that creates all the getters and setters needed for this class
@AllArgsConstructor //annotation that creates all the constructors
@NoArgsConstructor //annotation that creates all constructors without inputs
public class Movie {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster; //link to an image poster
    private List<String> genres;
    private List<String> backdrops; //list of links to an image backdrop
    @DocumentReference
    private List<Review> reviewIds;


}
