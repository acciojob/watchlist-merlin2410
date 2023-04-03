package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Repository
public class MovieRepository {

    HashMap<String, Movie> movieDb = new HashMap<>();
    HashMap<String, Director> directorDb = new HashMap<>();
    HashMap<Movie, Director> movieDirector = new HashMap<>();

    public String addMovie(Movie movie)
    {
        String name = movie.getName();
        movieDb.put(name,movie);
        return "Movie added Successfully";
    }

    public String addDirector(Director director)
    {
        String name = director.getName();
        directorDb.put(name, director);
        return "Director added Successfully";
    }

    public  String addMovieDirectorPair(String movieName, String directorName)
    {
        Movie movie = movieDb.get(movieName);
        Director director = directorDb.get(directorName);
        movieDirector.put(movie,director);
        return "Movie with Director added Successfully";
    }

    public Movie getMovieByName(String name)
    {
        Movie movie = movieDb.get(name);
        return movie;
    }

    public Director getDirectorByName(String name)
    {
        Director director = directorDb.get(name);
        return director;
    }

    public List<String> getMoviesByDirectorName(String name)
    {
        List<String> movieList = new ArrayList<>();
        for(Movie movie: movieDirector.keySet())
        {
            Director director = movieDirector.get(movie);
            if(director.getName().equals(name))
            {
                movieList.add(movie.getName());
            }
        }
        return movieList;
    }

    public List<String> findAllMovies()
    {
        List allMovies = new ArrayList<>();
        for(Movie movie: movieDb.values())
        {
            allMovies.add(movie.getName());
        }
        return allMovies;
    }

    public String deleteDirectorByName(String name)
    {
        Director director = directorDb.get(name);
        directorDb.remove(name);
        for(Movie movie: movieDirector.keySet())
        {
            if(director.equals(movieDirector.get(movie)))
            {
                movieDirector.remove(movie);
            }
        }
        return "Director removed Successfully";
    }

    public String deleteAllDirectors()
    {
        directorDb.clear();
        for(Movie movie: movieDirector.keySet())
        {
            movieDb.remove(movie.getName());
        }
        movieDirector.clear();

        return "All Director removed Successfully";
    }

}
