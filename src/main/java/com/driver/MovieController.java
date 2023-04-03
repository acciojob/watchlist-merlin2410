package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    //1
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)
    {
        String msg = movieService.addMovie(movie);

        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    //2
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        String msg = movieService.addDirector(director);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    //3
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName, @RequestParam String directorName)
    {
        String msg = movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    //4
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name)
    {
        Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    //5
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name)
    {
        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    //6
    @GetMapping("/get-movies-by-director-name/{name}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String name)
    {
        List<String> movieList = movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(movieList, HttpStatus.CREATED);
    }

    //7
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies()
    {
        List<String> movieList = movieService.findAllMovies();
        return new ResponseEntity<>(movieList, HttpStatus.CREATED);
    }

    //8
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String name)
    {
        String msg = movieService.deleteDirectorByName(name);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    //9
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        String msg = movieService.deleteAllDirectors();
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

}
