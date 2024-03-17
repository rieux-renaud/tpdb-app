package com.javaproject.nfe114v17.movie;

import com.javaproject.nfe114v17.tmdbApi.NotFoundException;
import com.javaproject.nfe114v17.tmdbApi.TmdbApiClient;
import com.javaproject.nfe114v17.user.User;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {

    private final MovieService movieService;
    private final TmdbApiClient tmdbApiClient;

    public MovieController(MovieService movieService, TmdbApiClient tmdbApiClient) {
        this.movieService = movieService;
        this.tmdbApiClient = tmdbApiClient;
    }

//    @RequestMapping(value = "/search", method = RequestMethod.GET)
//    public List<Movie> searchMovie(String model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentUser = authentication.getName();
//        return "searchform";
//    }

    @RequestMapping(value = "/search/{query}", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> searchMovie(@PathVariable String query) throws NotFoundException, JSONException, IOException, InterruptedException {
        List<Movie> movies = tmdbApiClient.searchMovie(query);
        return ResponseEntity.ok(movies);
    }

    @RequestMapping(value = "movie/{movieId}", method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovieById(@PathVariable String movieId) throws IOException, InterruptedException, NotFoundException {
        int parsedMovieId = Integer.parseInt(movieId);
        Movie movie = tmdbApiClient.getMovieById(parsedMovieId);
        movieService.addNewMovie(movie);
        return ResponseEntity.ok(movie);
    }

    @PostMapping(path = "user/{userName}/movie/{movieId}")
    public ResponseEntity<String> addSeenMovie(@PathVariable String userName, @PathVariable int movieId) throws NotFoundException, IOException, InterruptedException {
        Movie movie = tmdbApiClient.getMovieById(movieId);
        return movieService.addSeenMovie(userName, movie);
    }
}
