package com.javaproject.nfe114v17.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaproject.nfe114v17.movie.Movie;
import lombok.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;
import java.util.*;

//@Data
@ToString
@NoArgsConstructor
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "seen_movies",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<Movie> seenMovies = new HashSet<>();

    public User(String userName, String password) {
        this.userId = 0;
        this.userName = userName;
        this.password = password;
        this.seenMovies = null;
    }

    public void addSeenMovie(Movie movie){
        seenMovies.add(movie);
    }

}
