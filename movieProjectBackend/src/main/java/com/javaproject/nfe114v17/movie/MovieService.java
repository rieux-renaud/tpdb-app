package com.javaproject.nfe114v17.movie;

import com.javaproject.nfe114v17.tmdbApi.NotFoundException;
import com.javaproject.nfe114v17.user.User;
import com.javaproject.nfe114v17.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private final MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovie() {
        return movieRepository.findAll();
    }

    @PostMapping
    public void addNewMovie(Movie movie) {
        Optional<Movie> movieByTitle = movieRepository.findByTitle(movie.getTitle());
        if (!movieByTitle.isPresent()){
            movieRepository.save(movie);
        }
    }

    public ResponseEntity<String> addSeenMovie(String userName, Movie movie) throws NotFoundException {
        try {
            User user = userRepository.findByUserName(userName.toString()).orElseThrow(() -> new NotFoundException());
            movieRepository.save(movie);
            user.addSeenMovie(movie);
            userRepository.save(user);
            return ResponseEntity.ok("Added successfully");
        }
        catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

}
