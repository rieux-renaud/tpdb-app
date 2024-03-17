package com.javaproject.nfe114v17.user;

import com.javaproject.nfe114v17.movie.Movie;
import com.javaproject.nfe114v17.tmdbApi.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "user/{userName}")
    public ResponseEntity<User> getUser(@PathVariable String userName) {
        User user = userService.getUserByUserName(userName);
        return ResponseEntity.ok(user);
    }

    @PostMapping(path = "user/add", produces = "application/json")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        this.userService.addNewUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("User added successfully");
    }

//    @RequestMapping(value = "user/{userName}/statistics", method = RequestMethod.GET)
//    public String getStatistics(@PathVariable String userName, Model model) {
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentUser = authentication.getName();
//        model.addAttribute("currentUser", currentUser);
//
//
//        User user = userService.getUserByUserName(userName);
//        int timeSpentWatching = userService.getTimeSpentWatching(user);
//        int favoriteRealeasedYear = userService.getFavoriteRealeasedYear(user);
//        int numberOfMovies = userService.findNumberOfMovies(user);
//        model.addAttribute("timeSpentWatching", timeSpentWatching);
//        model.addAttribute("favoriteRealeasedYear", favoriteRealeasedYear);
//        model.addAttribute("numberOfMovies", numberOfMovies);
//        return "";
//    }


//    @RequestMapping(path = "/register", method = RequestMethod.GET)
//    public String showSignUpForm(Model model) {
//        model.addAttribute("user", new User());
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentUser = authentication.getName();
//        model.addAttribute("currentUser", currentUser);
//    }

}

